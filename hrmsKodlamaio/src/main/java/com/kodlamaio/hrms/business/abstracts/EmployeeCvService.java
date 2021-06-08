package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Cv;

public interface EmployeeCvService {
	Result add(Cv cv);
	DataResult<List<Cv>> getByEmployeeId(int id);
}
