package com.ty.stockadminister.dao;

import java.util.List;

import com.ty.stockadminister.dto.OrdersRecievied;

public interface OrdersDao {
	public OrdersRecievied save(OrdersRecievied orders);

	public OrdersRecievied getByOrderId(int orderId);

	public List<OrdersRecievied> getAll();

	public OrdersRecievied update(int orderId, OrdersRecievied orders);

	public boolean delete(int orderId);
}
