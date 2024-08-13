package com.example.first.controller;

import com.example.first.entity.Good;
import com.example.first.entity.Purchase;
import com.example.first.service.PurchaseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Tag(name = "Purchase", description = "Interaction with purchase")
public class PurchaseController {
    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @DeleteMapping(path = "purchase/delete")
    public ResponseEntity<?> deleteById(@RequestBody Purchase.PurchaseId id) {
        return purchaseService.deleteById(id);
    }

    @PostMapping(path = "purchase/create")
    public ResponseEntity<?> create(@RequestBody Purchase purchase) {
        return purchaseService.create(purchase);
    }

    @GetMapping(path = "purchase/get/by/order/{id}")
    public ResponseEntity<?> findPurchaseByOrderId(@PathVariable Integer id) {
        return purchaseService.findPurchaseByOrderId(id);
    }

    @GetMapping(path = "purchase/get/all")
    public ResponseEntity<?> getAll() {
        return purchaseService.getAll();
    }

    @PutMapping(path = "purchase/put")
    public ResponseEntity<?> put(@RequestBody Purchase purchase) {
        return purchaseService.put(purchase);
    }
}
