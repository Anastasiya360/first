package com.example.first.controller;

import com.example.first.entity.Good;
import com.example.first.entity.Order;
import com.example.first.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class OrderController {
    private OrderService orderService;

    @Autowired

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @DeleteMapping(path = "/delete/order/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return orderService.deleteById(id);
    }

    @PostMapping(path = "/create/order")
    public ResponseEntity<?> create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @GetMapping(path = "/get/order/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return orderService.getById(id);
    }

    @GetMapping(path = "/get/all/order")
    public ResponseEntity<?> getAll() {
        return orderService.getAll();
    }

    @PutMapping(path = "/put/order")
    public ResponseEntity<?> put(@RequestBody Order order) {
        return orderService.put(order);
    }
}
