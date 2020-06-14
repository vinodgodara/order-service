package com.nagarro.orderservice.services;

import java.util.List;

import com.nagarro.orderservice.model.Order;

public interface OrderService {

	List<Order> getOrderForUserID(final Integer id);

	List<Order> getAllOrders();
}
