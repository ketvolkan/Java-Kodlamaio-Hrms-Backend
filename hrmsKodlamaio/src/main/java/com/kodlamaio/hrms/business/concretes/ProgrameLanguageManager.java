package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.ProgrameLanguageService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.ProgrameLanguageDao;
import com.kodlamaio.hrms.entities.concretes.ProgrameLanguage;
@Service
public class ProgrameLanguageManager  implements ProgrameLanguageService{

	@Autowired
	private ProgrameLanguageDao programeLanguageDao;
	@Override
	public Result add(ProgrameLanguage programeLanguage) {
		this.programeLanguageDao.save(programeLanguage);
		return new SuccessResult("Ekleme Başarılı");
	}

	@Override
	public DataResult<List<ProgrameLanguage>> getByEmployeeId(int id) {
		
		return new SuccessDataResult<List<ProgrameLanguage>>(this.programeLanguageDao.getByEmployeeId(id),"Programlama Dilleri Listelendi");
	}

}
