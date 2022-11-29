package com.pasaperez.personas-movies.exceptions;

import lombok.Data;

@Data
public class ResponseException extends Exception {
    private String message;
    private String name;

    public ResponseException(String message, String name) {
        this.message = message;
        this.name = name;
    }
}