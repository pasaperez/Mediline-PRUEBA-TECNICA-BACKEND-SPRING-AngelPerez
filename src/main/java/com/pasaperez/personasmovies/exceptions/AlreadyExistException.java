package com.pasaperez.personasmovies.exceptions;

public class AlreadyExistException extends ResponseException {
    public AlreadyExistException() {
        super("El recurso ya existe", "AlreadyExistException");
    }
}