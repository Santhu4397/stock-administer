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

import com.ty.stockadminister.dto.SupplierDto;
import com.ty.stockadminister.service.SupplierService;

import com.ty.stockadminister.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class SupplierController {
	@Autowired
	SupplierService service;

	@PostMapping("supplier/userid/{id}")
	@ApiOperation("To save the supplier")
	@ApiResponses({ @ApiResponse(code = 200, message = "Supplier saved"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<SupplierDto>> save(@RequestBody @Valid SupplierDto dto,@PathVariable String id) {

		return service.save(dto,id);
	}

	@PutMapping("supplier/{supplieID}")
	@ApiOperation("To update the supplier")
	@ApiResponses({ @ApiResponse(code = 200, message = "Supplier updated"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<SupplierDto>> update(@PathVariable int supplieID,
			@RequestBody SupplierDto dto) {
		return service.update(supplieID, dto);
	}

	@GetMapping("supplier")
	@ApiOperation("To get the list of supplier")
	@ApiResponses({ @ApiResponse(code = 200, message = "Supplier list found"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<List<SupplierDto>>> getall() {
		return service.getall();
	}

	@GetMapping("supplier/{id}")
	@ApiOperation("To get supplier by ID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Supplier found"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<SupplierDto>> getbyid(@RequestParam int id) {
		return service.getbyid(id);
	}

	@DeleteMapping("supplier")
	@ApiOperation("To delete the supplier by ID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Supplier deleted"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<String>> delete(@RequestParam int id) {
		return service.delete(id);
	}
	@GetMapping("supplier/hi")
	public SupplierDto hi() {
		return new SupplierDto();
		
	}
}
