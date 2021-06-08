package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.SchoolService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import com.kodlamaio.hrms.entities.concretes.School;
@Service
public class SchoolManager implements SchoolService {

	@Autowired
	private SchoolDao schooldao;
	@Override
	public Result add(School school) {
		this.schooldao.save(school);
		return new SuccessResult("Ekleme Başarılı");
	}

	@Override
	public DataResult<List<School>> getByEmployeeId(int id) {
		
		return new SuccessDataResult<List<School>>(this.schooldao.getByEmployeeId(id),"Okunan Okullar Listelendi");
	}

}
