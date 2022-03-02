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
import com.ty.stockadminister.dto.Staff;
import com.ty.stockadminister.service.StaffService;
import com.ty.stockadminister.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class StaffController {

	@Autowired
	private StaffService service;

	@PostMapping("staff/login")
	@ApiOperation("To Staff Login")
	@ApiResponses({ @ApiResponse(code = 200, message = "Staff Loged In"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Staff>> loginStaff(
			@ApiParam("Login for Staff") @RequestBody @Valid LoginDto dto) {
		String email = dto.getEmail();
		String password = dto.getPassword();
		return service.loginStaff(email, password);
	}

	@PostMapping("staff/ownerid")
	@ApiOperation("To Save Staff")
	@ApiResponses({ @ApiResponse(code = 200, message = "Staff Created"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(
			@ApiParam("To Save Staff") @RequestBody @Valid Staff staff, @RequestParam int id) {
		return service.saveStaff(staff, id);
	}

	@PutMapping("staff/{id}")
	@ApiOperation("To Update Staff")
	@ApiResponses({ @ApiResponse(code = 200, message = "Staff Updated"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@ApiParam("Update for Staff") @PathVariable String id,
			@RequestBody Staff staff) {
		return service.updateStaff(id, staff);
	}

	@DeleteMapping("staff")
	@ApiOperation("To Delete Staff")
	@ApiResponses({ @ApiResponse(code = 200, message = "Staff Deleted"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<String>> deleteStaff(@ApiParam("Delete for Staff") @RequestParam String id) {
		return service.deleteStaff(id);
	}

	@GetMapping("staff/{id}")
	@ApiOperation("To Get Staff By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Found the Staff by ID"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Staff>> getStaffById(@ApiParam("To Get Staff By ID") @PathVariable String id) {
		return service.getStaffById(id);
	}

	@GetMapping("staff")
	@ApiOperation("To Get List of Staff")
	@ApiResponses({ @ApiResponse(code = 200, message = "List of Staff Found"),
			@ApiResponse(code = 404, message = " Didnot Find"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<List<Staff>>> getAllStaff() {
		return service.getAllStaff();
	}

	@GetMapping("staff/name/{name}")
	@ApiOperation("To Get Staff name")
	@ApiResponses({ @ApiResponse(code = 200, message = "List of Staff Found"),
			@ApiResponse(code = 404, message = " Didnot Find"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Staff>> getStaffByName(@PathVariable String name) {
		return service.getStaffByName(name);
	}
	@GetMapping("staff/hi")
	public Staff hi() {
		return new Staff();
	}

}
