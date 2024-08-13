package com.example.first.repository;

import com.example.first.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(nativeQuery = true, value = "select * from orders where users_id = :userId")
    List<Order> findOrdersByUserId(Integer userId);

    @Query(nativeQuery = true, value = "select * from orders where users_id = :userId and status = 'basket'")
    Optional<Order> findBasketByUserId(Integer userId);
}
