package com.example.orderservice.dto;

import com.example.orderservice.model.OrderItem;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class OrderDto {
    private List<OrderItem> orderItems;
}

