package com.sovadeveloper.petClinic.repositories;

import com.sovadeveloper.petClinic.entities.DoctorEntity;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepo extends CrudRepository<DoctorEntity, Long> {

}
