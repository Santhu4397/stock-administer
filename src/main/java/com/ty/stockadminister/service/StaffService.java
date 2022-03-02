package com.ty.stockadminister.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.stockadminister.dto.Staff;
import com.ty.stockadminister.util.ResponseStructure;

public interface StaffService {

	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff);

	public ResponseEntity<ResponseStructure<List<Staff>>> getAllStaff();

	public ResponseEntity<ResponseStructure<Staff>> getStaffById(String id);

	public ResponseEntity<ResponseStructure<Staff>> updateStaff(String id, Staff staff);

	public ResponseEntity<ResponseStructure<String>> deleteStaff(String id);

	public ResponseEntity<ResponseStructure<Staff>> loginStaff(String email, String password);

	public ResponseEntity<ResponseStructure<Staff>> getStaffByName(String name);

}
