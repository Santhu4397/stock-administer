package com.ty.stockadminister.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ty.stockadminister.dao.SupplierDao;
import com.ty.stockadminister.dto.SupplierDto;
import com.ty.stockadminister.repositroy.SupplierRepositroy;

@Repository
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	SupplierRepositroy repository;

	@Override
	public SupplierDto save(SupplierDto dto) {
		return repository.save(dto);
	}

	@Override
	public SupplierDto getbyid(int id) {
		Optional<SupplierDto> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<SupplierDto> getall() {
		return repository.findAll();
	}

	@Override
	public SupplierDto update(int id, SupplierDto supplierDto) {
		SupplierDto exsitingproduct = getbyid(id);
		if (exsitingproduct != null) {
			exsitingproduct.setName(supplierDto.getName());
			exsitingproduct.setMailId(supplierDto.getMailId());
			exsitingproduct.setAddress(supplierDto.getAddress());
			exsitingproduct.setPhone(supplierDto.getPhone());
			return repository.save(exsitingproduct);
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		SupplierDto supplierDto = getbyid(id);
		if (supplierDto != null) {
			repository.delete(supplierDto);
			return true;
		} else {
			return false;
		}
	}

}
