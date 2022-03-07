package com.ty.stockadminister.dao;

import java.util.List;

import com.ty.stockadminister.dto.Staff;

public interface StaffDao {

	public Staff saveStaff(Staff staff);

	public List<Staff> getAllStaff();

	public Staff getStaffById(String id);

	public Staff updateStaff(String uid, Staff staff);

	public boolean deleteStaff(String id);

	public Staff loginStaff(String email, String password);

	public Staff getStaffByName(String name);

}
