package com.learn2grow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn2grow.exception.LocationNeededException;
import com.learn2grow.model.Order;
import com.learn2grow.service.OrderService;
import com.learn2grow.validator.OrderValiator;


@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderValiator orderValidator;
	
	@PostMapping(value="/orders")
	public Order placeOrder(@RequestBody Order order,BindingResult bindingResult)
	{
		orderValidator.validate(order, bindingResult);
		
		if(bindingResult.hasErrors())
		{
			List<String> list = new ArrayList<String>(); 
			list.add("Further Details can be passed here");
			
			throw new LocationNeededException(888, "LOCATION_NEEDED", list);
		}
		return orderService.placeOrder(order);
	}
}
