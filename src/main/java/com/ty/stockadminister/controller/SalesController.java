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
import com.ty.stockadminister.util.ResponseStructure;
import com.ty.stockadminister.dto.Sales;
import com.ty.stockadminister.service.SalesService;

@RestController
public class SalesController {

	@Autowired
	SalesService service;
	@PostMapping("sales")
	public ResponseEntity<ResponseStructure<Sales>> save(@RequestBody Sales sales) {
		return service.save(sales);
	}
	@GetMapping("sales")
	public ResponseEntity<ResponseStructure<List<Sales>>> getAll(){
		return service.getAll();
		
	}
	@GetMapping("sales/{name}")
	public ResponseEntity<ResponseStructure<Sales>> getByName(@PathVariable String name) {
		return service.getByName(name);
	}
	
	@DeleteMapping("sales")
	public ResponseEntity<ResponseStructure<String>> delete(@RequestParam int id) {
		return service.delete(id);
	}
	
}
