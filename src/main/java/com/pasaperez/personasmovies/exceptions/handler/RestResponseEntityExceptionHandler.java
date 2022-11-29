package com.pasaperez.personasmovies.exceptions.handler;

import com.pasaperez.personasmovies.dtos.APIResponse;
import com.pasaperez.personasmovies.dtos.ErrorDTO;
import com.pasaperez.personasmovies.exceptions.AlreadyExistException;
import com.pasaperez.personasmovies.exceptions.DefaultException;
import com.pasaperez.personasmovies.exceptions.NotFoundException;
import com.pasaperez.personasmovies.exceptions.ResponseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(value= { DefaultException.class })
    protected ResponseEntity<String> handleDefaultConflict(RuntimeException ex) {
        return new ResponseEntity<>("Manejador de Errores: \n" + ex.getMessage(),
                new HttpHeaders(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value= { NotFoundException.class })
    protected ResponseEntity<APIResponse<?>> handleNotFoundConflict(ResponseException ex) {
        return new ResponseEntity<>(APIResponse.builder()
                .status("FAILED")
                .error(Collections.singletonList(new ErrorDTO("", ex.getMessage())))
                .build(),
                new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value= { AlreadyExistException.class })
    protected ResponseEntity<APIResponse<?>> handleAlreadyExistConflict(ResponseException ex) {
        return new ResponseEntity<>(APIResponse.builder()
                .status("FAILED")
                .error(Collections.singletonList(new ErrorDTO("", ex.getMessage())))
                .build(),
                new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}