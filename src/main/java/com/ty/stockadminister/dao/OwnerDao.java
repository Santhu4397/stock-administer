package com.ty.stockadminister.dao;

import com.ty.stockadminister.dto.Owner;

public interface OwnerDao {

	public Owner saveOwner(Owner owner);

	public Owner loginOwner(Owner owner);
}
