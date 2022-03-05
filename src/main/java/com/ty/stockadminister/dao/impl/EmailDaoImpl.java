package com.ty.stockadminister.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.stockadminister.dao.EmailDao;
import com.ty.stockadminister.dto.Email;
import com.ty.stockadminister.repositroy.EmailRepository;
@Repository
public class EmailDaoImpl implements EmailDao {
	@Autowired
	EmailRepository repository;

	@Override
	public Email saveEmail(Email email) {
		return repository.save(email);

	}

	@Override
	public List<Email> getAllEmail() {
		return repository.findAll();
	}

	@Override
	public Email getEmailById(int id) {

//	Optional< Email> optional=repository.findById(id);
//	if(optional!=null) {
//		return optional.get();
//	}else {
//		return null;
//	}
		return repository.getById(id);
	}

	@Override
	public Email updateEmail(int id, Email email) {
		Email exsiting=getEmailById(id);
		if(exsiting != null) {
			email.setBody(exsiting.getBody());
			email.setSubject(exsiting.getSubject());
			email.setToEmail(exsiting.getToEmail());
			return repository.save(email);
		}
		return null;
	}

	@Override
	public boolean deleteEmail(int id) {
		Email email=getEmailById(id);
		if(email!=null) {
			repository.delete(email);
			return true;
		}
		return false;
	}

}
