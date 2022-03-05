package com.ty.stockadminister.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ty.stockadminister.controller.SupplierController;
import com.ty.stockadminister.dao.SupplierDao;
import com.ty.stockadminister.dto.Staff;
import com.ty.stockadminister.dto.SupplierDto;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierTesting {
	@Autowired
	SupplierController controller;
	@MockBean
	SupplierDao dao;
	Staff staff = new Staff("1","abhi","abhi@gmail.com","abhi",357132l);
	SupplierDto dto=new SupplierDto(1, "kumar", "alone", 23, "serty", null, null);
	@org.junit.Test
	public void saveSupplier() {
		when(dao.save(dto)).thenReturn(dto);
		assertEquals(dto, controller.save(dto, "1").getBody().getData());
	}
	@Test
	public void updateSupplier() {
		when(dao.update(1, dto)).thenReturn(dto);
		assertEquals(dto, controller.update(1, "Adm_00001", dto).getBody().getData());
	}
	@Test
	public void deleteSupplier() {
		Boolean t=true;
		String resp="deleted";
		when(dao.delete(1)).thenReturn(t);
		assertEquals(resp, controller.delete(1).getBody().getData());
	}
	@Test
	public void getById() {
		when(dao.getbyid(1)).thenReturn(dto);
		assertEquals(dto, controller.getbyid(1).getBody().getData());
	}
	public void getAll() {
		List<SupplierDto> list= new ArrayList();
		list.add(dto);
		when(dao.getall()).thenReturn(list);
		assertEquals(1, controller.getall().getBody().getData());  
	}
	

}
