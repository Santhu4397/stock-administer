package com.ty.stockadminister.dao;

import java.util.List;

import com.ty.stockadminister.dto.Stock;

public interface StockDao {
	public Stock saveStock(Stock stock);

	public List<Stock> getStock();

	public Stock updateStock(int id, Stock stock);

	public Stock getStockById(int id);

	public boolean deleteStock(int id);
	
	public List<Stock> getByProduct_Name(String name);
	
	public List< Stock> getByProductReorder_Level(int level);

}
