package com.ty.stockadminister.dao;

import java.util.List;

import com.ty.stockadminister.dto.Staff;

public interface StaffDao {

	public Staff saveStaff(Staff staff);

	public List<Staff> getAllStaff();

	public Staff getStaffById(int id);

	public Staff updateStaff(int id, Staff staff);

	public boolean deleteStaff(int id);

	public Staff loginStaff(String email, String password);

}
