package com.ty.stockadminister.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.stockadminister.dao.OrdersDao;
import com.ty.stockadminister.dto.Orders;
import com.ty.stockadminister.dto.Sales;
import com.ty.stockadminister.service.OrdersService;
import com.ty.stockadminister.util.ResponseStructure;
@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	OrdersDao dao;

	@Override
	public ResponseEntity<ResponseStructure<Orders>> save(Orders orders) {
		ResponseStructure<Orders> structuer = new ResponseStructure<Orders>();
		structuer.setStatus(HttpStatus.OK.value());
		structuer.setMessage("successfull");
		structuer.setData(dao.save(orders));
		ResponseEntity<ResponseStructure<Orders>> responseEntity = new ResponseEntity<ResponseStructure<Orders>>(
				structuer, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Orders>>> getAll() {
		ResponseStructure<List<Orders>> structuer = new ResponseStructure<List<Orders>>();
		structuer.setStatus(HttpStatus.OK.value());
		structuer.setMessage("successfull");
		structuer.setData(dao.getAll());
		ResponseEntity<ResponseStructure<List<Orders>>> responseEntity = new ResponseEntity<ResponseStructure<List<Orders>>>(
				structuer, HttpStatus.OK);
		return responseEntity;

	}

	@Override
	public ResponseEntity<ResponseStructure<Orders>> update(int orderId, Orders orders) {
		ResponseStructure<Orders> structuer = new ResponseStructure<Orders>();
		ResponseEntity<ResponseStructure<Orders>> entity = null;
		Orders existing = dao.update(orderId, orders);
		if (existing != null) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.update(orderId, orders));
			entity = new ResponseEntity<ResponseStructure<Orders>>(structuer, HttpStatus.OK);
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> delete(int orderId) {
		ResponseStructure<String> structuer = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> entity;
		if (dao.delete(orderId)) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData("User deleted");
			entity = new ResponseEntity<ResponseStructure<String>>(structuer, HttpStatus.OK);
		} else {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("ID :" + orderId + " NOTFOUND");
			structuer.setData("User not deleted");
			entity = new ResponseEntity<ResponseStructure<String>>(structuer, HttpStatus.NOT_FOUND);
		}
		return entity;
	}



	@Override
	public ResponseEntity<ResponseStructure<Orders>> getByOrderId(int orderId) {
		ResponseStructure<Orders> structuer = new ResponseStructure<Orders>();
		ResponseEntity<ResponseStructure<Orders>> responseEntity;
		Orders orders = dao.getByOrderId(orderId);
		if (orders != null) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.getByOrderId(orderId));
			responseEntity = new ResponseEntity<ResponseStructure<Orders>>(structuer, HttpStatus.OK);

		} else {
			structuer.setStatus(HttpStatus.NOT_FOUND.value());
			structuer.setMessage("Order id :" + orderId + " NOTFOUND");
			structuer.setData(null);
			responseEntity = new ResponseEntity<ResponseStructure<Orders>>(structuer, HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}



	
	

}
