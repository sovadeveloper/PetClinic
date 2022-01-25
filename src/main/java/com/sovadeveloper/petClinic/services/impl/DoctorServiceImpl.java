package com.sovadeveloper.petClinic.services.impl;

import com.sovadeveloper.petClinic.dto.DoctorDTO;
import com.sovadeveloper.petClinic.entities.DoctorEntity;
import com.sovadeveloper.petClinic.repositories.DoctorRepo;
import com.sovadeveloper.petClinic.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public DoctorDTO create(DoctorEntity doctorEntity) throws Exception {
        return DoctorDTO.toModel(doctorRepo.save(doctorEntity));
    }

    @Override
    public DoctorDTO getById(Long id) throws Exception {
        return DoctorDTO.toModel(doctorRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого доктора не существует")));
    }

    @Override
    public DoctorDTO edit(Long id, DoctorEntity doctorEntityUpdated) throws Exception {
        DoctorEntity doctorEntity = doctorRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого доктора не существует"));
        doctorEntity.setName(doctorEntityUpdated.getName());
        return DoctorDTO.toModel(doctorRepo.save(doctorEntity));
    }

    @Override
    public Long delete(Long id) throws Exception {
        DoctorEntity doctorEntity = doctorRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого доктора не существует"));
        doctorRepo.delete(doctorEntity);
        return id;
    }

    @Override
    public List<DoctorDTO> getAll() throws Exception {
        List<DoctorEntity> doctorEntities = (List<DoctorEntity>) doctorRepo.findAll();
        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        for(DoctorEntity doctorEntity: doctorEntities){
            doctorDTOS.add(DoctorDTO.toModel(doctorEntity));
        }
        return doctorDTOS;
    }
}
