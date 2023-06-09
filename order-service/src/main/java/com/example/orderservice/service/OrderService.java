package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.product.Product;
import com.example.orderservice.feign.ProductFeignClient;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderItem;
import com.example.orderservice.repo.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final ProductFeignClient productFeignClient;
    private final OrderRepository jpaRepository;

    public OrderService(ProductFeignClient productFeignClient, OrderRepository orderRepository) {
        this.productFeignClient = productFeignClient;
        this.jpaRepository = orderRepository;
    }

    public OrderDto addItemToOrder(OrderDto orderDto, OrderItem orderItem) {
        Product product = productFeignClient.getProductById(orderItem.getUnitId());
        System.out.println(product);
        orderItem.setTotal(product.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
        orderDto.getOrderItems().add(orderItem);

        return orderDto;
    }

    public List<Order> findAll() {
        return jpaRepository.findAll();
    }

    public List<Order> findAll(Sort sort) {
        return jpaRepository.findAll(sort);
    }

    public Page<Order> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }

    public Page<Order> findAll(Pageable pageable, String sortBy) {
        if (sortBy == null) {
            return findAll(pageable);
        }

        pageable = getPageable(pageable, sortBy);

        return findAll(pageable);
    }

    protected Pageable getPageable(Pageable pageable, String sortBy) {
        char order = sortBy.charAt(0);
        sortBy = sortBy.replaceFirst(order + "_", "");
        if (order == 'a') {
            pageable = PageRequest.of(pageable.getPageNumber(),
                    pageable.getPageSize(), Sort.by(Sort.Direction.ASC, sortBy));
        }

        if (order == 'd') {
            pageable = PageRequest.of(pageable.getPageNumber(),
                    pageable.getPageSize(), Sort.by(Sort.Direction.DESC, sortBy));
        }
        return pageable;
    }

    public Optional<Order> findById(Long id) {
        return jpaRepository.findById(id);
    }

    public void save(Order entity) {
        jpaRepository.save(entity);
    }

    public void delete(Order entity) {
        jpaRepository.delete(entity);
    }

    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    public void deleteAll() {
        jpaRepository.deleteAll();
    }
}