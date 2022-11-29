package com.pasaperez.personas-movies.exceptions;

public class AlreadyExistException extends ResponseException {
    public AlreadyExistException() {
        super("El recurso ya existe", "AlreadyExistException");
    }
}