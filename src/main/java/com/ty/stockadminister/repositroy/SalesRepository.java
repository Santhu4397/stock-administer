package com.ty.stockadminister.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.stockadminister.dto.Sales;

public interface SalesRepository extends JpaRepository<Sales, Integer>{

}
