package com.sovadeveloper.petClinic.controllers;

import com.sovadeveloper.petClinic.entities.NoteEntity;
import com.sovadeveloper.petClinic.services.NoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/note")
@Api(value = "client", description = "REST API for notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    @ApiOperation("Get all notes")
    public ResponseEntity getAll(){
        try {
            return ResponseEntity.ok(noteService.getAll());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation("Get note by ID")
    public ResponseEntity getById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(noteService.getById(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping
    @ApiOperation("Create new note")
    public ResponseEntity create(@Valid @RequestBody NoteEntity noteEntity){
        try {
            return ResponseEntity.ok(noteService.create(noteEntity));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping ("/{id}")
    @ApiOperation("Update note")
    public ResponseEntity edit(@PathVariable Long id, @Valid @RequestBody NoteEntity noteEntity){
        try {
            return ResponseEntity.ok(noteService.edit(id, noteEntity));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete note")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(noteService.delete(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
}
