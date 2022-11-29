package com.pasaperez.personasmovies.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pasaperez.personasmovies.entities.Persona;
import lombok.Data;

import java.util.List;

@Data
public class PersonaDTO extends Persona {
    @JsonProperty("favourite-movies")
    private List<MovieDto> favourite_movies;
}
