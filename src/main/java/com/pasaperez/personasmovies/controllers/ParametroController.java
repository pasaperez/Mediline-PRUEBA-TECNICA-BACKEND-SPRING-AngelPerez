package com.pasaperez.personasmovies.controllers;

import com.pasaperez.personasmovies.entities.Parametro;
import com.pasaperez.personasmovies.exceptions.AlreadyExistException;
import com.pasaperez.personasmovies.exceptions.DefaultException;
import com.pasaperez.personasmovies.exceptions.NotFoundException;
import com.pasaperez.personasmovies.services.ParametroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/parametro")
public class ParametroController extends BaseController<Parametro, ParametroService> {
    public ParametroController(ParametroService servicio) {
        super(servicio);
    }

    @Override
    public ResponseEntity<Parametro> create(Parametro entity) throws AlreadyExistException {
        throw new DefaultException("No Soportado");
    }

    @Override
    public ResponseEntity<Parametro> getById(Long id) throws NotFoundException {
        throw new DefaultException("No Soportado");
    }

    @Override
    public ResponseEntity<List<Parametro>> getAll() {
        throw new DefaultException("No Soportado");
    }

    @Override
    public ResponseEntity<Parametro> update(Long id, Parametro entity) throws NotFoundException {
        return super.update(1L, entity);
    }

    @Override
    public ResponseEntity<Parametro> delete(Long id) throws NotFoundException {
        throw new DefaultException("No Soportado");
    }
}