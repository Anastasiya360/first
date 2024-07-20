package com.example.first.controller;

import com.example.first.entity.Good;
import com.example.first.entity.Type;
import com.example.first.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class TypeController {
    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @DeleteMapping(path = "/delete/type/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return typeService.deleteById(id);
    }

    @PostMapping(path = "/create/type")
    public ResponseEntity<?> create(@RequestBody Type type) {
        return typeService.create(type);
    }

    @GetMapping(path = "/get/type/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return typeService.getById(id);
    }

    @GetMapping(path = "/get/all/type")
    public ResponseEntity<?> getAll() {
        return typeService.getAll();
    }

    @PutMapping(path = "/put/type")
    public ResponseEntity<?> put(@RequestBody Type type) {
        return typeService.put(type);
    }
}
