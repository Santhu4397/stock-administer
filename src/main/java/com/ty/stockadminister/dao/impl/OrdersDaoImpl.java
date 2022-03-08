package com.ty.stockadminister.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.stockadminister.dao.OrdersDao;
import com.ty.stockadminister.dto.OrdersRecievied;
import com.ty.stockadminister.repositroy.OrdersRepository;

@Repository
public class OrdersDaoImpl implements OrdersDao {
	@Autowired
	OrdersRepository repository;

	@Override
	public OrdersRecievied save(OrdersRecievied orders) {
		return repository.save(orders);
	}

	@Override
	public OrdersRecievied getByOrderId(int orderId) {
		Optional<OrdersRecievied> optional = repository.findById(orderId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<OrdersRecievied> getAll() {
		return repository.findAll();
	}

	@Override
	public OrdersRecievied update(int orderId, OrdersRecievied orders) {
		OrdersRecievied exsitingproduct = getByOrderId(orderId);
		if (exsitingproduct != null) {
			exsitingproduct.setOwner2(orders.getOwner2());
			exsitingproduct.setStaff1(orders.getStaff1());
			exsitingproduct.setProductName(orders.getProductName());
			exsitingproduct.setQtyOrder(orders.getQtyOrder());
			exsitingproduct.setQtyRecived(orders.getQtyRecived());
			exsitingproduct.setTotalOrderCost(orders.getTotalOrderCost());
			exsitingproduct.setTotalOrderRecived(orders.getTotalOrderRecived());
			return repository.save(exsitingproduct);
		}
		return null;
	}

	@Override
	public boolean delete(int orderId) {
		OrdersRecievied orders = getByOrderId(orderId);
		if (orders != null) {
			repository.delete(orders);
			return true;
		} else {
			return false;
		}
	}

}
