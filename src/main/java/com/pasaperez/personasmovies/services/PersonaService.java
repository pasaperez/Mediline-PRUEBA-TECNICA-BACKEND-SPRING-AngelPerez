package com.pasaperez.personasmovies.services;

import com.pasaperez.personasmovies.entities.Persona;
import com.pasaperez.personasmovies.repositories.BaseRepository;
import com.pasaperez.personasmovies.services.interfaces.IRepositorioService;
import org.springframework.stereotype.Service;

@Service
public class RepositorioService extends BaseService<Persona, Long> implements IRepositorioService {
    public RepositorioService(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }
}