package com.sovadeveloper.petClinic.services.impl;

import com.sovadeveloper.petClinic.dto.PetDTO;
import com.sovadeveloper.petClinic.entities.PetEntity;
import com.sovadeveloper.petClinic.repositories.ClientRepo;
import com.sovadeveloper.petClinic.repositories.PetRepo;
import com.sovadeveloper.petClinic.repositories.PetTypeRepo;
import com.sovadeveloper.petClinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepo petRepo;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private PetTypeRepo petTypeRepo;


    @Override
    public PetDTO create(PetEntity petEntity) throws Exception {
        clientRepo.findById(petEntity.getClient().getId())
                .orElseThrow(() -> new Exception("Такого клиента не существует"));
        petTypeRepo.findById(petEntity.getPetType().getId())
                .orElseThrow(() -> new Exception("Такого типа животного не существует"));
        return PetDTO.toModel(petRepo.save(petEntity));
    }

    @Override
    public PetDTO getById(Long id) throws Exception {
        return PetDTO.toModel(petRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого питомца не существует")));
    }

    @Override
    public PetDTO edit(Long id, PetEntity petEntityUpdated) throws Exception {
        PetEntity petEntity = petRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого питомца не существует"));
        clientRepo.findById(petEntityUpdated.getClient().getId())
                .orElseThrow(() -> new Exception("Такого клиента не существует"));
        petTypeRepo.findById(petEntity.getPetType().getId())
                .orElseThrow(() -> new Exception("Такого типа животного не существует"));
        petEntity.setName(petEntityUpdated.getName());
        return PetDTO.toModel(petRepo.save(petEntity));
    }

    @Override
    public Long delete(Long id) throws Exception {
        PetEntity petEntity = petRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого питомца не существует"));
        petRepo.delete(petEntity);
        return id;
    }

    @Override
    public List<PetDTO> getAll() throws Exception {
        List<PetEntity> petEntities = (List<PetEntity>) petRepo.findAll();
        List<PetDTO> petDTOS = new ArrayList<>();
        for(PetEntity petEntity: petEntities){
            petDTOS.add(PetDTO.toModel(petEntity));
        }
        return petDTOS;
    }
}
