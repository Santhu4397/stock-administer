package com.ty.stockadminister.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ty.stockadminister.dao.OwnerDao;
import com.ty.stockadminister.dao.StaffDao;
import com.ty.stockadminister.dto.Owner;
import com.ty.stockadminister.dto.Staff;
import com.ty.stockadminister.service.StaffService;
import com.ty.stockadminister.util.ResponseStructure;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDao dao;
	@Autowired
	private OwnerDao ownerDao;

	@Override
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff, String id) {
		ResponseStructure<Staff> structure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Staff>> responseEntity = null;
		Owner owner = ownerDao.getOwnerById(id);
		staff.setOwner(owner);
		if (owner != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			structure.setData(dao.saveStaff(staff));
			responseEntity = new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.OK);

		} else {
			structure.setMessage("not Sucess");
			structure.setData(null);
			responseEntity = new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.NOT_FOUND);
		}
		return responseEntity;

		/*
		 * ResponseStructure<Staff> structure = new ResponseStructure<>();
		 * structure.setStatus(HttpStatus.OK.value()); structure.setMessage("Sucess");
		 * structure.setData(dao.saveStaff(staff));
		 * ResponseEntity<ResponseStructure<Staff>> responseEntity = new
		 * ResponseEntity<ResponseStructure<Staff>>( structure, HttpStatus.OK); return
		 * responseEntity;
		 */
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Staff>>> getAllStaff() {
		ResponseStructure<List<Staff>> structure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<List<Staff>>> responseEntity = null;
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Sucess");
		structure.setData(dao.getAllStaff());
		responseEntity = new ResponseEntity<ResponseStructure<List<Staff>>>(structure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Staff>> getStaffById(String id) {
		ResponseStructure<Staff> structure = new ResponseStructure<Staff>();
		ResponseEntity<ResponseStructure<Staff>> responseEntity = null;
		Staff staff = dao.getStaffById(id);
		if (staff != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			structure.setData(dao.getStaffById(id));
			responseEntity = new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.OK);

		} else {
			structure.setMessage("not Sucess");
			structure.setData(null);
			responseEntity = new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(String id, Staff staff) {
		ResponseStructure<Staff> structure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Staff>> responseEntity = null;
		Staff staff1 = dao.updateStaff(id, staff);
		if (staff1 != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			structure.setData(dao.updateStaff(id, staff1));
			responseEntity = new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.OK);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("not Sucess");
			structure.setData(null);
			responseEntity = new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteStaff(String id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity = null;
		if (dao.deleteStaff(id)) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			structure.setData("Staff deleted");
			responseEntity = new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("data not fond");
			structure.setData("Staff not  deleted");
			responseEntity = new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Staff>> loginStaff(String email, String password) {
		Staff staff = dao.loginStaff(email, password);
		ResponseStructure<Staff> structure = new ResponseStructure<Staff>();
		ResponseEntity<ResponseStructure<Staff>> responseEntity = null;
		if (staff != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			structure.setData(dao.loginStaff(email, password));
			responseEntity = new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.OK);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("data not fond");
			structure.setData(null);
			responseEntity = new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.NOT_FOUND);
		}
		return responseEntity;

	}

	@Override
	public ResponseEntity<ResponseStructure<Staff>> getStaffByName(String name) {
		// TODO Auto-generated method stub
		ResponseStructure<Staff> structure = new ResponseStructure<Staff>();
		ResponseEntity<ResponseStructure<Staff>> responseEntity = null;
		Staff staff = dao.getStaffByName(name);
		if (staff != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			structure.setData(dao.getStaffByName(name));
			responseEntity = new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.OK);

		} else {
			structure.setMessage("not Sucess");
			structure.setData(null);
			responseEntity = new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.NOT_FOUND);
		}
		return responseEntity;

	}

}
