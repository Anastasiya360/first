package com.example.first.repository;

import com.example.first.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Purchase.PurchaseId> {
}
