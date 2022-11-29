package com.pasaperez.personas-movies.services.interfaces;


import com.pasaperez.personas-movies.dtos.APIResponse;
import com.pasaperez.personas-movies.entities.Base;
import com.pasaperez.personas-movies.exceptions.AlreadyExistException;
import com.pasaperez.personas-movies.exceptions.NotFoundException;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<E extends Base, ID extends Serializable> {
    APIResponse<E> create(E entity) throws AlreadyExistException;
    boolean checkIfExist(E entity);
    APIResponse<List<E>> findAll();
    APIResponse<E> findById(ID id) throws NotFoundException;
    APIResponse<E> update(ID id, E entity) throws NotFoundException;
    APIResponse<E> delete(ID id) throws NotFoundException;
}