package com.pasaperez.personasmovies.services.interfaces;

import com.pasaperez.personasmovies.dtos.MovieDto;
import com.pasaperez.personasmovies.dtos.PersonaDTO;
import com.pasaperez.personasmovies.entities.Movie;
import com.pasaperez.personasmovies.exceptions.AlreadyExistException;
import com.pasaperez.personasmovies.exceptions.NotFoundException;

import java.util.List;

public interface IMovieService extends IBaseService<Movie, Long> {
    PersonaDTO findByPersona(Long idPersona) throws NotFoundException;
    List<Movie> addMovie(Long idPersona, MovieDto movie) throws NotFoundException, AlreadyExistException;
    List<Movie> deleteMovie(Long idPersona, Long idMovie) throws NotFoundException;

}