package com.sovadeveloper.petClinic.controllers;

import com.sovadeveloper.petClinic.entities.PetTypeEntity;
import com.sovadeveloper.petClinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/petType")
public class PetTypeController{
    @Autowired
    private PetTypeService petTypeService;

    @GetMapping
    public ResponseEntity getAll(){
        try {
            return ResponseEntity.ok(petTypeService.getAll());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(petTypeService.getById(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody PetTypeEntity petTypeEntity){
        try {
            return ResponseEntity.ok(petTypeService.create(petTypeEntity));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable Long id, @Valid @RequestBody PetTypeEntity petTypeEntity){
        try {
            return ResponseEntity.ok(petTypeService.edit(id, petTypeEntity));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(petTypeService.delete(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
}
