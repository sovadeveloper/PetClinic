package com.sovadeveloper.petClinic.controllers;

import com.sovadeveloper.petClinic.entities.ClientEntity;
import com.sovadeveloper.petClinic.services.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/client")
@Api(value = "client", description = "REST API for clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    @ApiOperation("Get all clients")
    public ResponseEntity getAll(){
        try {
            return ResponseEntity.ok(clientService.getAll());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation("Get client by ID")
    public ResponseEntity getById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(clientService.getById(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping
    @ApiOperation("Create new client")
    public ResponseEntity create(@Valid @RequestBody ClientEntity clientEntity){
        try {
            return ResponseEntity.ok(clientService.create(clientEntity));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation("Update client")
    public ResponseEntity edit(@PathVariable Long id, @Valid @RequestBody ClientEntity clientEntity){
        try {
            return ResponseEntity.ok(clientService.edit(id, clientEntity));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete client")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(clientService.delete(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
}
