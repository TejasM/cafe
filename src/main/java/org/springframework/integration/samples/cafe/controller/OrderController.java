package org.springframework.integration.samples.cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.integration.samples.cafe.Cafe;
import org.springframework.integration.samples.cafe.Order;
import org.springframework.integration.samples.cafe.OrderItem;
import org.springframework.integration.samples.cafe.dao.OrderItemDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/order")
public class OrderController {
	private int ID = 0;

	public int getID() {
		return ID++;
	}

	@Autowired
	private ApplicationContext context;

	@Autowired
	private OrderItemDao dao;

	@RequestMapping(method = RequestMethod.GET)
	public void orderForm(Model model) {
		model.addAttribute("orderItems", dao.getOrderItems());
		model.addAttribute("order", new Order());
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody String orderCreate(Order order) {
		Cafe cafe = (Cafe) context.getBean("cafe");
		order.setNumber(getID());
		for (OrderItem orderitem : order.getOrderItems()) {
			orderitem.setOrderNumber(order.getNumber());
		}
		cafe.placeOrder(order);
		return "Successfully created Order #: " + order.getNumber();
	}
}
