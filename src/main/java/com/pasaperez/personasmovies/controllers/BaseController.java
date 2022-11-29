package com.pasaperez.personas-movies.controllers;

import com.pasaperez.personas-movies.dtos.APIResponse;
import com.pasaperez.personas-movies.entities.Base;
import com.pasaperez.personas-movies.exceptions.AlreadyExistException;
import com.pasaperez.personas-movies.exceptions.NotFoundException;
import com.pasaperez.personas-movies.services.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController <E extends Base, S extends BaseService<E, Long>> implements IBaseController<E, Long> {

    protected S servicio;

    public BaseController(S servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/")
    @Override
    public ResponseEntity<APIResponse<E>> create(@Validated @RequestBody E entity) throws AlreadyExistException {
        return new ResponseEntity<>(servicio.create(entity), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<APIResponse<E>> getById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(servicio.findById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<APIResponse<List<E>>> getAll() {
        return new ResponseEntity<>(servicio.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<APIResponse<E>> update(@PathVariable Long id, @Validated @RequestBody E entity) throws NotFoundException {
        return new ResponseEntity<>(servicio.update(id, entity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<APIResponse<E>> delete(@PathVariable Long id) throws NotFoundException {
        return servicio.delete(id)!=null ? new ResponseEntity<>(null, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }
}