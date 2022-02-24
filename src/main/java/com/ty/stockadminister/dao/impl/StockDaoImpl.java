package com.ty.stockadminister.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.stockadminister.dao.StockDao;
import com.ty.stockadminister.dto.Stock;
import com.ty.stockadminister.repositroy.StockRepository;

@Repository
public class StockDaoImpl implements StockDao {

		@Autowired
		StockRepository repository;
	@Override
	public Stock saveStock(Stock stock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stock> getStock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock updateStock(int id, Stock stock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock getStockById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStock(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Stock getByProduct_Name(String name) {
		repository.getByProduct_Name(name);
		return null;
	}

	@Override
	public Stock getByProductReorder_Level(int level) {
		repository.getByProductReorder_Level(level);
		return null;
	}

}
