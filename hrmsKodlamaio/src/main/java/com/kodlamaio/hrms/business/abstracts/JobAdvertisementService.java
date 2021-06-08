package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getAll(int pageno,int pagesize);
	DataResult<List<JobAdvertisement>> getByEmployerId(int employerId);
	DataResult<List<JobAdvertisement>> getByActive(boolean activity);
	DataResult<List<JobAdvertisement>> getByActive(boolean activity,Sort sort);
	Result setPasive(int id);
}
