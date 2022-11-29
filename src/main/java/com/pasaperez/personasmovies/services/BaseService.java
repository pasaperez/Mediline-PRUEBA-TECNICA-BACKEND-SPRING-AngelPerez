package com.pasaperez.personasmovies.services;

import com.pasaperez.personasmovies.entities.Base;
import com.pasaperez.personasmovies.exceptions.AlreadyExistException;
import com.pasaperez.personasmovies.exceptions.NotFoundException;
import com.pasaperez.personasmovies.repositories.BaseRepository;
import com.pasaperez.personasmovies.services.interfaces.IBaseService;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseService <E extends Base, ID extends Serializable> implements IBaseService<E, ID> {

    protected BaseRepository<E, ID> baseRepository;

    public BaseService(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public E create(E entity) throws AlreadyExistException {
        if(checkIfExist(entity)){
            throw new AlreadyExistException();
        }
        return baseRepository.save(entity);
    }

    @Override
    public boolean checkIfExist(E entity) {
        List<E> entitiesList = baseRepository.findAll();

        for(E eachEntity :entitiesList){
            if(eachEntity.equals(entity)){
                return true;
            }
        }
        return false;
    }

    @Override
    public E findById(ID id) throws NotFoundException {
        Optional<E> optional = baseRepository.findById(id);

        if (optional.isEmpty()){
            throw new NotFoundException(String.valueOf(id));
        }
        return optional.get();
    }

    @Override
    public List<E> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public E update(ID id, E entity) throws NotFoundException {
        Optional<E> optional  = baseRepository.findById(id);

        if (optional.isEmpty()){
            throw new NotFoundException(String.valueOf(id));
        }
        entity.setId(optional.get().getId());
        return baseRepository.save(entity);
    }

    @Override
    public E delete(ID id) throws NotFoundException {
        Optional<E> optional  = baseRepository.findById(id);

        if (optional.isEmpty()){
            throw new NotFoundException(String.valueOf(id));
        }
        E entityDelete = optional.get();
        baseRepository.delete(entityDelete);
        return entityDelete;
    }
}