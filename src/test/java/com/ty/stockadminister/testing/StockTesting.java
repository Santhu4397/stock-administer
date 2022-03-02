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

import com.ty.stockadminister.controller.StockController;
import com.ty.stockadminister.dao.StockDao;
import com.ty.stockadminister.dto.Sales;
import com.ty.stockadminister.dto.Stock;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StockTesting {
	@Autowired
	private  StockController controller;
	@MockBean
	private StockDao dao;
	
	Stock stock = new Stock(1,"samsung","mobail",5000.0,5,50000.0,5,5,null,null,null,null);
	Stock stock1 = new Stock(2,"samsung","mobail",5000.0,5,50000.0,5,5,null,null,null,null);
	Stock stock2 = new Stock(3,"samsung","mobail",5000.0,5,50000.0,5,5,null,null,null,null);
	
	@Test
	public void saveStock() {
		when(dao.saveStock(stock)).thenReturn(stock);
		assertEquals(stock, controller.saveStock(stock).getBody().getData());

	}
	
	@Test
	public void getAllStock() {
		List<Stock> listStock = new ArrayList<Stock>();
		listStock.add(stock);
		listStock.add(stock1);
		listStock.add(stock2);
		when(dao.getStock()).thenReturn(listStock);
		assertEquals(3, controller.getStock().getBody().getData().size());

	}
	
	@Test
	public void updateStock() {

		when(dao.updateStock(1, stock)).thenReturn(stock);
		assertEquals(stock, controller.updateStock(1, stock).getBody().getData());
	}
	
	@Test
	public void getByIdTest() {

		when(dao.getStockById(1)).thenReturn(stock);
		assertEquals(stock, controller.getStockById(1).getBody().getData());

	}
	
	@Test
	public void getByProductNameTest() {
		List<Stock> listStock = new ArrayList<Stock>();
		listStock.add(stock);
		listStock.add(stock1);
		listStock.add(stock2);
		when(dao.getByProduct_Name("samsung")).thenReturn(listStock);
		assertEquals(3, controller.getByProduct_Name("samsung").getBody().getData().size());

	}
	
	@Test
	public void getByProductReorderLevelTest() {
		List<Stock> listStock = new ArrayList<Stock>();
		listStock.add(stock);
		listStock.add(stock1);
		listStock.add(stock2);
		when(dao.getByProductReorder_Level(1)).thenReturn(listStock);
		assertEquals(3, controller.getByProductReorder_Level(1).getBody().getData().size());
	}
	
	@Test
	public void deleteStockTest() {

		boolean bt = true;
		String respon = "deleted";
		when(dao.deleteStock(1)).thenReturn(bt);
		assertEquals(respon, controller.deleteStock(1).getBody().getData());

	}
}
