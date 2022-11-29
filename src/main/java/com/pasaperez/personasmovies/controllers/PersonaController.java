package com.pasaperez.personasmovies.controllers;

import com.pasaperez.personasmovies.entities.Persona;
import com.pasaperez.personasmovies.services.RepositorioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/repositorio")
public class RepositorioController extends BaseController<Persona, RepositorioService> {
    public RepositorioController(RepositorioService servicio) {
        super(servicio);
    }
}