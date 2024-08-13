package com.example.first.controller;

import com.example.first.entity.Good;
import com.example.first.entity.Order;
import com.example.first.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Tag(name = "Order", description = "Interaction with users")
public class OrderController {
    private OrderService orderService;

    @Autowired

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @DeleteMapping(path = "order/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return orderService.deleteById(id);
    }

    @PostMapping(path = "order/create")
    public ResponseEntity<?> create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @GetMapping(path = "order/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return orderService.getById(id);
    }

    @GetMapping(path = "order/get/by/user/{id}")
    public ResponseEntity<?> findOrderByUserId(@PathVariable Integer id) {
        return orderService.findOrderByUserId(id);
    }

    @GetMapping(path = "order/get/all")
    public ResponseEntity<?> getAll() {
        return orderService.getAll();
    }

    @PutMapping(path = "order/put")
    public ResponseEntity<?> put(@RequestBody Order order) {
        return orderService.put(order);
    }
}
