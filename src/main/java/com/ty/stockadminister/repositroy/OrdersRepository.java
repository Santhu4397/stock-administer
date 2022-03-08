package com.ty.stockadminister.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.stockadminister.dto.OrdersRecievied;

public interface OrdersRepository extends JpaRepository<OrdersRecievied, Integer> {

}
