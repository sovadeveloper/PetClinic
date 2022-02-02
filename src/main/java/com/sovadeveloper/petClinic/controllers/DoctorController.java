package com.sovadeveloper.petClinic.controllers;

import com.sovadeveloper.petClinic.entities.DoctorEntity;
import com.sovadeveloper.petClinic.services.DoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/doctor")
@Api(value = "client", description = "REST API for doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    @ApiOperation("Get all doctors")
    public ResponseEntity getAll(){
        try{
            return ResponseEntity.ok(doctorService.getAll());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation("Get doctor by ID")
    public ResponseEntity getById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(doctorService.getById(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping
    @ApiOperation("Create new doctor")
    public ResponseEntity create(@Valid @RequestBody DoctorEntity doctorEntity){
        try {
            return ResponseEntity.ok(doctorService.create(doctorEntity));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation("Update doctor")
    public ResponseEntity edit(@PathVariable Long id, @Valid @RequestBody DoctorEntity doctorEntity){
        try {
            return ResponseEntity.ok(doctorService.edit(id, doctorEntity));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete doctor")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(doctorService.delete(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
}
