package com.sovadeveloper.petClinic.dto;

import com.sovadeveloper.petClinic.entities.NoteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoteDTO {
    private Long id;
    private String title;
    private PetDTO petDTO;
    private DoctorDTO doctorDTO;

    public static NoteDTO toModel(NoteEntity noteEntity){
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(noteEntity.getId());
        noteDTO.setTitle(noteEntity.getTitle());
        noteDTO.setPetDTO(PetDTO.toModel(noteEntity.getPet()));
        noteDTO.setDoctorDTO(DoctorDTO.toModel(noteEntity.getDoctor()));
        return noteDTO;
    }
}
