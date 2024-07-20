package com.example.first.controller;

import com.example.first.entity.Good;
import com.example.first.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class GoodController {
    private GoodService goodService;

    @Autowired
    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }

    @DeleteMapping(path = "/delete/good/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return goodService.deleteById(id);
    }

    @PostMapping(path = "/create/good")
    public ResponseEntity<?> create(@RequestBody Good good) {
        return goodService.create(good);
    }

    @GetMapping(path = "/get/good/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return goodService.getById(id);
    }

    @GetMapping(path = "/get/all/good")
    public ResponseEntity<?> getAll() {
        return goodService.getAll();
    }

    @PutMapping(path = "/put/good")
    public ResponseEntity<?> put(@RequestBody Good good) {
        return goodService.put(good);
    }
}
