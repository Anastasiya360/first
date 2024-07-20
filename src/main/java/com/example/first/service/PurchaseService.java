package com.example.first.service;

import com.example.first.entity.Good;
import com.example.first.entity.Purchase;
import com.example.first.repository.GoodRepository;
import com.example.first.repository.OrderRepository;
import com.example.first.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseService {
    private PurchaseRepository purchaseRepository;
    private GoodRepository goodRepository;
    private OrderRepository orderRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository, GoodRepository goodRepository, OrderRepository orderRepository) {
        this.purchaseRepository = purchaseRepository;
        this.goodRepository = goodRepository;
        this.orderRepository = orderRepository;
    }

    public ResponseEntity<?> existById(Purchase.PurchaseId id) {
        if (!purchaseRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }

    public ResponseEntity<?> deleteById(Purchase.PurchaseId id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        purchaseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> create(Purchase purchase) {
        if (!goodRepository.existsById(purchase.getId().getGoodsId())) {
            return ResponseEntity.badRequest().body("goodsId не найден");
        }
        if (!orderRepository.existsById(purchase.getId().getOrderId())) {
            return ResponseEntity.badRequest().body("ordersId не найден");
        }
        if (purchase.getAmount() == null) {
            return ResponseEntity.badRequest().body("amount не передан");
        }
        return ResponseEntity.ok(purchaseRepository.save(purchase));
    }

    public ResponseEntity<?> getById(Purchase.PurchaseId id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        return ResponseEntity.ok(purchaseRepository.findById(id));
    }

    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(purchaseRepository.findAll());
    }

    public ResponseEntity<?> put(Purchase purchase) {
        if (!purchaseRepository.existsById(purchase.getId())) {
            return ResponseEntity.badRequest().body("purchaseId не найден");
        } else {
            return ResponseEntity.ok(purchaseRepository.save(purchase));
        }
    }
}

