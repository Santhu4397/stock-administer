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
import com.ty.stockadminister.service.impl.StockServiceImpl;
import com.ty.stockadminister.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class StockController {
	@Autowired
	StockServiceImpl stockservice;

	@PostMapping("stock")
	@ApiOperation("To save stock")
	@ApiResponses({ @ApiResponse(code = 200, message = "Stock saved"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Stock>> saveStock(@RequestBody Stock stock) {
		return stockservice.saveService(stock);
	}

	@GetMapping("stock")
	@ApiOperation("To Get all the stock")
	@ApiResponses({ @ApiResponse(code = 200, message = "Stock Found"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<List<Stock>>> getStock() {

		return stockservice.getStock();
	}

	@PutMapping("stock")
	@ApiOperation("To update the stock")
	@ApiResponses({ @ApiResponse(code = 200, message = "Stock updated"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Stock>> updateStock(@RequestParam int id, @RequestBody @Valid Stock stock) {
		return stockservice.updateStock(id, stock);

	}

	@GetMapping("stock/{stockId}")
	@ApiOperation("To Get stock by ID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Stock found by id"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Stock>> getStockById(@PathVariable("stockId") int id) {
		return stockservice.getStockById(id);
	}

	@DeleteMapping("stock")
	@ApiOperation("To delete the stock")
	@ApiResponses({ @ApiResponse(code = 200, message = "Stock deleted"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<String>> deleteStock(@RequestParam int id) {
		return stockservice.deleteStock(id);
	}

	@GetMapping("stock/product/{productname}")
	@ApiOperation("To get by product name")
	@ApiResponses({ @ApiResponse(code = 200, message = "Stock found by name"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<List<Stock>>> getByProduct_Name(@PathVariable String productname) {
		return stockservice.getByProduct_Name(productname);
	}

	@GetMapping("stock/ProductReorder_Level/{level}")
	@ApiOperation("To get by product reorder level")
	@ApiResponses({ @ApiResponse(code = 200, message = "Stock found by reorder level"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<List<Stock>>> getByProductReorder_Level(@PathVariable int level) {
		return stockservice.getByReorder_Level(level);
	}

	@GetMapping("stockobject")
	public Stock imTheStockObject() {
		return new Stock();
	}

}
