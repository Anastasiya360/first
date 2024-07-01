package com.example.first.controller;

import com.example.first.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GoodController {
    private GoodService goodService;

    @Autowired
       public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }

    @GetMapping(path = "/findAllNames")
    public ResponseEntity<?> findAllNames () {
        return ResponseEntity.ok(goodService.findAllNames());
    }
}
