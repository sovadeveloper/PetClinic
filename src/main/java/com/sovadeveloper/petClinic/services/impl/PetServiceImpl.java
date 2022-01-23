package com.sovadeveloper.petClinic.services.impl;

import com.sovadeveloper.petClinic.entities.ClientEntity;
import com.sovadeveloper.petClinic.entities.PetEntity;
import com.sovadeveloper.petClinic.repositories.ClientRepo;
import com.sovadeveloper.petClinic.repositories.PetRepo;
import com.sovadeveloper.petClinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepo petRepo;

    @Autowired
    private ClientRepo clientRepo;


    @Override
    public PetEntity create(PetEntity petEntity) throws Exception {
        clientRepo.findById(petEntity.getClient().getId())
                .orElseThrow(() -> new Exception("Такого клиента не существует"));
        return petRepo.save(petEntity);
    }

    @Override
    public PetEntity getById(Long id) throws Exception {
        return petRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого питомца не существует"));
    }

    @Override
    public PetEntity edit(Long id, PetEntity petEntityUpdated) throws Exception {
        PetEntity petEntity = petRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого питомца не существует"));
        clientRepo.findById(petEntityUpdated.getClient().getId())
                .orElseThrow(() -> new Exception("Такого клиента не существует"));
        petEntity.setName(petEntityUpdated.getName());
        return petRepo.save(petEntity);
    }

    @Override
    public Long delete(Long id) throws Exception {
        PetEntity petEntity = petRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого питомца не существует"));
        petRepo.delete(petEntity);
        return id;
    }

    @Override
    public List<PetEntity> getAll() throws Exception {
        return (List<PetEntity>) petRepo.findAll();
    }
}
