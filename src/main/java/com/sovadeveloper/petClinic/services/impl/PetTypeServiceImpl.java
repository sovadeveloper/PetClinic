package com.sovadeveloper.petClinic.services.impl;

import com.sovadeveloper.petClinic.dto.PetTypeDTO;
import com.sovadeveloper.petClinic.entities.PetTypeEntity;
import com.sovadeveloper.petClinic.repositories.PetTypeRepo;
import com.sovadeveloper.petClinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetTypeServiceImpl implements PetTypeService {
    @Autowired
    private PetTypeRepo petTypeRepo;

    @Override
    public PetTypeDTO create(PetTypeEntity petTypeEntity) throws Exception {
        return PetTypeDTO.toModel(petTypeRepo.save(petTypeEntity));
    }

    @Override
    public PetTypeDTO getById(Long id) throws Exception {
        return PetTypeDTO.toModel(petTypeRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого типа животного не существует")));
    }

    @Override
    public PetTypeDTO edit(Long id, PetTypeEntity petTypeEntityUpdated) throws Exception {
        PetTypeEntity petTypeEntity = petTypeRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого типа животного не существует"));
        petTypeEntity.setName(petTypeEntityUpdated.getName());
        return PetTypeDTO.toModel(petTypeRepo.save(petTypeEntity));
    }

    @Override
    public Long delete(Long id) throws Exception {
        PetTypeEntity petTypeEntity = petTypeRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого типа животного не существует"));
        petTypeRepo.delete(petTypeEntity);
        return id;
    }

    @Override
    public List<PetTypeDTO> getAll() throws Exception {
        List<PetTypeEntity> petTypeEntities = (List<PetTypeEntity>) petTypeRepo.findAll();
        List<PetTypeDTO> petTypeDTOS = new ArrayList<>();
        for(PetTypeEntity petTypeEntity: petTypeEntities){
            petTypeDTOS.add(PetTypeDTO.toModel(petTypeEntity));
        }
        return petTypeDTOS;
    }
}
