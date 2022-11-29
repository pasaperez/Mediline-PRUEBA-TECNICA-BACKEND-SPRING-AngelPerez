package com.pasaperez.personasmovies.repositories;

import com.pasaperez.personasmovies.entities.Movie;
import com.pasaperez.personasmovies.entities.Persona;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends BaseRepository<Movie, Long> {
    List<Movie> findByPersona(Persona persona);
}