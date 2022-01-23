package com.sovadeveloper.petClinic.services;

import com.sovadeveloper.petClinic.entities.PetTypeEntity;

import java.util.List;

public interface PetTypeService {
    PetTypeEntity create(PetTypeEntity petTypeEntity) throws Exception;
    PetTypeEntity getById(Long id) throws Exception;
    PetTypeEntity edit(Long id, PetTypeEntity petTypeEntityUpdated) throws Exception;
    Long delete(Long id) throws Exception;
    List<PetTypeEntity> getAll() throws Exception;
}
