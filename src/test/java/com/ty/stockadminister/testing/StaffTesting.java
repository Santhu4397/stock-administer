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

import com.ty.stockadminister.controller.StaffController;
import com.ty.stockadminister.dao.StaffDao;
import com.ty.stockadminister.dto.LoginDto;
import com.ty.stockadminister.dto.Staff;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffTesting {
	@Autowired
	private StaffController controller;
	@MockBean
	private StaffDao dao;

	Staff staff = new Staff("1", "deepak", "deepak@gamil.com", "1234", 15697465l);
	Staff staff1 = new Staff("2", "sagara", "deepak@gamil.com", "1234", 15697465l);
	Staff staff2 = new Staff("3", "abi", "deepak@gamil.com", "1234", 15697465l);

	@Test
	public void getstaff() {
		List<Staff> liststaff = new ArrayList<Staff>();
		liststaff.add(staff);
		liststaff.add(staff1);
		liststaff.add(staff2);
		when(dao.getAllStaff()).thenReturn(liststaff);
		assertEquals(3, controller.getAllStaff().getBody().getData().size());

	}

	@org.junit.Test
	public void savestaff() {
		when(dao.saveStaff(staff1)).thenReturn(staff1);
		assertEquals(staff1, controller.saveStaff(staff1, "2").getBody().getData());

	}

	@Test
	public void getstaffByIdTest() {

		when(dao.getStaffById("1")).thenReturn(staff);
		assertEquals(staff, controller.getStaffById("1").getBody().getData());

	}

	@Test
	public void getByStaffName() {
		when(dao.getStaffByName("deepak")).thenReturn(staff);
		assertEquals(staff, controller.getStaffByName("deepak").getBody().getData());
	}

	@Test
	public void login() {
		LoginDto dto = new LoginDto();
		dto.setEmail("deepak@gamil.com");
		dto.setPassword("1234");
		when(dao.loginStaff("deepak@gamil.com", "1234")).thenReturn(staff);
		assertEquals(staff, controller.loginStaff(dto).getBody().getData());
	}
}
