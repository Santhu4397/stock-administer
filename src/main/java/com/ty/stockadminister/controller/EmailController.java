package com.ty.stockadminister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.stockadminister.dto.Email;
import com.ty.stockadminister.service.impl.EmailSenderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmailController {
	@Autowired
	EmailSenderService emailSenderService;
	
		@PostMapping("/email")
		@ApiOperation("To send email")
		@ApiResponses({ @ApiResponse(code = 200, message = "Email Sent"),
				@ApiResponse(code = 404, message = "Class not found"),
				@ApiResponse(code = 500, message = "Internal Server error") })
		public void sendEmail(@RequestBody Email email) {
			String toEmail = email.getToEmail();
			String body = "";
			String subject = email.getSubject();
			emailSenderService.sendEmail(toEmail, body, subject);
		}
}
