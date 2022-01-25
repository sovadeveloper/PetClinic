package com.sovadeveloper.petClinic.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "petTypes")
public class PetTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Название типа животного не может быть пустым")
    @Size(min = 3, max = 20, message = "Длинна типа животного: от 3 до 20 символов")
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "petType")
    private List<PetEntity> petEntities;
}
