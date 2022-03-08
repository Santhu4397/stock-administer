package com.ty.stockadminister.dao;

import java.util.List;

import com.ty.stockadminister.dto.Orders;

public interface OrdersDao {
	public Orders save(Orders orders);

	public Orders getByOrderId(int orderId);

	public List<Orders> getAll();

	public Orders update(int orderId, Orders orders);

	public boolean delete(int orderId);
}
