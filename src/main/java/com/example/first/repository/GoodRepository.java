package com.example.first.repository;

import com.example.first.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface GoodRepository extends JpaRepository<Good, Integer> {
    @Query(nativeQuery = true, value = "select name from shop.goods")
    List <String> findAllNames();
}
