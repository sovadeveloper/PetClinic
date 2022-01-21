package com.sovadeveloper.petClinic.repositories;

import com.sovadeveloper.petClinic.entities.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<ClientEntity, Long> {
    ClientEntity findByPhone(String phone);
}
