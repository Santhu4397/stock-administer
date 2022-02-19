package com.ty.stockadminister.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.stockadminister.dao.SalesDao;
import com.ty.stockadminister.dto.Sales;
import com.ty.stockadminister.repositroy.SalesRepository;

@Repository
public class SalesDaoImpl implements SalesDao {
	@Autowired
	SalesRepository repository;

	@Override
	public Sales save(Sales sales) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sales getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sales> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sales update(int id, Sales sales) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		return false;
		// TODO Auto-generated method stub
		
	}
}
