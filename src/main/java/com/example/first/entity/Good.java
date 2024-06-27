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
@Table(schema = "shop", name = "goods")
public class Good implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "goods_type_id")
    private Integer goods_type_id;

    @Column(name = "unit_price")
    private double unit_price;

    @Column(name = "description")
    private String description;
}
