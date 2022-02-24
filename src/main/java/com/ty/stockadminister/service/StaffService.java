package com.ty.stockadminister.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.stockadminister.dto.Staff;
import com.ty.stockadminister.util.ResponseStructure;

public interface StaffService {

	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff);

	public ResponseEntity<ResponseStructure<List<Staff>>> getAllStaff();

	public ResponseEntity<ResponseStructure<Staff>> getStaffById(int id);

	public ResponseEntity<ResponseStructure<Staff>> updateStaff(int id, Staff staff);

	public ResponseEntity<ResponseStructure<String>> deleteStaff(int id);

	public ResponseEntity<ResponseStructure<Staff>> loginStaff(String email, String password);

	public ResponseEntity<ResponseStructure<Staff>> getStaffByName(String name);

}
