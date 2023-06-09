package com.example.orderservice.dto.product;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;

    private Category category;
}
