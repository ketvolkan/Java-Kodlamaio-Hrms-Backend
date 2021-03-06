package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobDao;
import com.kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}
	@Override
	public DataResult<List<Job>> getAll() {
		
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(),"Job_Title'ler Listelendi");
	}
	@Override
	public Result add(Job job) {
		if(this.jobDao.findByTitle(job.getTitle()) != null)
		{
			return new ErrorResult(job.getTitle()+" Job_Title'ye Eklenemedi Aynı İsimle Ekleyemezsiniz!");
		}
		else {
			this.jobDao.save(job);
			return new SuccessResult(job.getTitle()+" Veri Job_Title'ye Eklendi");
		}
		
	}
	@Override
	public Result delete(int id) {
		this.jobDao.deleteById(id);
		return new SuccessResult("ID:"+id+" Başarıyla Silindi");
	}

}
