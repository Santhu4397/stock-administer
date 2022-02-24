package com.ty.stockadminister.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.stockadminister.dao.OrdersDao;
import com.ty.stockadminister.dto.Orders;
import com.ty.stockadminister.repositroy.OrdersRepository;
@Repository
public class OrdersDaoImpl  implements OrdersDao{
	@Autowired
	OrdersRepository repository;
	
	@Override
	public Orders save(Orders orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders getByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders update(int orderId, Orders orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int orderId) {
		// TODO Auto-generated method stub
		return false;
	}

}
