package com.pasaperez.personasmovies.services.interfaces;

import com.pasaperez.personasmovies.entities.Persona;
import com.pasaperez.personasmovies.exceptions.NotFoundException;

public interface IPersonaService extends IBaseService<Persona, Long> {
    Persona findByFirstName(String name) throws NotFoundException;
}