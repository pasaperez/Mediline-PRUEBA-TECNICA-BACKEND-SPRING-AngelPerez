package com.pasaperez.personasmovies.repositories;

import com.pasaperez.personasmovies.entities.Persona;

import java.util.Optional;

public interface PersonaRepository extends BaseRepository<Persona, Long> {
    Optional<Persona> findByFirstName(String name);
}