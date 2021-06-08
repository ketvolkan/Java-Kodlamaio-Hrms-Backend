package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.LanguageService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import com.kodlamaio.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	@Autowired
	private LanguageDao languageDao;
	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Ekleme Başarılı");
	}

	@Override
	public DataResult<List<Language>> getByEmployeeId(int id) {
		return new SuccessDataResult<List<Language>>(this.languageDao.getByEmployeeId(id),"Bilinen Diller Listelendi");
	}
}
