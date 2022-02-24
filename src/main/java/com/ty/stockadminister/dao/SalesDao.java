package com.ty.stockadminister.dao;

import java.util.List;

import com.ty.stockadminister.dto.Sales;

public interface SalesDao {

	public Sales save(Sales sales);

	public Sales getByName(String name);

	public List<Sales> getAll();

	public Sales update(int id, Sales sales);
 
	public boolean delete(int id);
	
	
}
