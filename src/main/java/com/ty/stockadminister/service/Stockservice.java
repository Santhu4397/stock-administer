package com.ty.stockadminister.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.stockadminister.dto.Stock;
import com.ty.stockadminister.util.ResponseStructure;

public interface Stockservice {
	public ResponseEntity<ResponseStructure<Stock>> saveService(Stock product);

	public ResponseEntity<ResponseStructure<List<Stock>>> getStock();

	public ResponseEntity<ResponseStructure<Stock>> updateStock(int id, Stock product);

	public ResponseEntity<ResponseStructure<Stock>> getStockById(int id);

	public ResponseEntity<ResponseStructure<String>> deleteStock(int id);

	public ResponseEntity<ResponseStructure<List<Stock>>> getByProduct_Name(String name);

	public ResponseEntity<ResponseStructure<List<Stock>>> getByReorder_Level(int level);

}
