package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.kodlamaio.hrms.entities.concretes.JobAdvertisement;
@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Ekleme Başarılı");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"İş İlanları Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployerId(employerId),"Müşteri ID si : "+employerId+"olan İş İlanları Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActive(boolean activity) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActive(activity),"Activity : "+activity+"olan İş İlanları Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActive(boolean activity, Sort sort) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActive(activity,sort),"Activity : "+activity+" olan İş İlanları Listelendi");
	}

	@Override
	public Result setPasive(int id) {
		this.jobAdvertisementDao.setPasive(id);
		return new SuccessResult("İlan Pasif Hale Getirildi");
	}

	
	@Override
	public DataResult<List<JobAdvertisement>> getAll(int pageno, int pagesize) {
		Pageable page = PageRequest.of(pageno, pagesize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(page).getContent(),"Page:"+pageno+":"+pagesize+"İş İlanları Listelendi");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertisementDao.deleteById(id);
		return new SuccessResult("ID:"+id+" Başarıyla Silindi");
	}

	@Override
	public Result setActive(int id) {
		this.jobAdvertisementDao.setActive(id);
		return new SuccessResult("İlan Pasif Hale Getirildi");
	}


}
