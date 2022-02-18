package com.ty.stockadminister.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.stockadminister.dao.StaffDao;
import com.ty.stockadminister.dto.Staff;
import com.ty.stockadminister.repositroy.StaffRepository;

@Repository
public class StaffDaoImpl implements StaffDao {

	@Autowired
	private StaffRepository repository;

	@Override
	public Staff saveStaff(Staff staff) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Staff> getAllStaff() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Staff getStaffById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Staff updateStaff(int id, Staff staff) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStaff(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Staff loginStaff(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
