package com.ty.stockadminister.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.stockadminister.dao.impl.SupplierDaoImpl;
import com.ty.stockadminister.dto.SupplierDto;

public interface SupplierRepositroy extends JpaRepository<SupplierDto,Integer> {

}
