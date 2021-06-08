package com.kodlamaio.hrms.core.adapter.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.core.adapter.abstracts.EmailService;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.UserDao;

@Service
public class EmailVerification implements EmailService{
	@Autowired
	private UserDao userDao;
	
	public Result approveMail(int id) {
		this.userDao.setVerification(id);
		return new SuccessResult("Email Doğrulandı");
	}
}
