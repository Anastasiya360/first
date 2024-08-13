package com.example.first.controller;

import com.example.first.entity.Good;
import com.example.first.entity.Role;
import com.example.first.service.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Tag(name = "Role", description = "Interaction with roles")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @DeleteMapping(path = "role/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return roleService.deleteById(id);
    }

    @PostMapping(path = "role/create")
    public ResponseEntity<?> create(@RequestBody Role role) {
        return roleService.create(role);
    }

    @GetMapping(path = "role/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return roleService.getById(id);
    }

    @GetMapping(path = "role/get/all")
    public ResponseEntity<?> getAll() {
        return roleService.getAll();
    }

    @PutMapping(path = "role/put")
    public ResponseEntity<?> put(@RequestBody Role role) {
        return roleService.put(role);
    }
}
