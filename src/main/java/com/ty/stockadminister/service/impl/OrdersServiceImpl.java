package com.ty.stockadminister.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.stockadminister.dao.OrdersDao;
import com.ty.stockadminister.dao.OwnerDao;
import com.ty.stockadminister.dao.StaffDao;
import com.ty.stockadminister.dao.SupplierDao;
import com.ty.stockadminister.dto.Orders;
import com.ty.stockadminister.dto.Owner;
import com.ty.stockadminister.dto.Staff;
import com.ty.stockadminister.dto.SupplierDto;
import com.ty.stockadminister.service.OrdersService;
import com.ty.stockadminister.util.ResponseStructure;

import ch.qos.logback.core.joran.spi.NoAutoStart;

@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	OrdersDao dao;
	@Autowired
	OwnerDao ownerDao;
	@Autowired
	StaffDao staffDao;
	@Autowired
	SupplierDao supplierDao;

	@Override
	public ResponseEntity<ResponseStructure<Orders>> save(Orders orders, String uid, int sid) {
		Owner owner = ownerDao.getOwnerById(uid);

		Staff staff = null;
		SupplierDto supplier = supplierDao.getbyid(sid);
		ResponseStructure<Orders> structuer = new ResponseStructure<Orders>();
		ResponseEntity<ResponseStructure<Orders>> responseEntity;
		if (owner == null) {
			staff = staffDao.getStaffById(uid);

		}
		if ((owner != null || staff != null) && supplier != null) {
			orders.setOwner2(owner);
			orders.setStaff1(staff);
			orders.setDto(supplier);
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.save(orders));
			responseEntity = new ResponseEntity<ResponseStructure<Orders>>(structuer, HttpStatus.OK);
			return responseEntity;
		} else {
			structuer.setStatus(HttpStatus.NOT_FOUND.value());
			structuer.setMessage("successfull");
			structuer.setData(null);
			responseEntity = new ResponseEntity<ResponseStructure<Orders>>(structuer, HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Orders>>> getAll() {
		ResponseStructure<List<Orders>> structuer = new ResponseStructure<List<Orders>>();
		structuer.setStatus(HttpStatus.OK.value());
		structuer.setMessage("successfull");
		structuer.setData(dao.getAll());
		ResponseEntity<ResponseStructure<List<Orders>>> responseEntity = new ResponseEntity<ResponseStructure<List<Orders>>>(
				structuer, HttpStatus.OK);
		return responseEntity;

	}

	@Override
	public ResponseEntity<ResponseStructure<Orders>> update(String uid,int orderId, Orders orders) {
		
		
		Owner owner = ownerDao.getOwnerById(uid);
		Staff staff = null;
		ResponseStructure<Orders> structuer = new ResponseStructure<Orders>();
		if (owner == null) {
			staff = staffDao.getStaffById(uid);

		}

//		if ((owner != null || staff != null)) {
//			orders.setOwner2(owner);
//			orders.setStaff1(staff);
//			structuer.setStatus(HttpStatus.OK.value());
//			structuer.setMessage("successfull");
//			structuer.setData(dao.update(orderId, orders));
//			responseEntity = new ResponseEntity<ResponseStructure<Orders>>(structuer, HttpStatus.OK);
//			return responseEntity;
//		} else {
//			structuer.setStatus(HttpStatus.NOT_FOUND.value());
//			structuer.setMessage("successfull");
//			structuer.setData(null);
//			responseEntity = new ResponseEntity<ResponseStructure<Orders>>(structuer, HttpStatus.NOT_FOUND);
//			return responseEntity;
//		}
		System.out.println(owner);
		System.out.println(staff);
		ResponseEntity<ResponseStructure<Orders>> entity = null;
		Orders existing = dao.update(orderId, orders);
		if (existing != null) {
			orders.setStaff1(staff);
			orders.setOwner2(owner);
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.update(orderId, orders));
			entity = new ResponseEntity<ResponseStructure<Orders>>(structuer, HttpStatus.OK);
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> delete(int orderId) {
		ResponseStructure<String> structuer = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> entity;
		if (dao.delete(orderId)) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData("Order deleted");
			entity = new ResponseEntity<ResponseStructure<String>>(structuer, HttpStatus.OK);
		} else {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("ID :" + orderId + " NOTFOUND");
			structuer.setData("User not deleted");
			entity = new ResponseEntity<ResponseStructure<String>>(structuer, HttpStatus.NOT_FOUND);
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Orders>> getByOrderId(int orderId) {
		ResponseStructure<Orders> structuer = new ResponseStructure<Orders>();
		ResponseEntity<ResponseStructure<Orders>> responseEntity;
		Orders orders = dao.getByOrderId(orderId);
		if (orders != null) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.getByOrderId(orderId));
			responseEntity = new ResponseEntity<ResponseStructure<Orders>>(structuer, HttpStatus.OK);

		} else {
			structuer.setStatus(HttpStatus.NOT_FOUND.value());
			structuer.setMessage("Order id :" + orderId + " NOTFOUND");
			structuer.setData(null);
			responseEntity = new ResponseEntity<ResponseStructure<Orders>>(structuer, HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

}
