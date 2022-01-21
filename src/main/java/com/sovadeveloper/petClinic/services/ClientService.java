package com.sovadeveloper.petClinic.services;

import com.sovadeveloper.petClinic.entities.ClientEntity;

import java.util.List;

public interface ClientService {
    ClientEntity create(ClientEntity clientEntity) throws Exception;
    ClientEntity getById(Long id) throws Exception;
    ClientEntity edit(Long id, ClientEntity clientEntityUpdated) throws Exception;
    Long delete(Long id) throws Exception;
    List<ClientEntity> getAll() throws Exception;
}
