package com.ty.stockadminister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.stockadminister.dto.OrdersRecievied;
import com.ty.stockadminister.service.OrdersService;
import com.ty.stockadminister.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class OrdersController {
	@Autowired
	OrdersService service;

	@PostMapping("orders/userid/{uid}/supplierid/{sid}")
	@ApiOperation("To save order")
	@ApiResponses({ @ApiResponse(code = 200, message = "Order Saved"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<OrdersRecievied>> save(@RequestBody OrdersRecievied orders, @PathVariable String uid,
			@PathVariable int sid) {
		return service.save(orders, uid, sid);
	}

	@GetMapping("orders")
	@ApiOperation("To Get all the orders")
	@ApiResponses({ @ApiResponse(code = 200, message = "Orders Found"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<List<OrdersRecievied>>> getAll() { 
		return service.getAll();

	}

	@GetMapping("orders/{ordersId}")
	@ApiOperation("To Get order by order Id ")
	@ApiResponses({ @ApiResponse(code = 200, message = "Order found"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })


	public ResponseEntity<ResponseStructure<OrdersRecievied>> getByOrderId(@PathVariable int orderId) {


		System.out.println(orderId);
		return service.getByOrderId(orderId);
	}

	@DeleteMapping("orders")
	@ApiOperation("To Get order by order Id ")
	@ApiResponses({ @ApiResponse(code = 200, message = "Order deleted"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<String>> delete(@RequestParam int id) {
		return service.delete(id);
	}

	@PutMapping("orders/userid/{uid}/orderid/{id}")
	@ApiOperation("To Update orders")
	@ApiResponses({ @ApiResponse(code = 200, message = "sales orders"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<OrdersRecievied>> update(@ApiParam("Update for orders") @PathVariable String uid,
			@PathVariable int id, @RequestBody OrdersRecievied orders) {
		return service.update(uid,id, orders);
	}
	
	@GetMapping("ordersobject")
	public OrdersRecievied imTheStockObject() {
		return new OrdersRecievied();
	}
}
