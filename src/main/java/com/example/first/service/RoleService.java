package com.example.first.service;

import com.example.first.entity.Good;
import com.example.first.entity.Role;
import com.example.first.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public ResponseEntity<?> existById(Integer id) {
        if (!roleRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }

    public ResponseEntity<?> deleteById(Integer id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        roleRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> create(Role role) {
        if (role.getName() == null) {
            return ResponseEntity.badRequest().body("name не передан");
        }
        if (role.getPermission() == null) {
            return ResponseEntity.badRequest().body("permission не передан");
        }
        return ResponseEntity.ok(roleRepository.save(role));
    }

    public ResponseEntity<?> getById(Integer id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        return ResponseEntity.ok(roleRepository.findById(id));
    }

    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(roleRepository.findAll());
    }

    public ResponseEntity<?> put(Role role) {
        if (!roleRepository.existsById(role.getId())) {
            return ResponseEntity.badRequest().body("roleId не найден");
        } else {
            return ResponseEntity.ok(roleRepository.save(role));
        }
    }
}
