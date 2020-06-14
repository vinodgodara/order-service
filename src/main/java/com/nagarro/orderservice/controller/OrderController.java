package com.nagarro.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.orderservice.model.Order;
import com.nagarro.orderservice.model.UserOrder;
import com.nagarro.orderservice.services.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/")
	public String home() {
		return "Welcome to Order Service.";
	}

	@GetMapping("/orders/{userid}")
	public UserOrder getOrderForUser(@PathVariable Integer userid) {
		final UserOrder userOrder = new UserOrder();
		final List<Order> orders = orderService.getOrderForUserID(userid);
		userOrder.setOrders(orders);
		return userOrder;
	}

	@GetMapping("/orders")
	public UserOrder getOrders() {
		final UserOrder userOrder = new UserOrder();
		final List<Order> orders = orderService.getAllOrders();
		userOrder.setOrders(orders);
		return userOrder;
	}
}
