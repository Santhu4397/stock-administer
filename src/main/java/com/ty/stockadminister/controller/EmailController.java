package com.ty.stockadminister.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.stockadminister.service.impl.EmailServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmailController {

	@Autowired
	EmailServiceImpl emailServiceImpl;

	@GetMapping("email/stockid")
	@ApiOperation("To send email")
	@ApiResponses({ @ApiResponse(code = 200, message = "Email Sent"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public String saveemail(@RequestParam int id) {
		return emailServiceImpl.saveEmail(id);

	}

}
