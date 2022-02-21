package com.ty.stockadminister.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.stockadminister.dto.Sales;
import com.ty.stockadminister.util.ResponseStructure;

public interface SalesService {
	
	
	public ResponseEntity<ResponseStructure<Sales>> save(Sales sales);

	public ResponseEntity<ResponseStructure<Sales>> getByName(String name);

	public ResponseEntity<ResponseStructure<List<Sales>>> getAll();

	public ResponseEntity<ResponseStructure<Sales>> update(int id, Sales sales);

	public ResponseEntity<ResponseStructure<String>> delete(int id);

}
