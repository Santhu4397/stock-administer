 package com.ty.stockadminister.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.stockadminister.dao.OwnerDao;
import com.ty.stockadminister.dto.Owner;
import com.ty.stockadminister.repositroy.OwnerRepository;

@Repository
public class OwnerDaoImpl implements OwnerDao {

	@Autowired
	private OwnerRepository repository;

	@Override
	public Owner saveOwner(Owner owner) {
		return repository.save(owner);
	}

	@Override
	public Owner loginOwner(String email, String password) {
		
		return repository.getOwnerbyemailandpass(email, password);
	}
}
