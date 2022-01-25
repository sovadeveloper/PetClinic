package com.sovadeveloper.petClinic.services;

import com.sovadeveloper.petClinic.dto.PetDTO;
import com.sovadeveloper.petClinic.entities.PetEntity;

import java.util.List;

public interface PetService {
    PetDTO create(PetEntity petEntity) throws Exception;
    PetDTO getById(Long id) throws Exception;
    PetDTO edit(Long id, PetEntity petEntity) throws Exception;
    Long delete(Long id) throws Exception;
    List<PetDTO> getAll() throws Exception;
}
