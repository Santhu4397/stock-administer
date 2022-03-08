package com.ty.stockadminister.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ty.stockadminister.controller.OrdersController;
import com.ty.stockadminister.dao.OrdersDao;
import com.ty.stockadminister.dto.OrdersRecievied;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTesting {
	@Autowired
	private OrdersController controller;
	@MockBean
	private OrdersDao dao;

	OrdersRecievied orders = new OrdersRecievied(1, "mobai", 3, 50000.0, 5, 0, null, null, null);
	OrdersRecievied orders1 = new OrdersRecievied(2, "mobai1", 3, 50000.0, 5, 0, null, null, null);
	OrdersRecievied orders2 = new OrdersRecievied(3, "mobai2", 3, 50000.0, 5, 0, null, null, null);

	@Test
	public void saveOrders() {
		when(dao.save(orders)).thenReturn(orders);
		assertEquals(orders, controller.save(orders, "adm_00001", 1).getBody().getData());

	}

	@Test
	public void getByIdTest() {

		when(dao.getByOrderId(1)).thenReturn(orders);
		assertEquals(orders, controller.getByOrderId(1).getBody().getData());

	}

	@Test
	public void getAllOrders() {
		List<OrdersRecievied> listSales = new ArrayList<OrdersRecievied>();
		listSales.add(orders);
		listSales.add(orders1);
		listSales.add(orders2);
		when(dao.getAll()).thenReturn(listSales);
		assertEquals(3, controller.getAll().getBody().getData().size());

	}

	@Test
	public void updateOrders() {

		when(dao.update(1, orders)).thenReturn(orders);
		assertEquals(orders, controller.update("Adm_00001", 1, orders).getBody().getData());
	}

	@Test
	public void deleteOrdersTest() {

		boolean bt = true;
		String respon = "Order deleted";
		when(dao.delete(1)).thenReturn(bt);
		assertEquals(respon, controller.delete(1).getBody().getData());

	}

}
