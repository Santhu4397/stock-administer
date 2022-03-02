package com.ty.stockadminister.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.stockadminister.dto.Owner;
import com.ty.stockadminister.dto.Staff;
import com.ty.stockadminister.util.ResponseStructure;

public interface OwnerService {

	public ResponseEntity<ResponseStructure<Owner>> loginOwner(String email, String password);

	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner);

	public ResponseEntity<ResponseStructure<List<Owner>>> getAll();

	public ResponseEntity<ResponseStructure<Owner>> getOwnerById(int id);

	public ResponseEntity<ResponseStructure<Owner>> updateOwner(int id, Owner owner);

	public ResponseEntity<ResponseStructure<String>> deleteOwner(int id);

}
