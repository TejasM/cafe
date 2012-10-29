package org.springframework.integration.samples.cafe.annotation;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Publisher;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.samples.cafe.DrinkType;
import org.springframework.integration.samples.cafe.Order;

@MessageEndpoint
public class Customer implements MessageSource<Order>{
	
	@Publisher
	public Order createOrder(){
		Order order = new Order();
		order.addItem(DrinkType.CAPPUCCINO, 1, true);
		return order;
	}

	public Message<Order> receive() {
		// TODO Auto-generated method stub
		return createOrder();
	}

}
