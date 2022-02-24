package com.ty.stockadminister.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.ty.stockadminister.dto.Stock;
import com.ty.stockadminister.service.Stockservice;
import com.ty.stockadminister.util.ResponseStructure;

@RestController
public class StockController {
	@Autowired
	Stockservice stockservice;

	@PostMapping("stock")
	public ResponseEntity<ResponseStructure<Stock>> saveStock(@RequestBody Stock stock) {
		return stockservice.saveService(stock);
	}

	@GetMapping("stock")
	public ResponseEntity<ResponseStructure<List<Stock>>> getStock() {

		return stockservice.getStock();
	}

	@PutMapping("stock")
	public ResponseEntity<ResponseStructure<Stock>> updateStock(@RequestParam int id, @RequestBody @Valid Stock stock) {
		return stockservice.updateStock(id, stock);

	}

	@GetMapping("stock/{stockId}")
	public ResponseEntity<ResponseStructure<Stock>> getStockById(@PathVariable("stockId") int id) {
		return stockservice.getStockById(id);
	}

	@DeleteMapping("stock")
	public ResponseEntity<ResponseStructure<String>> deleteStock(@RequestParam int id) {
		return stockservice.deleteStock(id);
	}
	@GetMapping("stock/product/{productname}")
	public ResponseEntity<ResponseStructure<Stock>> getByProduct_Name(@PathVariable String productname) {
		return stockservice.getByProduct_Name(productname);
	}
	@GetMapping("stock/ProductReorder_Level/{level}")
	public ResponseEntity<ResponseStructure<Stock>> getByProductReorder_Level(@PathVariable int level) {
		return stockservice.getByProductReorder_Level(level );
	}
	
}
