package com.sovadeveloper.petClinic.services.impl;

import com.sovadeveloper.petClinic.entities.ClientEntity;
import com.sovadeveloper.petClinic.repositories.ClientRepo;
import com.sovadeveloper.petClinic.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepo clientRepo;

    @Override
    public ClientEntity create(ClientEntity clientEntity) throws Exception {
        ClientEntity clientEntityCheckPhone = clientRepo.findByPhone(clientEntity.getPhone());
        if(clientEntityCheckPhone != null && clientEntityCheckPhone.getPhone().equals(clientEntity.getPhone())){
            throw new Exception("Пользователь с данным номером уже существует");
        }
        return clientRepo.save(clientEntity);
    }

    @Override
    public ClientEntity getById(Long id) throws Exception {
        return clientRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого пользователя не существует"));
    }

    @Override
    public ClientEntity edit(Long id, ClientEntity clientEntityUpdated) throws Exception {
        ClientEntity clientEntity = clientRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого пользователя не существует"));
        ClientEntity clientEntityCheckPhone = clientRepo.findByPhone(clientEntity.getPhone());
        if(clientEntityCheckPhone != null && clientEntityCheckPhone.getPhone().equals(clientEntity.getPhone())){
            throw new Exception("Пользователь с данным номером уже существует");
        }
        clientEntity.setName(clientEntityUpdated.getName());
        clientEntity.setSurname(clientEntityUpdated.getSurname());
        clientEntity.setPhone(clientEntityUpdated.getPhone());
        return clientRepo.save(clientEntity);
    }

    @Override
    public Long delete(Long id) throws Exception {
        ClientEntity clientEntity = clientRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого пользователя не существует"));
        clientRepo.delete(clientEntity);
        return id;
    }

    @Override
    public List<ClientEntity> getAll() throws Exception {
        return (List<ClientEntity>) clientRepo.findAll();
    }
}
