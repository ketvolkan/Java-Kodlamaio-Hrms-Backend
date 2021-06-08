package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Job;

public interface JobService {
		DataResult<List<Job>> getAll();
		Result add(Job job);
		Result delete(int id);
}
