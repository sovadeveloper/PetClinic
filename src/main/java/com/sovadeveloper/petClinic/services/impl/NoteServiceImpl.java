package com.sovadeveloper.petClinic.services.impl;

import com.sovadeveloper.petClinic.dto.NoteDTO;
import com.sovadeveloper.petClinic.entities.NoteEntity;
import com.sovadeveloper.petClinic.repositories.DoctorRepo;
import com.sovadeveloper.petClinic.repositories.NoteRepo;
import com.sovadeveloper.petClinic.repositories.PetRepo;
import com.sovadeveloper.petClinic.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepo noteRepo;

    @Autowired
    private PetRepo petRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public NoteDTO create(NoteEntity noteEntity) throws Exception {
        petRepo.findById(noteEntity.getPet().getId())
                .orElseThrow(() -> new Exception("Такого питомца не существует"));
        doctorRepo.findById(noteEntity.getDoctor().getId())
                .orElseThrow(() -> new Exception("Такого доктора не существует"));
        return NoteDTO.toModel(noteRepo.save(noteEntity));
    }

    @Override
    public NoteDTO getById(Long id) throws Exception {
        return NoteDTO.toModel(noteRepo.findById(id)
                .orElseThrow(() -> new Exception("Такой записи не существует")));
    }

    @Override
    public NoteDTO edit(Long id, NoteEntity noteEntityUpdated) throws Exception {
        NoteEntity noteEntity = noteRepo.findById(id)
                .orElseThrow(() -> new Exception("Такой записи не существует"));
        petRepo.findById(noteEntityUpdated.getPet().getId())
                .orElseThrow(() -> new Exception("Такого питомца не существует"));
        doctorRepo.findById(noteEntityUpdated.getDoctor().getId())
                .orElseThrow(() -> new Exception("Такого доктора не существует"));
        noteEntity.setTitle(noteEntityUpdated.getTitle());
        return NoteDTO.toModel(noteRepo.save(noteEntity));
    }

    @Override
    public Long delete(Long id) throws Exception {
        NoteEntity noteEntity = noteRepo.findById(id)
                .orElseThrow(() -> new Exception("Такой записи не существует"));
        noteRepo.delete(noteEntity);
        return id;
    }

    @Override
    public List<NoteDTO> getAll() throws Exception {
        List<NoteEntity> noteEntities = (List<NoteEntity>) noteRepo.findAll();
        List<NoteDTO> noteDTOS = new ArrayList<>();
        for(NoteEntity noteEntity: noteEntities){
            noteDTOS.add(NoteDTO.toModel(noteEntity));
        }
        return noteDTOS;
    }
}
