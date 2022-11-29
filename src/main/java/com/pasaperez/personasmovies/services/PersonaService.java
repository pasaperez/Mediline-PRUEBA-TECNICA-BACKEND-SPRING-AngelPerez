package com.pasaperez.personasmovies.services;

import com.pasaperez.personasmovies.entities.Persona;
import com.pasaperez.personasmovies.exceptions.NotFoundException;
import com.pasaperez.personasmovies.repositories.BaseRepository;
import com.pasaperez.personasmovies.repositories.PersonaRepository;
import com.pasaperez.personasmovies.services.interfaces.IPersonaService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService extends BaseService<Persona, Long> implements IPersonaService {

    protected final PersonaRepository personaRepository;

    public PersonaService(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository) {
        super(baseRepository);
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> findAll() {
        return baseRepository.findAll((Sort.by("lastName").and(Sort.by("firstName"))));
    }

    @Override
    public Persona findByFirstName(String name) throws NotFoundException {
        Optional<Persona> optional = personaRepository.findByFirstName(name);

        if (optional.isEmpty()){
            throw new NotFoundException(name);
        }
        return optional.get();
    }

    @Override
    public Persona update(Long id, Persona entity) throws NotFoundException {
        Optional<Persona> optional  = baseRepository.findById(id);

        if (optional.isEmpty()){
            throw new NotFoundException(String.valueOf(id));
        }
        entity.setId(optional.get().getId());

        if (entity.getBirthdate() == null) {
            entity.setBirthdate(optional.get().getBirthdate());
        }
        if (entity.getFirstName() == null) {
            entity.setFirstName(optional.get().getFirstName());
        }
        if (entity.getLastName() == null) {
            entity.setLastName(optional.get().getLastName());
        }
        if (entity.getHasInsurance() == null) {
            entity.setHasInsurance(optional.get().getHasInsurance());
        }

        return baseRepository.save(entity);
    }
}