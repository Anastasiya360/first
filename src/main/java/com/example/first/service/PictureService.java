package com.example.first.service;

import com.example.first.entity.Good;
import com.example.first.entity.Picture;
import com.example.first.repository.GoodRepository;
import com.example.first.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService {
    private PictureRepository pictureRepository;
    private GoodRepository goodRepository;

    @Autowired
    public PictureService(PictureRepository pictureRepository, GoodRepository goodRepository) {
        this.pictureRepository = pictureRepository;
        this.goodRepository = goodRepository;
    }

    public ResponseEntity<?> existById(Integer id) {
        if (!pictureRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }

    public ResponseEntity<?> deleteById(Integer id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        pictureRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> checkParam(Picture picture) {
        if (picture.getGoodsId() == null) {
            return ResponseEntity.badRequest().body("good не передан");
        }
        if (picture.getPicture() == null || picture.getPicture().isBlank()) {
            return ResponseEntity.badRequest().body("picture не передан");
        }
        if (!goodRepository.existsById(picture.getGoodsId())) {
            return ResponseEntity.badRequest().body("good не найден");
        }
        return null;
    }

    public ResponseEntity<?> create(Picture picture) {
        picture.setId(null);
        ResponseEntity<?> responseEntity = checkParam(picture);
        if (responseEntity != null) {
            return responseEntity;
        }
        return ResponseEntity.ok(pictureRepository.save(picture));
    }

    public ResponseEntity<?> getById(Integer id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        return ResponseEntity.ok(pictureRepository.findById(id));
    }

    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(pictureRepository.findAll());
    }

    public ResponseEntity<?> findPictureByGoodId(Integer id) {
        if (pictureRepository.findPictureByGoodId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pictureRepository.findPictureByGoodId(id));
    }

    public ResponseEntity<?> put(Picture picture) {
        ResponseEntity<?> responseEntity = checkParam(picture);
        if (responseEntity != null) {
            return responseEntity;
        }
        if (!pictureRepository.existsById(picture.getId())) {
            return ResponseEntity.badRequest().body("picture не найден");
        }
        return ResponseEntity.ok(pictureRepository.save(picture));
    }
}
