package com.example.first.service;

import com.example.first.entity.User;
import com.example.first.repository.RoleRepository;
import com.example.first.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public ResponseEntity<?> checkParam(User user) {
        if (user.getName() == null || user.getName().isBlank()) {
            return ResponseEntity.badRequest().body("name не передан");
        }
        if (user.getRole() == null || user.getRole().getId() == null) {
            return ResponseEntity.badRequest().body("role не передана");
        }
        if (!roleRepository.existsById(user.getRole().getId())) {
            return ResponseEntity.badRequest().body("role не найдена");
        }
        if (userRepository.existsByLogin(user.getLogin())) {
            return ResponseEntity.badRequest().body("login уже существует");
        }
        if (user.getLogin() == null || user.getLogin().isBlank()) {
            return ResponseEntity.badRequest().body("login не передан");
        }
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            return ResponseEntity.badRequest().body("password не передан");
        }
        if (user.getPhone() == null || user.getPhone().length() != 11) {
            return ResponseEntity.badRequest().body("phone не передан или имеет менее 11 символов");
        }
        return null;
    }

    public ResponseEntity<?> create(User user) {
        user.setId(null);
        ResponseEntity<?> responseEntity = checkParam(user);
        if (responseEntity != null) {
            return responseEntity;
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
        Optional<User> oldUser = userRepository.findById(user.getId());
        if (oldUser.isEmpty()) {
            return ResponseEntity.badRequest().body("user не найден");
        }

        if ((user.getPassword() != null) && !user.getPassword().isBlank()) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        } else {
            user.setPassword(oldUser.get().getPassword());
        }

        ResponseEntity<?> responseEntity = checkParam(user);
        if (responseEntity != null) {
            return responseEntity;
        }
        return ResponseEntity.ok(userRepository.save(user));
    }
}
