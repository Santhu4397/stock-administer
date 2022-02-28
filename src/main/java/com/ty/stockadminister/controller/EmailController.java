package com.ty.stockadminister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.stockadminister.dto.Email;
import com.ty.stockadminister.email.EmailSenderService;

@RestController
public class EmailController {
	@Autowired
	EmailSenderService emailSenderService;
	
		@PostMapping("/email")
		public void sendEmail(@RequestBody Email email) {
			String toEmail = email.getToEmail();
			String body = email.getBody();
			String subject = email.getSubject();
			emailSenderService.sendEmail(toEmail, body, subject);
		}
}
