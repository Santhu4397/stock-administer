package com.ty.stockadminister.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ty.stockadminister.controller.OwnerController;
import com.ty.stockadminister.dao.OwnerDao;
import com.ty.stockadminister.dto.LoginDto;
import com.ty.stockadminister.dto.Owner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OwnerTesting {
     @Autowired
	private OwnerController controller;
     @MockBean
    private OwnerDao dao;
     Owner owner=new Owner(1, "Santhosh", "Santhosh@143", "143", 98143l,"Shakila Motors","Manufacturing","jubli hills hyd", null, null, null);
     @Test
     public void loginOwner() {
    	 LoginDto dto=new LoginDto();
 		dto.setEmail("Santhosh@143");
 		dto.setPassword("143");
 		when(dao.loginOwner("Santhosh@143", "143")    ).thenReturn(owner);
 		assertEquals(owner, controller.loginOwner(dto).getBody().getData());
     }
     @Test
     public void saveOwner() {
    	 when(dao.saveOwner(owner)).thenReturn(owner);
    	 assertEquals(owner, controller.saveOwner(owner).getBody().getData());
     }
}
