package com.pasaperez.personas-movies.controllers;

import com.pasaperez.personas-movies.entities.Base;
import com.pasaperez.personas-movies.exceptions.AlreadyExistException;
import com.pasaperez.personas-movies.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

@SuppressWarnings("unused")
public interface IBaseController<E extends Base, ID extends Serializable> {

    ResponseEntity<?> create(@RequestBody E entity) throws AlreadyExistException;
    ResponseEntity<?> getById(@PathVariable ID id) throws NotFoundException;
    ResponseEntity<?> getAll();
    ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity) throws NotFoundException;
    ResponseEntity<?> delete(@PathVariable ID id) throws NotFoundException;
}