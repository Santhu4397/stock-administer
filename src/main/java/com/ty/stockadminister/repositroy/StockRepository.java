package com.ty.stockadminister.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.stockadminister.dto.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}
