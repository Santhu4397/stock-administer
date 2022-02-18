package com.ty.stockadminister.service;

import org.springframework.http.ResponseEntity;

import com.ty.stockadminister.dto.Owner;
import com.ty.stockadminister.util.ResponseStructure;

public interface OwnerService {

	public ResponseEntity<ResponseStructure<Owner>> loginOwner(String email, String password);

	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner);

}
