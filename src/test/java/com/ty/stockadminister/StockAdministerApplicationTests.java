package com.ty.stockadminister;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ty.stockadminister.controller.StaffController;
import com.ty.stockadminister.dao.StaffDao;

import com.ty.stockadminister.dto.Staff;


@SpringBootTest
class StockAdministerApplicationTests {

	@Autowired
	private StaffController controller;
	@MockBean
	private StaffDao dao;

	Staff staff3 = new Staff("1", "deepak", "deepak@gamil.com", "1234", 15697465l);
	Staff staff1 = new Staff("1", "deepak", "deepak@gamil.com", "1234", 15697465l);
	Staff staff2 = new Staff("1", "deepak", "deepak@gamil.com", "1234", 15697465l);

	@Test
	public void getowner() {
		List<Staff> staff = new ArrayList<Staff>();
		staff.add(staff3);
		staff.add(staff1);
		staff.add(staff2);
		when(dao.getAllStaff()).thenReturn(staff);
		assertEquals(0, controller.getAllStaff().getBody().getData().size());

	}

}
