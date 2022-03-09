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
			owner = staff.getOwner();
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
	public ResponseEntity<ResponseStructure<Orders>> update(String uid, int orderId, Orders orders) {
		ResponseEntity<ResponseStructure<Orders>> entity = null;
		Staff staff = null;
		Orders orders2 = dao.getByOrderId(orderId);
		Owner owner = ownerDao.getOwnerById(uid);
		if (orders2 != null && owner != null && owner.getId().equals(orders2.getOwner2().getId())) {
			orders.setOwner2(owner);
			orders.setStaff1(staff);
			ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(dao.update(orderId, orders));
			entity = new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.OK);
		} else if (owner == null) {
			staff = staffDao.getStaffById(uid);
			System.out.println(orders2);
			if (orders2 != null && staff.getOwner().getId().equals(orders2.getOwner2().getId())) {
				orders.setStaff1(staff);
				owner = staff.getOwner();
				orders.setOwner2(owner);
				ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("success");
				responseStructure.setData(dao.update(orderId, orders));
				entity = new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.OK);
			} else {
				ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();
				responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
				responseStructure.setMessage("not found");
				responseStructure.setData(null);
				entity = new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.NOT_FOUND);

			}
		} else {
			ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("not found");
			responseStructure.setData(null);
			entity = new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.NOT_FOUND);

		}
		return entity;

//		ResponseEntity<ResponseStructure<Orders>> entity = null;
//		ResponseStructure<Orders> structuer = new ResponseStructure<Orders>();
//		Orders order = dao.getByOrderId(orderId);
//		Owner owner = order.getOwner2();
//		Staff staff = order.getStaff1();
//		List<Staff> staffs = owner.getList();
//		for (Staff staff2 : staffs) {
//			if (staff2.getId().equals(uid)) {
//				System.out.println("-----------------");
//				System.out.println(staff2);
//				// if (uid.equals(staff.getId()) || uid.equals(owner.getId()) && order != null)
//				// {
//				orders.setOwner2(owner);
//				orders.setStaff1(staff);
//				structuer.setStatus(HttpStatus.OK.value());
//				structuer.setMessage("successfull");
//				structuer.setData(dao.update(orderId, orders));
//				entity = new ResponseEntity<ResponseStructure<Orders>>(structuer, HttpStatus.OK);
//				return entity;
//
//			} else {
//				structuer.setStatus(HttpStatus.NOT_FOUND.value());
//				structuer.setMessage("Order id :" + uid + " NOTFOUND");
//				structuer.setData(null);
//				entity = new ResponseEntity<ResponseStructure<Orders>>(structuer, HttpStatus.NOT_FOUND);
//				return entity;
//			}
//		}
//		return entity;

	}

	@Override
	public ResponseEntity<ResponseStructure<String>> delete(int orderId,String oid) {
		ResponseStructure<String> structuer = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> entity;
		Orders orders=dao.getByOrderId(orderId);
		if (dao.delete(orderId)&&orders.getOwner2().getId().equals(oid)) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData("Order deleted");
			entity = new ResponseEntity<ResponseStructure<String>>(structuer, HttpStatus.OK);
		} else {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("ID :" + orderId + " NOTFOUND");
			structuer.setData(oid+" not an authorized person to delete");
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
