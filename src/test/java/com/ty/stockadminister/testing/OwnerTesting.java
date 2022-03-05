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

import com.ty.stockadminister.controller.OwnerController;
import com.ty.stockadminister.dao.OwnerDao;
import com.ty.stockadminister.dao.StaffDao;
import com.ty.stockadminister.dto.LoginDto;
import com.ty.stockadminister.dto.Owner;
import com.ty.stockadminister.dto.Sales;
import com.ty.stockadminister.dto.Staff;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OwnerTesting {
	@Autowired
	private OwnerController controller;
	@MockBean
	private OwnerDao dao;
	@MockBean
	private StaffDao dao2;
	
	Staff staff = new Staff("Adm_000011","abhi","abhi@gamil.com","abhi",1234567890l);
	Owner owner = new Owner("1","abhi","abhi@gmail.com","abhi",42516314l,"Tyss","devp","blr",null,null,null);
	Owner owner1 = new Owner("2","abhi","abhi@gmail.com","abhi",42516314l,"Tyss","devp","blr",null,null,null);
	Owner owner2 = new Owner("3","abhi","abhi@gmail.com","abhi",42516314l,"Tyss","devp","blr",null,null,null);

	@Test
	public void loginOwner() {
		LoginDto dto = new LoginDto();
		dto.setEmail("Santhosh@143");
		dto.setPassword("143");
		when(dao.loginOwner("Santhosh@143", "143")).thenReturn(owner);
		assertEquals(owner, controller.loginOwner(dto).getBody().getData());
	}

	@Test
	public void saveOwner() {
		when(dao.saveOwner(owner)).thenReturn(owner);
		assertEquals(owner, controller.saveOwner(owner).getBody().getData());
	}

	@Test
	public void getOwnerByIdTest() {
		when(dao.getOwnerById("1")).thenReturn(owner);
		assertEquals(owner, controller.getOwnerById("1").getBody().getData());
	}

	@Test
	public void getAllOwner() {
		List<Owner> listOwner = new ArrayList<Owner>();
		listOwner.add(owner);
		listOwner.add(owner1);
		listOwner.add(owner2);
		when(dao.getAllOwner()).thenReturn(listOwner);
		assertEquals(3, controller.getAll().getBody().getData().size());	
	}
	
	@Test
	public void updateOwner() {

		when(dao.updateOwner("1", owner)).thenReturn(owner);
		assertEquals(owner, controller.updateOwener("1", owner).getBody().getData());
	}
	
	@Test
	public void deleteSalesTest() {

		boolean bt = true;
		String respon = "Owner deleted";
		when(dao.deleteOwner("1")).thenReturn(bt);
		assertEquals(respon, controller.deleteOwner("1").getBody().getData());

	}
	
	@Test 
	public void updateStaffTest() {
		when(dao2.updateStaff("Adm_00001", staff)).thenReturn(staff);
		assertEquals(staff, controller.updateStaff("Adm_00001", staff).getBody().getData());
	}

}
