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

import com.ty.stockadminister.dto.SupplierDto;
import com.ty.stockadminister.service.SupplierService;

import com.ty.stockadminister.util.ResponseStructure;

@RestController
public class SupplierController {
	@Autowired
	SupplierService service;

	@PostMapping("supplier")
	public ResponseEntity<ResponseStructure<SupplierDto>> save(@RequestBody SupplierDto dto) {

		return service.save(dto);
	}

	@PutMapping("supplier/{supplieID}")
	public ResponseEntity<ResponseStructure<SupplierDto>> update(@PathVariable int supplieID,
			@RequestBody SupplierDto dto) {
		return service.update(supplieID, dto);
	}

	@GetMapping("supplier")
	public ResponseEntity<ResponseStructure<List<SupplierDto>>> getall() {
		return service.getall();
	}

	@GetMapping("supplier/{id}")
	public ResponseEntity<ResponseStructure<SupplierDto>> getbyid(@PathVariable int id) {
		return service.getbyid(id);
	}

	@DeleteMapping("supplier")
	public ResponseEntity<ResponseStructure<String>> delete(@RequestParam int id) {
		return service.delete(id);
	}
}
