package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ProgrameLanguage;

public interface ProgrameLanguageService {
	Result add(ProgrameLanguage programeLanguage);
	DataResult<List<ProgrameLanguage>> getByEmployeeId(int id);
}
