package com.sovadeveloper.petClinic.dto;

import com.sovadeveloper.petClinic.entities.ClientEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTO {
    private Long id;
    private String name;
    private String surname;
    private String phone;

    public static ClientDTO toModel(ClientEntity clientEntity){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(clientEntity.getId());
        clientDTO.setName(clientEntity.getName());
        clientDTO.setSurname(clientEntity.getSurname());
        clientDTO.setPhone(clientEntity.getPhone());
        return clientDTO;
    }
}
