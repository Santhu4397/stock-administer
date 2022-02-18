package com.ty.stockadminister.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ty.stockadminister.dao.OwnerDao;
import com.ty.stockadminister.dto.Owner;
import com.ty.stockadminister.dto.Staff;
import com.ty.stockadminister.service.OwnerService;
import com.ty.stockadminister.util.ResponseStructure;

public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerDao dao;

	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner) {
		ResponseStructure<Owner> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Sucess");
		structure.setData(dao.saveOwner(owner));
		ResponseEntity<ResponseStructure<Owner>> responseEntity = new ResponseEntity<ResponseStructure<Owner>>(
				structure, HttpStatus.OK);
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Owner>> loginOwner(String email, String password) {
		dao.loginOwner(email, password);
		return null;
	}

}
