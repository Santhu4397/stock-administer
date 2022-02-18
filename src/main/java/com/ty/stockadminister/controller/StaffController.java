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

import com.ty.stockadminister.dto.Staff;
import com.ty.stockadminister.service.StaffService;
import com.ty.stockadminister.service.impl.StaffServiceImpl;
import com.ty.stockadminister.util.ResponseStructure;


@RestController
public class StaffController {

	@Autowired
	private StaffService service;

	@PostMapping("staff/{email}/{password}")
	public ResponseEntity<ResponseStructure<Staff>> loginStaff(@RequestBody Staff staff) {
		return service.loginStaff(staff);
	}

	@PostMapping("staff")
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff) {
		return service.saveStaff(staff);
	}

	@PutMapping("staff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@PathVariable int id, @RequestBody Staff staff) {
		return service.updateStaff(id, staff);
	}

	@DeleteMapping("staff")
	public ResponseEntity<ResponseStructure<String>> deleteStaff(@RequestParam int id) {
		return service.deleteStaff(id);
	}

	@GetMapping("staff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> getStaffById(@PathVariable int id) {
		return service.getStaffById(id);
	}

	@GetMapping("staff")
	public ResponseEntity<ResponseStructure<List<Staff>>> getAllStaff() {
		return service.getAllStaff();
	}

}
