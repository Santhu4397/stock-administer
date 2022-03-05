package com.ty.stockadminister.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.stockadminister.dto.Email;
import com.ty.stockadminister.util.ResponseStructure;
@Service
public class EmailServiceImpl {

	ResponseStructure<Email> structure = new ResponseStructure<>();
	ResponseEntity<ResponseStructure<Email>> responseEntity = null;
		
	public ResponseEntity<ResponseStructure<Email>> saveEmail(Email email) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ResponseEntity<ResponseStructure<List<Email>>> getAllEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ResponseEntity<ResponseStructure<Email>> getEmailById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ResponseEntity<ResponseStructure<Email>> updateEmail(int id, Email email) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteEmail(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
