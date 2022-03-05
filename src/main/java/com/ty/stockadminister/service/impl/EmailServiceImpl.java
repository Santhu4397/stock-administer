package com.ty.stockadminister.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.stockadminister.dao.StockDao;
import com.ty.stockadminister.dto.Email;
import com.ty.stockadminister.dto.Stock;

@Service
public class EmailServiceImpl {

	@Autowired
	StockDao stockDao;
	@Autowired
	EmailSenderService emailSenderService;

	public String saveEmail( int id) {
		Stock stock = stockDao.getStockById(id);
		Email email = new Email();
		if (stock != null) {
			email.setStock(stock);
			email.setToEmail(stock.getSupplier().getMailId());
			email.setBody("Greetings for the day Mr/Ms: "+" "+stock.getSupplier().getName()+" "+"From: "+stock.getOwner1().getName()+" our stock got diminished,we are in need of this product *** "+
			
			stock.getProduct_Name()+"*** "+"of quantity  "+" ***"+stock.getReorder_Quantity()+"*** "+"to be delivered as soon as possible  "
					);
			email.setSubject("*****"+stock.getOwner1().getComapnyName()+"**** "+"Regarding the order of stock ");
			emailSenderService.sendEmail(email.getToEmail(),email.getBody(), email.getSubject());
			return "email send to email : "+stock.getSupplier().getMailId()+"name : "+stock.getSupplier().getName();
		}return "email not send";

	}



}
