package com.ty.stockadminister.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.stockadminister.dto.Owner;

public interface OwnerRepository extends JpaRepository<Owner, String> {
	
	@Query("select o from Owner o where o.email=?1 and o.password=?2 ")
	public Owner getOwnerbyemailandpass(String email,String pass);
	
	

}
