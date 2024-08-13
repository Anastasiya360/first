package com.example.first.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "shop", name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "users_id")
    private Integer userId;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "order_date")
    private LocalDate orderDate;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "status")
    private String status;
}
