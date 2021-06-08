package com.kodlamaio.hrms.core.adapter.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.core.adapter.abstracts.EmployerConfirimationService;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployerDao;

@Service
public class EmployerConfirimationManager implements EmployerConfirimationService {
	@Autowired
	private EmployerDao employerDao;

	@Override
	public Result approveEmployer(int employerid) {
		this.employerDao.setConfirimation(employerid);
		return new SuccessResult("İş Veren Onaylandı");
	}
	
}
