package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.Request;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderItem;
import com.example.orderservice.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderRestController {
    private final OrderService service;

    OrderRestController(OrderService orderService) {
        this.service = orderService;
    }

    @PostMapping("/add-to-order")
    public OrderDto addToOrder(@RequestBody Request request) {
        return service.addItemToOrder(request.orderDto, request.orderItem);
    }

    @GetMapping("/")
    public Page<Order> findAll(@RequestParam(required = false) String sortBy,
                           @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC)
                           Pageable pageable) {
        return service.findAll(pageable, sortBy);
    }

    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Order entity) {
        service.save(entity);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @DeleteMapping("/clear")
    public void clear() {
        service.deleteAll();
    }
}
