package com.ty.stockadminister.dao;

import java.util.List;

import com.ty.stockadminister.dto.Owner;

public interface OwnerDao {

	public Owner saveOwner(Owner owner);

	public Owner loginOwner(String email, String password);

	public Owner getOwnerById(int id);

	public List<Owner> getAllOwner();
}
