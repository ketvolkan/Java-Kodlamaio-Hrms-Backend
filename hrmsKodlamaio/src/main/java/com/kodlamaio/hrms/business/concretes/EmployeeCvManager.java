package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.EmployeeCvService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployeeCvDao;
import com.kodlamaio.hrms.entities.concretes.Cv;
@Service
public class EmployeeCvManager implements EmployeeCvService {
	@Autowired
	private EmployeeCvDao employeeCvDao;
	@Override
	public Result add(Cv cv) {
		this.employeeCvDao.save(cv);
		return new SuccessResult("Ekleme Başarılı");
	}

	@Override
	public DataResult<List<Cv>> getByEmployeeId(int id) {
		return new SuccessDataResult<List<Cv>>(this.employeeCvDao.getByEmployeeId(id),"Cv Listelendi");
	}
}
