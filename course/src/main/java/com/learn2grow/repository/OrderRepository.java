package com.learn2grow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn2grow.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
