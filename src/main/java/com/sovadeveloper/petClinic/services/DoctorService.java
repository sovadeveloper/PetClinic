package com.sovadeveloper.petClinic.services;

import com.sovadeveloper.petClinic.dto.DoctorDTO;
import com.sovadeveloper.petClinic.entities.DoctorEntity;

import java.util.List;

public interface DoctorService {
    DoctorDTO create(DoctorEntity doctorEntity) throws Exception;
    DoctorDTO getById(Long id) throws Exception;
    DoctorDTO edit(Long id, DoctorEntity doctorEntityUpdated) throws Exception;
    Long delete(Long id) throws Exception;
    List<DoctorDTO> getAll() throws Exception;
}
