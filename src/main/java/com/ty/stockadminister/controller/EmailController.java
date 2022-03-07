package com.ty.stockadminister.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.stockadminister.service.impl.EmailServiceImpl;

@RestController
public class EmailController {

	@Autowired
	EmailServiceImpl emailServiceImpl;

	@GetMapping("email/stockid")
	public String saveemail(@RequestParam int id) {
		return emailServiceImpl.saveEmail(id);

	}
}
