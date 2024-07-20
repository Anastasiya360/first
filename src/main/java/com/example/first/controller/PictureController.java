package com.example.first.controller;

import com.example.first.entity.Good;
import com.example.first.entity.Picture;
import com.example.first.service.PictureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PictureController {
    private PictureService pictureService;
    @Autowired

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }
    @DeleteMapping(path = "/delete/picture/{id}")
    public ResponseEntity<?> deleteById (@PathVariable Integer id) {
        return pictureService.deleteById(id);
    }
    @PostMapping(path = "/create/picture")
    public ResponseEntity<?> create (@RequestBody Picture picture){
        return pictureService.create(picture);
    }
    @GetMapping(path = "/get/picture/{id}")
    public ResponseEntity<?> getById (@PathVariable Integer id){
        return pictureService.getById(id);
    }
    @GetMapping(path = "/get/all/picture")
    public ResponseEntity<?> getAll(){
        return pictureService.getAll();
    }
    @PutMapping(path = "/put/picture")
    public ResponseEntity<?> put (@RequestBody Picture picture){
        return pictureService.put(picture);
    }
}
