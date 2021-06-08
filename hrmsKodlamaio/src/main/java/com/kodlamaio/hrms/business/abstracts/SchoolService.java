package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.School;

public interface SchoolService {

	Result add(School school);
	DataResult<List<School>> getByEmployeeId(int id);
}
