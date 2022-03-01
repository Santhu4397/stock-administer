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
import com.ty.stockadminister.dto.Staff;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffTesting {
	@Autowired
	private StaffController controller;
	@MockBean
	private StaffDao dao;

	Staff staff3 = new Staff(1, "deepak", "deepak@gamil.com", "1234", 15697465l);
	Staff staff1 = new Staff(2, "deepak", "deepak@gamil.com", "1234", 15697465l);
	Staff staff2 = new Staff(3, "deepak", "deepak@gamil.com", "1234", 15697465l);

	@Test
	public void getowner() {
		List<Staff> liststaff = new ArrayList<Staff>();
		liststaff.add(staff3);
		liststaff.add(staff1);
		liststaff.add(staff2);
		when(dao.getAllStaff()).thenReturn(liststaff);
		assertEquals(3, controller.getAllStaff().getBody().getData().size());

	}

	@Test
	public void saveowner() {
		when(dao.saveStaff(staff1)).thenReturn(staff1);
		assertEquals(staff1, controller.saveStaff(staff1).getBody().getData());

	}


	@Test
	public void getownerByIdTest() {

		when(dao.getStaffByName("deepak")).thenReturn(staff1);
		assertEquals(staff1, controller.getStaffByName("deepak").getBody().getData());

	}

	@Test
	public void updateowner() {

		when(dao.updateStaff(1, staff2)).thenReturn(staff2);
		assertEquals(staff2, controller.updateStaff(1, staff2).getBody().getData());
	}

	@org.junit.jupiter.api.Test
	public void deleteownerTest() {

		boolean bt = true;
		String respon = "Staff deleted";
		when(dao.deleteStaff(1)).thenReturn(bt);
		assertEquals(respon, controller.deleteStaff(1).getBody().getData());

	}

}
