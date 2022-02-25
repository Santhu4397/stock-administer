package com.ty.stockadminister.dao.impl;

import java.util.List;
import java.util.Optional;

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
		return repository.save(stock);
	}

	@Override
	public List<Stock> getStock() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Stock updateStock(int id, Stock stock) {
		// TODO Auto-generated method stub
		Stock existingstock=getStockById(id);
		if(existingstock != null) {
			existingstock.setId(stock.getId());
			existingstock.setProduct_Name(stock.getProduct_Name());
			existingstock.setQuantity(stock.getQuantity());
			existingstock.setCategory(stock.getCategory());
			existingstock.setReorder_Level(stock.getReorder_Level());
			existingstock.setReorder_Quantity(stock.getReorder_Quantity());
			existingstock.setTotal_Cost(stock.getTotal_Cost());
			existingstock.setUnit_Price(stock.getUnit_Price());
			existingstock.setOwner1(stock.getOwner1());
			existingstock.setSupplier(stock.getSupplier());
			
			return repository.save(existingstock);
		}
		return null;
	
	}

	@Override
	public Stock getStockById(int id) {
	 Optional<Stock> optional= repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	   
	 }

	@Override
	public boolean deleteStock(int id) {
		Stock stock=getStockById(id);
		if(stock != null) {
			repository.delete(stock);
			return true;
		}
		return false;
	}
	

	@Override
	public List<Stock> getByProduct_Name(String name) {
		return repository.findByProductName(name);
		 
	}

	@Override
	public List< Stock> getByProductReorder_Level(int level) {
		return repository.findByReorderLevel(level);
		
	
	}

}
