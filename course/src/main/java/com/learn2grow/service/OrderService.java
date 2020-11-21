package com.learn2grow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2grow.model.Order;
import com.learn2grow.model.Price;
import com.learn2grow.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CourseService courseService;
	
	public Order placeOrder(Order order)
	{
		Price price = courseService.getPriceForCourse(order.getCourseId(),order.getLocation());
		
		double total=price.getBasePrice() + price.getTax() + price.getConversionFee();
		
		order.setBasePrice(price.getBasePrice());
		order.setTax(price.getTax());
		order.setConversionFee(price.getConversionFee());
		order.setTotal(total);
		
		return orderRepository.save(order);
	}
}
