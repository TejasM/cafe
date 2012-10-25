package org.springframework.integration.samples.cafe.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.integration.samples.cafe.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemDao {
	
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public void addOrderItem(OrderItem orderItem){
		orderItems.add(orderItem);
	}
}
