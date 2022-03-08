package com.ty.stockadminister.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.ty.stockadminister.util.ResponseStructure;
import com.ty.stockadminister.dao.OwnerDao;
import com.ty.stockadminister.dao.SalesDao;
import com.ty.stockadminister.dao.StaffDao;
import com.ty.stockadminister.dao.StockDao;
import com.ty.stockadminister.dto.Owner;
import com.ty.stockadminister.dto.Sales;
import com.ty.stockadminister.dto.Staff;
import com.ty.stockadminister.dto.Stock;
import com.ty.stockadminister.dto.SupplierDto;
import com.ty.stockadminister.service.SalesService;

@Component
@Service
public class SalesServiceImpl implements SalesService {
	@Autowired
	SalesDao dao;
	@Autowired
	StockDao dao2;
	@Autowired
	StaffDao staffDao;
	@Autowired
	OwnerDao ownerDao;

	@Override
	public ResponseEntity<ResponseStructure<Sales>> save(Sales sales, int stockid, String staffid) {
		Staff staff = staffDao.getStaffById(staffid);

		ResponseStructure<Sales> structuer = new ResponseStructure<Sales>();
		Stock stock = dao2.getStockById(stockid);
		sales.setStock(stock);
		sales.setDate_and_time(LocalDateTime.now());
		if (stock != null && stock.getQuantity() > sales.getQty()) {

			int new_qnt = stock.getQuantity() - sales.getQty();
			stock.setQuantity(new_qnt);
			dao2.updateStock(stockid, stock);

			sales.setStaff(staff);
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.save(sales));
			ResponseEntity<ResponseStructure<Sales>> responseEntity = new ResponseEntity<ResponseStructure<Sales>>(
					structuer, HttpStatus.OK);
			return responseEntity;
		} else {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("ID not found");
			structuer.setData(null);
			ResponseEntity<ResponseStructure<Sales>> responseEntity = new ResponseEntity<ResponseStructure<Sales>>(
					structuer, HttpStatus.NOT_FOUND);
			return responseEntity;
		}

	}

	@Override
	public ResponseEntity<ResponseStructure<Sales>> getByName(String name) {
		ResponseStructure<Sales> structuer = new ResponseStructure<Sales>();
		ResponseEntity<ResponseStructure<Sales>> responseEntity;
		Sales sales = dao.getByName(name);
		if (sales != null) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.getByName(name));
			responseEntity = new ResponseEntity<ResponseStructure<Sales>>(structuer, HttpStatus.OK);

		} else {
			structuer.setStatus(HttpStatus.NOT_FOUND.value());
			structuer.setMessage("Name :" + name + " NOTFOUND");
			structuer.setData(null);
			responseEntity = new ResponseEntity<ResponseStructure<Sales>>(structuer, HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Sales>>> getAll() {
		ResponseStructure<List<Sales>> structuer = new ResponseStructure<List<Sales>>();
		structuer.setStatus(HttpStatus.OK.value());
		structuer.setMessage("successfull");
		structuer.setData(dao.getAll());
		ResponseEntity<ResponseStructure<List<Sales>>> responseEntity = new ResponseEntity<ResponseStructure<List<Sales>>>(
				structuer, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> delete( int id) {
		ResponseStructure<String> structuer = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> entity = null;
		Sales sales = dao.getById(id);
			if (dao.delete(id)) {
				structuer.setStatus(HttpStatus.OK.value());
				structuer.setMessage("successfull");
				structuer.setData("User deleted");
				entity = new ResponseEntity<ResponseStructure<String>>(structuer, HttpStatus.OK);
			}
		 else {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("ID :" + id + " NOTFOUND");
			structuer.setData("User not deleted");
			entity = new ResponseEntity<ResponseStructure<String>>(structuer, HttpStatus.NOT_FOUND);
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Sales>> update(int id, String staffid, Sales sales) {
		Staff staff = staffDao.getStaffById(staffid);

		ResponseStructure<Sales> structuer = new ResponseStructure<Sales>();
		ResponseEntity<ResponseStructure<Sales>> entity = null;
		Sales existing = dao.update(id, sales);
		if (existing != null) {
			sales.setStaff(staff);
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.update(id, sales));
			entity = new ResponseEntity<ResponseStructure<Sales>>(structuer, HttpStatus.OK);
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Sales>> getById(int id) {
		ResponseStructure<Sales> structuer = new ResponseStructure<Sales>();
		ResponseEntity<ResponseStructure<Sales>> responseEntity;
		Sales sales = dao.getById(id);
		if (sales != null) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.getById(id));
			responseEntity = new ResponseEntity<ResponseStructure<Sales>>(structuer, HttpStatus.OK);

		} else {
			structuer.setStatus(HttpStatus.NOT_FOUND.value());
			structuer.setMessage("Name :" + id + " NOTFOUND");
			structuer.setData(null);
			responseEntity = new ResponseEntity<ResponseStructure<Sales>>(structuer, HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

}
