package com.pasaperez.personasmovies.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class RepositorioDto implements Serializable {
    private final Long id;
    private final String nombre;
}