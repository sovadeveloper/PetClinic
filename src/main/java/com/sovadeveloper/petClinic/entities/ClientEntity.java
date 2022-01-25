package com.sovadeveloper.petClinic.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "clients")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 3, max = 20, message = "Длинна имя: от 3 до 20 символов")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Фамилия не может быть пустой")
    @Size(min = 3, max = 20, message = "Длинна фамилии: от 3 до 20 символов")
    @Column(name = "surname", nullable = false)
    private String surname;

    //TODO: добавить валидатор номера телефона (регулярку)
    @NotBlank(message = "Телефон не может быть пустым")
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<PetEntity> petEntities;
}
