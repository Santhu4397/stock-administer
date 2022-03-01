package com.ty.stockadminister.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.ty.stockadminister.dto.Owner;
import com.ty.stockadminister.dto.Staff;
import com.ty.stockadminister.util.ResponseStructure;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
	
	@Query("select o from Staff o where o.email=?1 and o.password=?2 ")
	public Staff getStaffbyemailandpass(String email,String pass);
	
	@Query
	public Staff getStaffByName(String name);

}
