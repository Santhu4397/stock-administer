package com.ty.stockadminister.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.stockadminister.dto.Orders;
import com.ty.stockadminister.util.ResponseStructure;

public interface OrdersService {
	public ResponseEntity<ResponseStructure<Orders>> save(Orders orders, String uid, int sid);

	public ResponseEntity<ResponseStructure<Orders>> getByOrderId(int orderId);

	public ResponseEntity<ResponseStructure<List<Orders>>> getAll();

	public ResponseEntity<ResponseStructure<Orders>> update(String uid, int orderId, Orders orders);

	public ResponseEntity<ResponseStructure<String>> delete(int orderId,String oid);

}
