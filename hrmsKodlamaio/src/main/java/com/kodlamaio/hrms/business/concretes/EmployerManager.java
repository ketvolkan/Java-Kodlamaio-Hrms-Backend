package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.EmployerCheckService;
import com.kodlamaio.hrms.business.abstracts.EmployerService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
private EmployerDao employerDao;
private EmployerCheckService employerCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmployerCheckService employerCheckService) {
		super();
		this.employerDao = employerDao;
		this.employerCheckService = employerCheckService;
	}
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employer'lar Listelendi");
	}
	@Override
	public Result add(Employer employer) {
		if(employerCheckService.allMatch(employer)!="")
		{
			return new ErrorResult(employerCheckService.allMatch(employer));
		}else {
			this.employerDao.save(employer);
			return new SuccessResult(employer.getCompany_name()+" Eklendi");
		}
		
	}
	@Override
	public Result delete(int id) {
		this.employerDao.deleteById(id);
		return new SuccessResult("ID:"+id+" Başarıyla Silindi");
	}
	@Override
	public DataResult<List<Employer>> findById(int id) {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findById(id),"Employer'lar Listelendi");
	}
}
