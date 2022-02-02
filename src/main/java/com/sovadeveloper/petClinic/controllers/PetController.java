package com.sovadeveloper.petClinic.controllers;

import com.sovadeveloper.petClinic.entities.PetEntity;
import com.sovadeveloper.petClinic.services.PetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pet")
@Api(value = "client", description = "REST API for pets")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping
    @ApiOperation("Get all pets")
    public ResponseEntity getAll(){
        try {
            return ResponseEntity.ok(petService.getAll());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation("Get pet by ID")
    public ResponseEntity getById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(petService.getById(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping
    @ApiOperation("Create new pet")
    public ResponseEntity create(@Valid @RequestBody PetEntity petEntity){
        try {
            return ResponseEntity.ok(petService.create(petEntity));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation("Update pet")
    public ResponseEntity edit(@PathVariable Long id, @Valid @RequestBody PetEntity petEntity){
        try {
            return ResponseEntity.ok(petService.edit(id, petEntity));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete pet")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(petService.delete(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
}
