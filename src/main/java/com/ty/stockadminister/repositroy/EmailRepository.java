package com.ty.stockadminister.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.stockadminister.dto.Email;

public interface EmailRepository extends JpaRepository<Email, Integer> {

}
