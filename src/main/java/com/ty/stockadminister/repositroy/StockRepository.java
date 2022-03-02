package com.ty.stockadminister.repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.stockadminister.dto.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {
	
	@Query
	public List< Stock> findByProductName(String name);
	@Query
	public List< Stock> findByReorderLevel(int level);
	@Query("select s from Stock s where s.quantity<=s.reorderLevel")
    public List<Stock> findByLowReorderLevel();

}
