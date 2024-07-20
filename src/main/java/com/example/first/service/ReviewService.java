package com.example.first.service;

import com.example.first.entity.Good;
import com.example.first.entity.Review;
import com.example.first.repository.GoodRepository;
import com.example.first.repository.ReviewRepository;
import com.example.first.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;
    private UserRepository userRepository;
    private GoodRepository goodRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, GoodRepository goodRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.goodRepository = goodRepository;
    }

    public ResponseEntity<?> existById(Integer id) {
        if (!reviewRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }

    public ResponseEntity<?> deleteById(Integer id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        reviewRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> create(Review review) {
        if (!goodRepository.existsById(review.getGoodsId())) {
            return ResponseEntity.badRequest().body("goods_id не найден");
        }
        if (!userRepository.existsById(review.getUsersId())) {
            return ResponseEntity.badRequest().body("users_id не найден");
        }
        return ResponseEntity.ok(reviewRepository.save(review));
    }

    public ResponseEntity<?> getById(Integer id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        return ResponseEntity.ok(reviewRepository.findById(id));
    }

    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(reviewRepository.findAll());
    }

    public ResponseEntity<?> put(Review review) {
        if (!reviewRepository.existsById(review.getId())) {
            return ResponseEntity.badRequest().body("reviewId не найден");
        }
        if (!goodRepository.existsById(review.getGoodsId())) {
            return ResponseEntity.badRequest().body("goods_id не найден");
        }
        if (!userRepository.existsById(review.getUsersId())) {
            return ResponseEntity.badRequest().body("users_id не найден");
        }
        return ResponseEntity.ok(reviewRepository.save(review));
    }
}
