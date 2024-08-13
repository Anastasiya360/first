package com.example.first.repository;

import com.example.first.entity.Picture;
import com.example.first.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
    @Query(nativeQuery = true, value = "select * from picture_of_goods where goods_id = :goodId")
    List<Picture> findPictureByGoodId(Integer goodId);
}
