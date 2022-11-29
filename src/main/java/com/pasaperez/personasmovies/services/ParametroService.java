package com.pasaperez.personasmovies.services;

import com.pasaperez.personasmovies.entities.Parametro;
import com.pasaperez.personasmovies.repositories.BaseRepository;
import com.pasaperez.personasmovies.services.interfaces.IParametroService;
import org.springframework.stereotype.Service;

@Service
public class ParametroService extends BaseService<Parametro, Long> implements IParametroService {
    public ParametroService(BaseRepository<Parametro, Long> baseRepository) {
        super(baseRepository);
    }
}