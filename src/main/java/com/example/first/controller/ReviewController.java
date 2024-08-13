package com.example.first.controller;

import com.example.first.entity.Good;
import com.example.first.entity.Review;
import com.example.first.service.ReviewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Tag(name = "Review", description = "Interaction with reviews")
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @DeleteMapping(path = "review/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return reviewService.deleteById(id);
    }

    @PostMapping(path = "review/create")
    public ResponseEntity<?> create(@RequestBody Review review) {
        return reviewService.create(review);
    }

    @GetMapping(path = "review/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return reviewService.getById(id);
    }

    @GetMapping(path = "review/get/by/good/{id}")
    public ResponseEntity<?> findReviewByGoodId(@PathVariable Integer id) {
        return reviewService.findReviewByGoodId(id);
    }

    @GetMapping(path = "review/get/all")
    public ResponseEntity<?> getAll() {
        return reviewService.getAll();
    }

    @PutMapping(path = "review/put")
    public ResponseEntity<?> put(@RequestBody Review review) {
        return reviewService.put(review);
    }
}
