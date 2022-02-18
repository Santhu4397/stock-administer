package com.ty.stockadminister.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.stockadminister.dao.impl.SupplierDaoImpl;

public interface SupplierRepositroy extends JpaRepository<SupplierDaoImpl,Integer> {

}
