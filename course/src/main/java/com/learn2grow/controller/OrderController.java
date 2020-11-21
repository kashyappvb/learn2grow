package com.learn2grow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn2grow.model.Order;
import com.learn2grow.service.OrderService;


@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping(value="/orders")
	public Order placeOrder(@RequestBody Order order)
	{
		return orderService.placeOrder(order);
	}
}
