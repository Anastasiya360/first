package com.example.first.controller;

import com.example.first.entity.Type;
import com.example.first.entity.User;
import com.example.first.service.TypeService;
import com.example.first.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Tag(name = "User", description = "Interaction with users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Delete user",
            description = "Delete user by id"
    )
    @DeleteMapping(path = "user/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return userService.deleteById(id);
    }

    @Operation(
            summary = "Create user"
    )
    @PostMapping(path = "user/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        return userService.create(user);
    }

    @Operation(
            summary = "Get user information",
            description = "Get user information by id"
    )
    @GetMapping(path = "user/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @Operation(
            summary = "Get information about all users"
    )
    @GetMapping(path = "user/get/all")
    public ResponseEntity<?> getAll() {
        return userService.getAll();
    }

    @Operation(
            summary = "Change user",
            description = "Change user by id"
    )
    @PutMapping(path = "user/put")
    public ResponseEntity<?> put(@RequestBody User user) {
        return userService.put(user);
    }
}
