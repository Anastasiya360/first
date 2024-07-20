package com.example.first.service;

import com.example.first.entity.Good;
import com.example.first.entity.User;
import com.example.first.repository.RoleRepository;
import com.example.first.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public ResponseEntity<?> existById(Integer id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }

    public ResponseEntity<?> deleteById(Integer id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> create(User user) {
        if (user.getName() == null) {
            return ResponseEntity.badRequest().body("name не передан");
        }
        if (!roleRepository.existsById(user.getRoleId())) {
            return ResponseEntity.badRequest().body("roleId не найден");
        }
        if (user.getLogin() == null) {
            return ResponseEntity.badRequest().body("login не передан");
        }
        if (user.getPassword() == null) {
            return ResponseEntity.badRequest().body("password не передан");
        }
        return ResponseEntity.ok(userRepository.save(user));
    }

    public ResponseEntity<?> getById(Integer id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        return ResponseEntity.ok(userRepository.findById(id));
    }

    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    public ResponseEntity<?> put(User user) {
        if (!userRepository.existsById(user.getId())) {
            return ResponseEntity.badRequest().body("userId не найден");
        }
        if (!roleRepository.existsById(user.getRoleId())) {
            return ResponseEntity.badRequest().body("roleId не найден");
        }
        return ResponseEntity.ok(userRepository.save(user));
    }
}
