package com.learn2grow.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.learn2grow.model.Order;

@Component
public class OrderValiator implements Validator {

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object object, Errors error) {
		Order order = (Order) object;
		if(!StringUtils.hasText(order.getLocation()))
		{
			error.reject("LOCATION_CAN_NOT_BE_EMPTY");
		}
	}

}
