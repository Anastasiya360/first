package com.example.first.controller;

import com.example.first.entity.Good;
import com.example.first.entity.Picture;
import com.example.first.service.PictureService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Tag(name = "Picture", description = "Interaction with pictures")
public class PictureController {
    private PictureService pictureService;

    @Autowired

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @DeleteMapping(path = "picture/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return pictureService.deleteById(id);
    }

    @PostMapping(path = "picture/create")
    public ResponseEntity<?> create(@RequestBody Picture picture) {
        return pictureService.create(picture);
    }

    @GetMapping(path = "picture/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return pictureService.getById(id);
    }

    @GetMapping(path = "picture/get/all")
    public ResponseEntity<?> getAll() {
        return pictureService.getAll();
    }

    @GetMapping(path = "picture/get/by/good/{id}")
    public ResponseEntity<?> findPictureByGoodId(@PathVariable Integer id) {
        return pictureService.findPictureByGoodId(id);
    }

    @PutMapping(path = "picture/put")
    public ResponseEntity<?> put(@RequestBody Picture picture) {
        return pictureService.put(picture);
    }
}
