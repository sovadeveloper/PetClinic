package com.sovadeveloper.petClinic.services;

import com.sovadeveloper.petClinic.entities.NoteEntity;

import java.util.List;

public interface NoteService {
    NoteEntity create(NoteEntity noteEntity) throws Exception;
    NoteEntity getById(Long id) throws Exception;
    NoteEntity edit(Long id, NoteEntity noteEntityUpdated) throws Exception;
    Long delete(Long id) throws Exception;
    List<NoteEntity> getAll() throws Exception;
}
