package com.example.first.service;

import com.example.first.entity.Good;
import com.example.first.entity.Order;
import com.example.first.repository.OrderRepository;
import com.example.first.repository.UserRepository;
import org.aspectj.weaver.ResolvedPointcutDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> existById(Integer id) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }

    public ResponseEntity<?> deleteById(Integer id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        orderRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> create(Order order) {
        if (!userRepository.existsById(order.getUserId())) {
            return ResponseEntity.badRequest().body("users_id не найден");
        }
        if (order.getStatus() == null) {
            return ResponseEntity.badRequest().body("status не передан");
        }
        return ResponseEntity.ok(orderRepository.save(order));
    }

    public ResponseEntity<?> getById(Integer id) {
        ResponseEntity<?> responseEntity = existById(id);
        if (responseEntity != null) {
            return responseEntity;
        }
        return ResponseEntity.ok(orderRepository.findById(id));
    }

    public ResponseEntity<?> put(Order order) {
        if (!orderRepository.existsById(order.getId())) {
            return ResponseEntity.badRequest().body("orderId не найден");
        }
        if (!userRepository.existsById(order.getUserId())) {
            return ResponseEntity.badRequest().body("users_id не найден");
        }
        return ResponseEntity.ok(orderRepository.save(order));
    }
}
