package com.example.first.controller;

import com.example.first.entity.Type;
import com.example.first.entity.User;
import com.example.first.service.TypeService;
import com.example.first.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping(path = "/delete/user/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return userService.deleteById(id);
    }

    @PostMapping(path = "/create/user")
    public ResponseEntity<?> create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping(path = "/get/user/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping(path = "/get/all/user")
    public ResponseEntity<?> getAll() {
        return userService.getAll();
    }

    @PutMapping(path = "/put/user")
    public ResponseEntity<?> put(@RequestBody User user) {
        return userService.put(user);
    }
}
