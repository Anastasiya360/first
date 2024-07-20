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

    public ResponseEntity<?> create(Picture picture) {
        if (!goodRepository.existsById(picture.getGoodsId())) {
            return ResponseEntity.badRequest().body("goodsId не найден");
        }
        if (picture.getPicture() == null) {
            return ResponseEntity.badRequest().body("picture не передан");
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

    public ResponseEntity<?> put(Picture picture) {
        if (!pictureRepository.existsById(picture.getId())) {
            return ResponseEntity.badRequest().body("pictureId не найден");
        }
        if (!goodRepository.existsById(picture.getGoodsId())) {
            return ResponseEntity.badRequest().body("goodsId не найден");
        }
        return ResponseEntity.ok(pictureRepository.save(picture));
    }
}
