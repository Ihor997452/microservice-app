package com.example.orderservice.dto.product;


import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Category {
    private Long id;
    private String name;
}
