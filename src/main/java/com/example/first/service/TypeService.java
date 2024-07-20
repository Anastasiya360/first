package com.example.first.service;

import com.example.first.entity.Good;
import com.example.first.entity.Type;
import com.example.first.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    private TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public ResponseEntity<?> existById(Integer id) {
        if (!typeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }

    public ResponseEntity<?> deleteById(Integer id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        typeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> create(Type type) {
        if (type.getName() == null) {
            return ResponseEntity.badRequest().body("name не передан");
        }
        return ResponseEntity.ok(typeRepository.save(type));
    }

    public ResponseEntity<?> getById(Integer id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        return ResponseEntity.ok(typeRepository.findById(id));
    }

    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(typeRepository.findAll());
    }

    public ResponseEntity<?> put(Type type) {
        if (!typeRepository.existsById(type.getId())) {
            return ResponseEntity.badRequest().body("typeId не найден");
        } else {
            return ResponseEntity.ok(typeRepository.save(type));
        }
    }
}
