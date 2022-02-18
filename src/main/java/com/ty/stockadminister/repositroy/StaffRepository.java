package com.ty.stockadminister.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.stockadminister.dto.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

}
