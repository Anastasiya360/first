package com.example.first.service;

import com.example.first.entity.Good;
import com.example.first.repository.GoodRepository;
import com.example.first.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {
    private GoodRepository goodRepository;
    private TypeRepository typeRepository;

    @Autowired
    public GoodService(GoodRepository goodRepository, TypeRepository typeRepository) {
        this.goodRepository = goodRepository;
        this.typeRepository = typeRepository;
    }


    public ResponseEntity<?> existById(Integer id) {
        if (!goodRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }

    public ResponseEntity<?> deleteById(Integer id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        goodRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> create(Good good) {
        if (good.getName() == null) {
            return ResponseEntity.badRequest().body("name не передан");
        }
        if (!typeRepository.existsById(good.getGoodsTypeId())) {
            return ResponseEntity.badRequest().body("goodsTypeId не найден");
        }
        if (good.getUnitPrice() == null) {
            return ResponseEntity.badRequest().body("unitPrice не передан");
        }
        return ResponseEntity.ok(goodRepository.save(good));
    }

    public ResponseEntity<?> getById(Integer id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        return ResponseEntity.ok(goodRepository.findById(id));
    }

    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(goodRepository.findAll());
    }

    public ResponseEntity<?> put(Good good) {
        if (!goodRepository.existsById(good.getId())) {
            return ResponseEntity.badRequest().body("goodId не найден");
        }
        if (!typeRepository.existsById(good.getGoodsTypeId())) {
            return ResponseEntity.badRequest().body("typeId не найден");
        }
        return ResponseEntity.ok(goodRepository.save(good));
    }
}

