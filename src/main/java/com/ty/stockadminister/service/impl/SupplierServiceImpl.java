package com.ty.stockadminister.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ty.stockadminister.dao.SupplierDao;
import com.ty.stockadminister.dao.impl.SupplierDaoImpl;
import com.ty.stockadminister.dto.SupplierDto;
import com.ty.stockadminister.service.SupplierService;
import com.ty.stockadminister.util.ResponseStructure;

@Service
public class SupplierServiceImpl implements SupplierService  {
	@Autowired
	SupplierDao dao;
	@Override
	public ResponseEntity<ResponseStructure<SupplierDto>> save(SupplierDto dto) {
		// TODO Auto-generated method stub
		ResponseStructure<SupplierDto> responseStructure=new ResponseStructure<SupplierDto>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfull");
		responseStructure.setData(dao.save(dto));
		ResponseEntity<ResponseStructure<SupplierDto>> responseEntity=new ResponseEntity<ResponseStructure<SupplierDto>>(responseStructure,HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<SupplierDto>> getbyid(int id) {
		// TODO Auto-generated method stub
		ResponseStructure<SupplierDto> responseStructure=new ResponseStructure<SupplierDto>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfull");
		responseStructure.setData(dao.getbyid(id));
		ResponseEntity<ResponseStructure<SupplierDto>> responseEntity=new ResponseEntity<ResponseStructure<SupplierDto>>(responseStructure,HttpStatus.OK);

		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<SupplierDto>>> getall() {
		// TODO Auto-generated method stub
		ResponseStructure<List<SupplierDto>> responseStructure=new ResponseStructure<List<SupplierDto>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfull");
		responseStructure.setData(dao.getall());
		ResponseEntity<ResponseStructure<List<SupplierDto>>> responseEntity=new ResponseEntity<ResponseStructure<List<SupplierDto>>>(responseStructure,HttpStatus.OK);
		
		
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<SupplierDto>> update(int id, SupplierDto supplierDto) {
		// TODO Auto-generated method stub
		ResponseStructure<SupplierDto> responseStructure=new ResponseStructure<SupplierDto>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfull");
		responseStructure.setData(dao.update(id, supplierDto));
		ResponseEntity<ResponseStructure<SupplierDto>> responseEntity=new ResponseEntity<ResponseStructure<SupplierDto>>(responseStructure,HttpStatus.OK);
	
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> delete(int id) {
		// TODO Auto-generated method stub
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfull");
		responseStructure.setData(" ");
		ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
	
		dao.delete(id);
		return null;
	}

}
