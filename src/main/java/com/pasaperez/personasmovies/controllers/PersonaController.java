package com.pasaperez.personasmovies.controllers;

import com.pasaperez.personasmovies.entities.Persona;
import com.pasaperez.personasmovies.exceptions.NotFoundException;
import com.pasaperez.personasmovies.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/personas")
public class PersonaController extends BaseController<Persona, PersonaService> {
    public PersonaController(PersonaService servicio) {
        super(servicio);
    }


    @GetMapping("name/{name}")
    public ResponseEntity<Persona> getByFirstName(@PathVariable String name) throws NotFoundException {
        return new ResponseEntity<>(servicio.findByFirstName(name), HttpStatus.OK);
    }
}