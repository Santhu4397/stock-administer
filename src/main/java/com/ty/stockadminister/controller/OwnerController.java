package com.ty.stockadminister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.stockadminister.dto.Owner;
import com.ty.stockadminister.service.OwnerService;
import com.ty.stockadminister.service.StaffService;
import com.ty.stockadminister.util.ResponseStructure;

@RestController
public class OwnerController {
	
	@Autowired
	private OwnerService service;
	
	
	@PostMapping("owner/{email}/{password}")
	public ResponseEntity<ResponseStructure<Owner>> loginStaff(@RequestBody Owner owner) {
		return service.loginOwner(owner);
	}

	@PostMapping("owner")
	public ResponseEntity<ResponseStructure<Owner>> saveStaff(@RequestBody Owner owner) {
		return service.saveOwner(owner);
	}

}
