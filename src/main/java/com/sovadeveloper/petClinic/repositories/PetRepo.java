package com.sovadeveloper.petClinic.repositories;

import com.sovadeveloper.petClinic.entities.PetEntity;
import org.springframework.data.repository.CrudRepository;

public interface PetRepo extends CrudRepository<PetEntity, Long> {

}
