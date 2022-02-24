package com.ty.stockadminister.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.stockadminister.dto.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {
	
	@Query
	public Stock getByProduct_Name(String name);
	@Query
	public Stock getByProductReorder_Level(int level);

}
