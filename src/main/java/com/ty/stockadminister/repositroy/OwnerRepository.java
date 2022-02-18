package com.ty.stockadminister.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.stockadminister.dto.Owner;


public interface OwnerRepository extends JpaRepository<Owner, Integer> {

}
