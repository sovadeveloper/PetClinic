package com.sovadeveloper.petClinic.services.impl;

import com.sovadeveloper.petClinic.dto.ClientDTO;
import com.sovadeveloper.petClinic.entities.ClientEntity;
import com.sovadeveloper.petClinic.repositories.ClientRepo;
import com.sovadeveloper.petClinic.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepo clientRepo;

    @Override
    public ClientDTO create(ClientEntity clientEntity) throws Exception {
        ClientEntity clientEntityCheckPhone = clientRepo.findByPhone(clientEntity.getPhone());
        if(clientEntityCheckPhone != null && clientEntityCheckPhone.getPhone().equals(clientEntity.getPhone())){
            throw new Exception("Пользователь с данным номером уже существует");
        }
        return ClientDTO.toModel(clientRepo.save(clientEntity));
    }

    @Override
    public ClientDTO getById(Long id) throws Exception {
        return ClientDTO.toModel(clientRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого пользователя не существует")));
    }

    @Override
    public ClientDTO edit(Long id, ClientEntity clientEntityUpdated) throws Exception {
        ClientEntity clientEntity = clientRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого пользователя не существует"));
        ClientEntity clientEntityCheckPhone = clientRepo.findByPhone(clientEntityUpdated.getPhone());
        if(clientEntityCheckPhone != null && clientEntityCheckPhone.getPhone().equals(clientEntity.getPhone())
        && !clientEntityCheckPhone.getId().equals(clientEntity.getId())){
            throw new Exception("Пользователь с данным номером уже существует");
        }
        clientEntity.setName(clientEntityUpdated.getName());
        clientEntity.setSurname(clientEntityUpdated.getSurname());
        clientEntity.setPhone(clientEntityUpdated.getPhone());
        return ClientDTO.toModel(clientRepo.save(clientEntity));
    }

    @Override
    public Long delete(Long id) throws Exception {
        ClientEntity clientEntity = clientRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого пользователя не существует"));
        clientRepo.delete(clientEntity);
        return id;
    }

    @Override
    public List<ClientDTO> getAll() throws Exception {
        List<ClientEntity> clientEntities = (List<ClientEntity>) clientRepo.findAll();
        List<ClientDTO> clientDTOS = new ArrayList<>();
        for(ClientEntity clientEntity: clientEntities){
            clientDTOS.add(ClientDTO.toModel(clientEntity));
        }
        return clientDTOS;
    }
}
