package com.pasaperez.personasmovies.services;

import com.pasaperez.personasmovies.dtos.MovieDto;
import com.pasaperez.personasmovies.dtos.PersonaDTO;
import com.pasaperez.personasmovies.entities.Movie;
import com.pasaperez.personasmovies.entities.Persona;
import com.pasaperez.personasmovies.exceptions.NotFoundException;
import com.pasaperez.personasmovies.repositories.BaseRepository;
import com.pasaperez.personasmovies.repositories.MovieRepository;
import com.pasaperez.personasmovies.repositories.PersonaRepository;
import com.pasaperez.personasmovies.services.interfaces.IMovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService extends BaseService<Movie, Long> implements IMovieService {

    protected final MovieRepository movieRepository;
    protected final PersonaRepository personaRepository;

    public MovieService(BaseRepository<Movie, Long> baseRepository, MovieRepository movieRepository, PersonaRepository personaRepository) {
        super(baseRepository);
        this.movieRepository = movieRepository;
        this.personaRepository = personaRepository;
    }

    @Override
    public PersonaDTO findByPersona(Long idPersona) throws NotFoundException {
        Optional<Persona> optional = personaRepository.findById(idPersona);

        if (optional.isEmpty()){
            throw new NotFoundException(String.valueOf(idPersona));
        }

        List<MovieDto> movieList= new ArrayList<>();
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setId(optional.get().getId());
        personaDTO.setFirstName(optional.get().getFirstName());
        personaDTO.setLastName(optional.get().getLastName());
        personaDTO.setBirthdate(optional.get().getBirthdate());
        personaDTO.setHasInsurance(optional.get().getHasInsurance());

        for (Movie movie : movieRepository.findByPersona(optional.get())) {
            MovieDto movie1 = new MovieDto(movie.getTitle(), movie.getGenre());

            movieList.add(movie1);
        }

        personaDTO.setFavourite_movies(movieList);

        return personaDTO;
    }

    @Override
    public List<Movie> addMovie(Long idPersona, MovieDto movie) throws NotFoundException {
        Optional<Persona> optional = personaRepository.findById(idPersona);

        if (optional.isEmpty()){
            throw new NotFoundException(String.valueOf(idPersona));
        }

        Movie movienew = new Movie();

        movienew.setPersona(optional.get());
        movienew.setTitle(movie.title());
        movienew.setGenre(movie.genre());

        movieRepository.save(movienew);

        return movieRepository.findByPersona(optional.get());
    }

    @Override
    public List<Movie> deleteMovie(Long idPersona, Long idMovie) throws NotFoundException {
        Optional<Persona> optional = personaRepository.findById(idPersona);
        Optional<Movie> optionalMovie = movieRepository.findById(idMovie);
        if (optional.isEmpty() || optionalMovie.isEmpty()){
            throw new NotFoundException(idPersona + " o " + idMovie);
        }

        movieRepository.delete(optionalMovie.get());

        return movieRepository.findByPersona(optional.get());
    }
}