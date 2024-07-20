package com.example.first.controller;

import com.example.first.entity.Good;
import com.example.first.entity.Review;
import com.example.first.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @DeleteMapping(path = "/delete/review/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return reviewService.deleteById(id);
    }

    @PostMapping(path = "/create/review")
    public ResponseEntity<?> create(@RequestBody Review review) {
        return reviewService.create(review);
    }

    @GetMapping(path = "/get/review/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return reviewService.getById(id);
    }

    @GetMapping(path = "/get/all/review")
    public ResponseEntity<?> getAll() {
        return reviewService.getAll();
    }

    @PutMapping(path = "/put/review")
    public ResponseEntity<?> put(@RequestBody Review review) {
        return reviewService.put(review);
    }
}
