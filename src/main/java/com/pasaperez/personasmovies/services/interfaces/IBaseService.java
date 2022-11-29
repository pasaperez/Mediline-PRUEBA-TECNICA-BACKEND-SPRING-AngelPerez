package com.pasaperez.personasmovies.services.interfaces;


import com.pasaperez.personasmovies.dtos.APIResponse;
import com.pasaperez.personasmovies.entities.Base;
import com.pasaperez.personasmovies.exceptions.AlreadyExistException;
import com.pasaperez.personasmovies.exceptions.NotFoundException;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<E extends Base, ID extends Serializable> {
    E create(E entity) throws AlreadyExistException;
    boolean checkIfExist(E entity);
    List<E> findAll();
    E findById(ID id) throws NotFoundException;
    E update(ID id, E entity) throws NotFoundException;
    E delete(ID id) throws NotFoundException;
}