package com.sovadeveloper.petClinic.repositories;

import com.sovadeveloper.petClinic.entities.NoteEntity;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepo extends CrudRepository<NoteEntity, Long> {

}
