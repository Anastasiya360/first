package com.example.first.entity;

import com.example.first.dto.GoodNameDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @JsonIgnore
    @JoinTable(schema = "shop",name = "table_goods_purchases",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "goods_id"))
    @ManyToMany(targetEntity = Good.class)
    private List<Good> goods;

    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Set<GoodNameDto> goodNameDto;

    @PostLoad
    public void postLoad(){
        if (goods != null && !goods.isEmpty()){
            goodNameDto = new HashSet<>();
            goods.forEach(good -> {
                goodNameDto.add(new GoodNameDto(good.getName()));
            });
        }
    }
}
