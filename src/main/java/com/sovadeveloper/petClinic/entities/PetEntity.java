package com.sovadeveloper.petClinic.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "pets")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Кличка не может быть пустой")
    @Size(min = 3, max = 20, message = "Длинна клички: от 3 до 20 символов")
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "petType_id")
    private PetTypeEntity petType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private List<NoteEntity> noteEntities;
}
