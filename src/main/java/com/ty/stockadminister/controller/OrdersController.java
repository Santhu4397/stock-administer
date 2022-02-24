package com.ty.stockadminister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.stockadminister.dto.Orders;
import com.ty.stockadminister.service.OrdersService;
import com.ty.stockadminister.util.ResponseStructure;
@RestController
public class OrdersController {
	@Autowired
	OrdersService service;
	
	@PostMapping("orders")
	public ResponseEntity<ResponseStructure<Orders>> save(@RequestBody Orders orders) {
		return service.save(orders);
	}
	@GetMapping("orders")
	public ResponseEntity<ResponseStructure<List<Orders>>> getAll(){
		return service.getAll();
		
	}
	@GetMapping("orders/{ordersId}")
	public ResponseEntity<ResponseStructure<Orders>> getByOrderId(@PathVariable int orderId) {
		return service.getByOrderId(orderId);
	}
	
	@DeleteMapping("orders")
	public ResponseEntity<ResponseStructure<String>> delete(@RequestParam int id) {
		return service.delete(id);
	}
}
