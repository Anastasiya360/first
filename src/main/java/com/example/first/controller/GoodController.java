package com.example.first.controller;

import com.example.first.entity.Good;
import com.example.first.service.GoodService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Tag(name = "Good", description = "Interaction with goods")
public class GoodController {
    private GoodService goodService;

    @Autowired
    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }

    @DeleteMapping(path = "good/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return goodService.deleteById(id);
    }

    @PostMapping(path = "good/create")
    public ResponseEntity<?> create(@RequestBody Good good) {
        return goodService.create(good);
    }

    @GetMapping(path = "good/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return goodService.getById(id);
    }

    @GetMapping(path = "good/get/all")
    public ResponseEntity<?> getAll() {
        return goodService.getAll();
    }

    @PutMapping(path = "good/put")
    public ResponseEntity<?> put(@RequestBody Good good) {
        return goodService.put(good);
    }
}
