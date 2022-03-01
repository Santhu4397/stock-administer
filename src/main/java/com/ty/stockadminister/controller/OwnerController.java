package com.ty.stockadminister.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.stockadminister.dto.LoginDto;
import com.ty.stockadminister.dto.Owner;
import com.ty.stockadminister.service.OwnerService;
import com.ty.stockadminister.service.StaffService;
import com.ty.stockadminister.service.impl.OwnerServiceImpl;
import com.ty.stockadminister.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class OwnerController {

	@Autowired
	private OwnerService service;

	@PostMapping("owner/login")
	@ApiOperation("Login for owner")
	@ApiResponses({ @ApiResponse(code = 200, message = "Owner Loged In"),
			@ApiResponse(code = 404, message = " Didnot Find"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Owner>> loginOwner(
			@ApiParam("Login for Owner") @RequestBody @Valid LoginDto dto) {
		String email = dto.getEmail();
		String password = dto.getPassword();
		System.out.println(dto.getEmail() + dto.getPassword());
		return service.loginOwner(email, password);
	}

	@PostMapping("owner")
	@ApiOperation("To save the owner")
	@ApiResponses({ @ApiResponse(code = 200, message = "Saved Owner"),
			@ApiResponse(code = 404, message = " Didnot persist"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(
			@ApiParam("Save the Owner") @RequestBody @Valid Owner owner) {
		return service.saveOwner(owner);
	}

	@GetMapping("hi")
	public Owner get() {
		return new Owner();

	}
}
