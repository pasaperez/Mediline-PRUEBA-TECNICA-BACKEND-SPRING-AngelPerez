package com.pasaperez.personasmovies.exceptions;

public class NotFoundException extends ResponseException {
    public NotFoundException(String id) {
        super("No se encontro el recurso con : "+id, "NotFoundException");
    }
}