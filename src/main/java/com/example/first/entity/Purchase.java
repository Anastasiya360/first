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
@Table(schema = "shop", name = "table_goods_purchases")
public class Purchase implements Serializable {

    @EmbeddedId
    private PurchaseId id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "price")
    private double price;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class PurchaseId implements Serializable {

        @Column(name = "order_id")
        private Integer orderId;

        @Column(name = "goods_id")
        private Integer goodsId;
    }
}

