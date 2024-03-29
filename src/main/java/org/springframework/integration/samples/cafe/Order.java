/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.samples.cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark Fisher
 * @author Marius Bogoevici
 * @author Tom McCuch
 */
public class Order {

	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	/** the order number used for tracking */
	private int number =0;

	// Default constructor required by Jackson Java JSON-processor
	public Order() {
	}

	public void addItem(DrinkType drinkType, int shots, boolean iced) {
		this.orderItems.add(new OrderItem(this.number, drinkType, shots, iced));
	}

	public int getNumber() {
		return number;
	}
	
	public List<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public void setNumber(int id) {
		this.number = id;		
	}
	
	public String toString(){
		return "Order #: " + this.number + " " + this.orderItems;
	}
}
