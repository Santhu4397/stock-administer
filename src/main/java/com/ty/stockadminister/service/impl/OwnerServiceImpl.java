package com.ty.stockadminister.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;


import com.ty.stockadminister.dao.OwnerDao;
import com.ty.stockadminister.dto.Owner;
import com.ty.stockadminister.dto.Staff;
import com.ty.stockadminister.service.OwnerService;
import com.ty.stockadminister.util.ResponseStructure;


@Service
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
		 Owner owner = dao.loginOwner(email, password);
			ResponseStructure<Owner> structure = new ResponseStructure<Owner>();
			ResponseEntity<ResponseStructure<Owner>> responseEntity = null;
			if (owner !=null) {
				structure.setStatus(HttpStatus.OK.value());
				structure.setMessage("Sucess");
				structure.setData( dao.loginOwner(email, password));
				responseEntity = new ResponseEntity<ResponseStructure<Owner>>(structure, HttpStatus.OK);
			} else {
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setMessage("data not fond");
				structure.setData(null);
				responseEntity = new ResponseEntity<ResponseStructure<Owner>>(structure, HttpStatus.NOT_FOUND);
			}
			return responseEntity;
		
		
	}

}
