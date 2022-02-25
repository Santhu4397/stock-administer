package com.ty.stockadminister.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.stockadminister.dto.Sales;

public interface SalesRepository extends JpaRepository<Sales, Integer>{
	@Query
	public Sales findByName(String name);

}
