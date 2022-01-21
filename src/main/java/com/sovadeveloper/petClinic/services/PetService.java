package com.sovadeveloper.petClinic.services;

import com.sovadeveloper.petClinic.entities.PetEntity;

import java.util.List;

public interface PetService {
    PetEntity create(PetEntity petEntity) throws Exception;
    PetEntity getById(Long id) throws Exception;
    PetEntity edit(Long id, PetEntity petEntity) throws Exception;
    Long delete(Long id) throws Exception;
    List<PetEntity> getAll() throws Exception;
}
