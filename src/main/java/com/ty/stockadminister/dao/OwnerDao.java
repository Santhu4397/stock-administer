package com.ty.stockadminister.dao;

import java.util.List;

import com.ty.stockadminister.dto.Owner;

public interface OwnerDao {

	public Owner saveOwner(Owner owner);

	public Owner loginOwner(String email, String password);

	public Owner getOwnerById(String id);

	public List<Owner> getAllOwner();

	public Owner updateOwner(int id, Owner owner);

	public boolean deleteOwner(int id);
}
