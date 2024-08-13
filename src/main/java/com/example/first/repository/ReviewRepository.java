package com.example.first.repository;

import com.example.first.entity.Order;
import com.example.first.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(nativeQuery = true, value = "select * from reviews where goods_id = :goodId")
    List<Review> findReviewByGoodId(Integer goodId);

    boolean existsByUsersId (Integer id);
    boolean existsByGoodsId (Integer id);
}
