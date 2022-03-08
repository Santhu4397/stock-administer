package com.ty.stockadminister.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.stockadminister.dto.OrdersRecievied;
import com.ty.stockadminister.util.ResponseStructure;

public interface OrdersService {
	public ResponseEntity<ResponseStructure<OrdersRecievied>> save(OrdersRecievied orders, String uid, int sid);

	public ResponseEntity<ResponseStructure<OrdersRecievied>> getByOrderId(int orderId);

	public ResponseEntity<ResponseStructure<List<OrdersRecievied>>> getAll();

	public ResponseEntity<ResponseStructure<OrdersRecievied>> update(String uid, int orderId, OrdersRecievied orders);

	public ResponseEntity<ResponseStructure<String>> delete(int orderId);

}
