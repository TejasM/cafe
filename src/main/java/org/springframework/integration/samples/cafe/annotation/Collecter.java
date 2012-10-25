package org.springframework.integration.samples.cafe.annotation;

import java.util.List;

import org.springframework.integration.samples.cafe.Delivery;
import org.springframework.integration.samples.cafe.Order;

public interface Collecter {

	public abstract List<Delivery> getDelivered();
	
	public abstract List<Order> getInWorks();
}