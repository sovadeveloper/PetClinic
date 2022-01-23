package com.sovadeveloper.petClinic.services;

import com.sovadeveloper.petClinic.entities.DoctorEntity;

import java.util.List;

public interface DoctorService {
    DoctorEntity create(DoctorEntity doctorEntity) throws Exception;
    DoctorEntity getById(Long id) throws Exception;
    DoctorEntity edit(Long id, DoctorEntity doctorEntityUpdated) throws Exception;
    Long delete(Long id) throws Exception;
    List<DoctorEntity> getAll() throws Exception;
}
