package com.example.first.controller;

import com.example.first.entity.Good;
import com.example.first.entity.Type;
import com.example.first.service.TypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Tag(name = "Type", description = "Interaction with types")
public class TypeController {
    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @DeleteMapping(path = "type/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return typeService.deleteById(id);
    }

    @PostMapping(path = "type/create")
    public ResponseEntity<?> create(@RequestBody Type type) {
        return typeService.create(type);
    }

    @GetMapping(path = "type/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return typeService.getById(id);
    }

    @GetMapping(path = "type/get/all")
    public ResponseEntity<?> getAll() {
        return typeService.getAll();
    }

    @PutMapping(path = "type/put")
    public ResponseEntity<?> put(@RequestBody Type type) {
        return typeService.put(type);
    }
}
