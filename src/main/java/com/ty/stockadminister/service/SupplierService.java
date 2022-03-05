package com.ty.stockadminister.service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.ty.stockadminister.dto.SupplierDto;
import com.ty.stockadminister.util.ResponseStructure;

public interface SupplierService {
	public ResponseEntity<ResponseStructure<SupplierDto>> save(SupplierDto dto,String id);
	public ResponseEntity<ResponseStructure<SupplierDto>>  getbyid(int id);
	public ResponseEntity<ResponseStructure<List<SupplierDto>>>  getall();
	public ResponseEntity<ResponseStructure<SupplierDto>> update(int id,String userid,SupplierDto supplierDto);
	public ResponseEntity<ResponseStructure<String>> delete(int id);

}
