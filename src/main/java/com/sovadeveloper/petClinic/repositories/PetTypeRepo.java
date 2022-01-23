package com.sovadeveloper.petClinic.repositories;

import com.sovadeveloper.petClinic.entities.PetTypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepo extends CrudRepository<PetTypeEntity, Long> {

}
