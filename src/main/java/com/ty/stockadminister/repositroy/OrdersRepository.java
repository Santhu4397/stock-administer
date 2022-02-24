package com.ty.stockadminister.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.stockadminister.dto.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
