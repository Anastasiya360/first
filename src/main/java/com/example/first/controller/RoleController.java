package com.example.first.controller;

import com.example.first.entity.Good;
import com.example.first.entity.Role;
import com.example.first.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RoleController {
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @DeleteMapping(path = "/delete/role/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return roleService.deleteById(id);
    }

    @PostMapping(path = "/create/role")
    public ResponseEntity<?> create(@RequestBody Role role) {
        return roleService.create(role);
    }

    @GetMapping(path = "/get/role/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return roleService.getById(id);
    }

    @GetMapping(path = "/get/all/role")
    public ResponseEntity<?> getAll() {
        return roleService.getAll();
    }

    @PutMapping(path = "/put/role")
    public ResponseEntity<?> put(@RequestBody Role role) {
        return roleService.put(role);
    }
}
