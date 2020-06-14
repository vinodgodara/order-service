package com.nagarro.orderservice.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nagarro.orderservice.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

	private List<Order> orders;

	public OrderServiceImpl() {
		final Order order1 = new Order(1, 250, new Date(), 1);
		final Order order2 = new Order(2, 350, new Date(), 1);
		final Order order3 = new Order(3, 450, new Date(), 1);
		final Order order4 = new Order(4, 550, new Date(), 2);
		final Order order5 = new Order(5, 650, new Date(), 2);

		orders = new ArrayList<>();
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		orders.add(order4);
		orders.add(order5);
	}

	@Override
	public List<Order> getOrderForUserID(final Integer userID) {
		return orders.stream().filter((order -> order.getUser() == userID)).collect(Collectors.toList());
	}

	@Override
	public List<Order> getAllOrders() {
		return orders;
	}

}
