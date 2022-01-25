package com.sovadeveloper.petClinic.dto;

import com.sovadeveloper.petClinic.entities.PetEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PetDTO {
    private Long id;
    private String name;
    private ClientDTO clientDTO;
    private PetTypeDTO petTypeDTO;

    public static PetDTO toModel(PetEntity petEntity){
        PetDTO petDTO = new PetDTO();
        petDTO.setId(petEntity.getId());
        petDTO.setName(petEntity.getName());
        petDTO.setClientDTO(ClientDTO.toModel(petEntity.getClient()));
        petDTO.setPetTypeDTO(PetTypeDTO.toModel(petEntity.getPetType()));
        return petDTO;
    }
}
