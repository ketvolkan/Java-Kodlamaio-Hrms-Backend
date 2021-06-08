package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobExperienceService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import com.kodlamaio.hrms.entities.concretes.JobExperience;
@Service
public class JobExperienceManager implements JobExperienceService {
	@Autowired
	private JobExperienceDao jobExperienceDao;
	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Ekleme Başarılı");
	}

	@Override
	public DataResult<List<JobExperience>> getByEmployeeId(int id) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getByEmployeeId(id),"İş Deneyimleri Listelendi");
	}
}
