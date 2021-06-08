package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Language;

public interface LanguageService {
	Result add(Language language);
	DataResult<List<Language>> getByEmployeeId(int id);
}
