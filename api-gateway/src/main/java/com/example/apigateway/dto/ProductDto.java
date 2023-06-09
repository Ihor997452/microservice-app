package com.example.apigateway.dto;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String name;
    private String description;
    private BigDecimal price;

    private CategoryDto category;
}
