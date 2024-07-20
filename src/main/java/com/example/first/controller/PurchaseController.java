package com.example.first.controller;

import com.example.first.entity.Good;
import com.example.first.entity.Purchase;
import com.example.first.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PurchaseController {
    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @DeleteMapping(path = "/delete/purchase")
    public ResponseEntity<?> deleteById(@RequestBody Purchase.PurchaseId id) {
        return purchaseService.deleteById(id);
    }

    @PostMapping(path = "/create/purchase")
    public ResponseEntity<?> create(@RequestBody Purchase purchase) {
        return purchaseService.create(purchase);
    }

    @GetMapping(path = "/get/purchase")
    public ResponseEntity<?> getById(@RequestBody Purchase.PurchaseId id) {
        return purchaseService.getById(id);
    }

    @GetMapping(path = "/get/all/purchase")
    public ResponseEntity<?> getAll() {
        return purchaseService.getAll();
    }

    @PutMapping(path = "/put/purchase")
    public ResponseEntity<?> put(@RequestBody Purchase purchase) {
        return purchaseService.put(purchase);
    }
}
