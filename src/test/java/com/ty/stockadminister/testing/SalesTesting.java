package com.ty.stockadminister.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ty.stockadminister.controller.SalesController;
import com.ty.stockadminister.dao.SalesDao;
import com.ty.stockadminister.dto.Sales;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SalesTesting {
	@Autowired
	private SalesController controller;
	@MockBean
	private SalesDao dao;
	Sales sales = new Sales(1, "mobail", LocalDateTime.now(), "abhi@gmail.com", 98809878, 2, 50000.0, null);
	Sales sales1 = new Sales(2, "mobail", LocalDateTime.now(), "abhi@gmail.com", 98809878, 2, 50000.0, null);
	Sales sales2 = new Sales(3, "mobail", LocalDateTime.now(), "abhi@gmail.com", 98809878, 2, 50000.0, null);

	@Test
	public void savesales() {
		when(dao.save(sales)).thenReturn(sales);
		assertEquals(sales, controller.save(sales, 1, "Adm_00001").getBody().getData());

	}

	@Test
	public void getByIdTest() {

		when(dao.getById(1)).thenReturn(sales);
		assertEquals(sales, controller.getById(1).getBody().getData());

	}

	@Test
	public void getAllSales() {
		List<Sales> listSales = new ArrayList<Sales>();
		listSales.add(sales);
		listSales.add(sales2);
		listSales.add(sales2);
		when(dao.getAll()).thenReturn(listSales);
		assertEquals(3, controller.getAll().getBody().getData().size());

	}

	@Test
	public void updateSalesr() {

		when(dao.update(1, sales)).thenReturn(sales);
		assertEquals(sales, controller.update(1, "Adm_00001", sales).getBody().getData());
	}

	@Test
	public void deleteSalesTest() {

		boolean bt = true;
		String respon = "User deleted";
		when(dao.delete(1)).thenReturn(bt);
		assertEquals(respon, controller.delete(1).getBody().getData());

	}

	@Test
	public void getByNameOfSales() {

		when(dao.getByName("mobail")).thenReturn(sales);
		assertEquals(sales, controller.getByName("mobail").getBody().getData());

	}

}
