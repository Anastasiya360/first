package com.example.first.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "shop", name = "reviews")
public class Reviews implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "users_id")
    private Integer users_id;

    @Column(name = "goods_id")
    private Integer goods_id;

    @Column(name = "description")
    private String description;
}
