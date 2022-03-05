package com.ty.stockadminister.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.stockadminister.dao.EmailDao;
import com.ty.stockadminister.dto.Email;
import com.ty.stockadminister.util.ResponseStructure;



@Service
public class EmailServiceImpl {
	@Autowired
	EmailDao dao;
	public ResponseEntity<ResponseStructure<Email>> saveEmail(Email email) {
		ResponseStructure<Email> structure = new ResponseStructure<Email>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(dao.saveEmail(email));
		ResponseEntity<ResponseStructure<Email>> responseEntity = new ResponseEntity<ResponseStructure<Email>>(
				structure, HttpStatus.OK);
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<List<Email>>> getAllEmail() {
		ResponseStructure<List<Email>> structure = new ResponseStructure<List<Email>>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(dao.getAllEmail());
		ResponseEntity<ResponseStructure<List<Email>>> responseEntity = new ResponseEntity<ResponseStructure<List<Email>>>(
				structure, HttpStatus.OK);
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Email>> getEmailById(int id) {
		ResponseEntity<ResponseStructure<Email>> entity;
		ResponseStructure<Email> structure = new ResponseStructure<Email>();
		Email email = dao.getEmailById(id);
		if (email != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("success");
			structure.setData(dao.getEmailById(id));
			entity = new ResponseEntity<ResponseStructure<Email>>(structure, HttpStatus.OK);
		} else {

			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Id ="+id+"not found ");
			structure.setData(null);
			entity = new ResponseEntity<ResponseStructure<Email>>(structure, HttpStatus.NOT_FOUND);
		}
		return entity;
	}

	public ResponseEntity<ResponseStructure<Email>> updateEmail(int id, Email email) {
		ResponseStructure<Email> structure = new ResponseStructure<Email>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Order updated");
		structure.setData(dao.updateEmail(id, email));
		ResponseEntity<ResponseStructure<Email>> responseEntity = new ResponseEntity<ResponseStructure<Email>>(
				structure, HttpStatus.OK);
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<String>> deleteEmail(int id) {
		ResponseStructure<String> structuer = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> entity;
		if (dao.deleteEmail(id)) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData("email deleted");
			entity = new ResponseEntity<ResponseStructure<String>>(structuer, HttpStatus.OK);
		} else {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("ID :" + id + " NOTFOUND");
			structuer.setData("email not deleted");
			entity = new ResponseEntity<ResponseStructure<String>>(structuer, HttpStatus.NOT_FOUND);
		}
		return entity; 
	}

}
