package com.pasaperez.personasmovies.controllers;

import com.pasaperez.personasmovies.dtos.MovieDto;
import com.pasaperez.personasmovies.dtos.PersonaDTO;
import com.pasaperez.personasmovies.entities.Movie;
import com.pasaperez.personasmovies.exceptions.DefaultException;
import com.pasaperez.personasmovies.exceptions.NotFoundException;
import com.pasaperez.personasmovies.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movie")
public class MovieController extends BaseController<Movie, MovieService> {
    public MovieController(MovieService servicio) {
        super(servicio);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<PersonaDTO> getByPersona(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(servicio.findByPersona(id), HttpStatus.OK);
    }

    @PostMapping("/{idPersona}")
    public ResponseEntity<List<Movie>> addMovie(@PathVariable Long idPersona, @RequestBody MovieDto movie) throws NotFoundException {
        return new ResponseEntity<>(servicio.addMovie(idPersona, movie), HttpStatus.OK);
    }

    @DeleteMapping("/{idPersona}/{idMovie}")
    public ResponseEntity<List<Movie>> deleteMovie(@PathVariable Long idPersona, @PathVariable Long idMovie) throws NotFoundException {
        return new ResponseEntity<>(servicio.deleteMovie(idPersona, idMovie), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Movie> create(Movie entity) {
        throw new DefaultException("No soportado.");
    }

    @Override
    public ResponseEntity<Movie> getById(Long id) {
        throw new DefaultException("No soportado.");
    }

    @Override
    public ResponseEntity<Movie> update(Long id, Movie entity) {
        throw new DefaultException("No soportado.");
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<List<Movie>> getAll() {
        throw new DefaultException("No soportado.");
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Movie> delete(@PathVariable Long id) {
        throw new DefaultException("No soportado.");
    }
}