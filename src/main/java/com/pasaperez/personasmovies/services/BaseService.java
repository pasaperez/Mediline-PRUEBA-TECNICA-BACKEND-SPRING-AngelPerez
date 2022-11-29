package com.pasaperez.personas-movies.services;

import com.pasaperez.personas-movies.dtos.APIResponse;
import com.pasaperez.personas-movies.dtos.mapper.MapperBase;
import com.pasaperez.personas-movies.entities.Base;
import com.pasaperez.personas-movies.exceptions.AlreadyExistException;
import com.pasaperez.personas-movies.exceptions.NotFoundException;
import com.pasaperez.personas-movies.repositories.BaseRepository;
import com.pasaperez.personas-movies.services.interfaces.IBaseService;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseService <E extends Base, ID extends Serializable> implements IBaseService<E, ID> {

    protected BaseRepository<E, ID> baseRepository;

    public BaseService(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public APIResponse<E> create(E entity) throws AlreadyExistException {
        if(checkIfExist(entity)){
            throw new AlreadyExistException();
        }
        return MapperBase.toDTO(baseRepository.save(entity));
    }

    @Override
    public boolean checkIfExist(E entity) {
        List<E> entitiesList = baseRepository.findAll();

        for(E eachEntity :entitiesList){
            if(eachEntity.equals(entity)){
                return true;
            }
        }
        return false;
    }

    @Override
    public APIResponse<E> findById(ID id) throws NotFoundException {
        Optional<E> optional = baseRepository.findById(id);

        if (optional.isEmpty()){
            throw new NotFoundException(String.valueOf(id));
        }
        return MapperBase.toDTO(optional.get());
    }

    @Override
    public APIResponse<List<E>> findAll() {
        return APIResponse.<List<E>>builder().data(baseRepository.findAll()).build();
    }

    @Override
    public APIResponse<E> update(ID id, E entity) throws NotFoundException {
        Optional<E> optional  = baseRepository.findById(id);

        if (optional.isEmpty()){
            throw new NotFoundException(String.valueOf(id));
        }
        entity.setId(optional.get().getId());
        return MapperBase.toDTO(baseRepository.save(entity));
    }

    @Override
    public APIResponse<E> delete(ID id) throws NotFoundException {
        Optional<E> optional  = baseRepository.findById(id);

        if (optional.isEmpty()){
            throw new NotFoundException(String.valueOf(id));
        }
        E entityDelete = optional.get();
        baseRepository.delete(entityDelete);
        return MapperBase.toDTO(entityDelete);
    }
}