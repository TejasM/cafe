package org.springframework.integration.samples.cafe.annotation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.samples.cafe.Delivery;
import org.springframework.integration.samples.cafe.Order;


@MessageEndpoint
public class CollecterImpl implements Collecter {
	private List<Delivery> delivered = new ArrayList<Delivery>();
	
	private List<Order> ordersInWorks = new ArrayList<Order>();
	
	/* (non-Javadoc)
	 * @see org.springframework.integration.samples.cafe.output.Collecte#getStatus()
	 */
	public List<Delivery> getDelivered(){
		return delivered;
	}
	
	public List<Order> getInWorks(){
		return ordersInWorks;
	}
	
	@ServiceActivator(inputChannel="deliveries")
	public void updateDeliveries(Delivery delivery){
		delivered.add(delivery);
		List<Order> ordersNotDone = new ArrayList<Order>(ordersInWorks);
		for (Order order : ordersNotDone) {
			if(order.getNumber() == delivery.getOrderNumber()){
				ordersInWorks.remove(order);
			}
		}
	}
	
	
	@ServiceActivator(inputChannel="orders")
	public void updateOrder(Order order){
		ordersInWorks.add(order);
	}
}
