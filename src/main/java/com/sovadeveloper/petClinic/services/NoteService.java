package com.sovadeveloper.petClinic.services;

import com.sovadeveloper.petClinic.dto.NoteDTO;
import com.sovadeveloper.petClinic.entities.NoteEntity;

import java.util.List;

public interface NoteService {
    NoteDTO create(NoteEntity noteEntity) throws Exception;
    NoteDTO getById(Long id) throws Exception;
    NoteDTO edit(Long id, NoteEntity noteEntityUpdated) throws Exception;
    Long delete(Long id) throws Exception;
    List<NoteDTO> getAll() throws Exception;
}
