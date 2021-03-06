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

import com.ty.stockadminister.dto.LoginDto;
import com.ty.stockadminister.dto.Owner;
import com.ty.stockadminister.dto.Sales;
import com.ty.stockadminister.dto.Staff;
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

	@Autowired
	private StaffService staffService;

	@Autowired
	private StaffService service1;

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

	@GetMapping("owner")
	@ApiOperation("To get all owner")
	@ApiResponses({ @ApiResponse(code = 200, message = "Owners list found"),
			@ApiResponse(code = 404, message = " Didnot find"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<List<Owner>>> getAll() {
		return service.getAll();

	}

	@GetMapping("owner/{id}")
	@ApiOperation("To Get Owner By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Found the Owner by ID"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Owner>> getOwnerById(
			@ApiParam("To Get Owner By ID") @PathVariable String id) {
		return service.getOwnerById(id);
	}

	@PutMapping("owner/{id}")
	@ApiOperation("To Update owner")
	@ApiResponses({ @ApiResponse(code = 200, message = "Owner Updated"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })

	public ResponseEntity<ResponseStructure<Owner>> updateOwener(@ApiParam("Update for Owner") @PathVariable String id,

			@RequestBody Owner owner) {
		return service.updateOwner(id, owner);
	}

	@DeleteMapping("owner")
	@ApiOperation("To Delete owner")
	@ApiResponses({ @ApiResponse(code = 200, message = "Owner Deleted"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<String>> deleteOwner(
			@ApiParam("Delete for Owner") @RequestParam String id) {
		return service.deleteOwner(id);
	}

	@PutMapping("owner/{uid}/staff/{id}")
	@ApiOperation("To Update Staff")
	@ApiResponses({ @ApiResponse(code = 200, message = "Staff Updated"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@ApiParam("Update for Staff") @PathVariable String uid,
			@PathVariable String id, @RequestBody Staff staff) {
		return service1.updateStaff(uid, id, staff);
	}

	@DeleteMapping("owner/{uid}/staff")
	@ApiOperation("To Delete Staff")
	@ApiResponses({ @ApiResponse(code = 200, message = "Staff Deleted"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<String>> deleteStaff(@ApiParam("Delete for Staff") @PathVariable String uid,
			@RequestParam String id) {
		return staffService.deleteStaff(uid,id);
	}

	@GetMapping("owner/hi")
	public Owner hi() {
		return new Owner();
	}

}
