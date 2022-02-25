package com.ty.stockadminister.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.stockadminister.dao.SalesDao;
import com.ty.stockadminister.dto.Sales;
import com.ty.stockadminister.repositroy.SalesRepository;

@Repository
public class SalesDaoImpl implements SalesDao {
	@Autowired
	SalesRepository repository;

	@Override
	public Sales save(Sales sales) {
		return repository.save(sales);
	}

	@Override
	public Sales getByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<Sales> getAll() {
		return repository.findAll();
	}

	@Override
	public Sales update(int id, Sales sales) {
		Sales exsitingproduct = getById(id);
		if (exsitingproduct != null) {
			exsitingproduct.setName(sales.getName());
			exsitingproduct.setEmail(sales.getEmail());
			exsitingproduct.setDate_and_time(sales.getDate_and_time());
			exsitingproduct.setPhone(sales.getPhone());
			exsitingproduct.setQty(sales.getQty());
			exsitingproduct.setPrice(sales.getPrice());
			return repository.save(exsitingproduct);
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		Sales sales = getById(id);
		if (sales != null) {
			repository.delete(sales);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Sales getById(int id) {
		Optional<Sales> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}
