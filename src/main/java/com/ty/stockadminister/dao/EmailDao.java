package com.ty.stockadminister.dao;

import java.util.List;

import com.ty.stockadminister.dto.Email;



public interface EmailDao {
	
	public Email saveEmail(Email email);

	public List<Email> getAllEmail();

	public Email getEmailById(int id);

	public Email updateEmail(int id, Email email);

	public boolean deleteEmail(int id);

	


}
