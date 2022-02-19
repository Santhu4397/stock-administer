package com.ty.stockadminister.dao.impl;

import java.util.List;
import java.util.Optional;

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
		return repository.save(staff);
	}

	@Override
	public List<Staff> getAllStaff() {
		return repository.findAll();
	}

	@Override
	public Staff getStaffById(int id) {
		Optional<Staff> staff = repository.findById(id);
		if (staff.isPresent()) {
			return staff.get();
		}
		return null;
	}

	@Override
	public Staff updateStaff(int id, Staff staff) {
		Staff existingStaff = getStaffById(id);
		if (existingStaff != null) {
			existingStaff.setEmail(staff.getEmail());
			existingStaff.setName(staff.getName());
			existingStaff.setPassword(staff.getPassword());
			existingStaff.setPhone(staff.getPhone());
			return repository.save(existingStaff);
		}
		return null;
	}

	@Override
	public boolean deleteStaff(int id) {
		Staff staff = getStaffById(id);
		if (staff != null) {
			repository.delete(staff);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Staff loginStaff(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
