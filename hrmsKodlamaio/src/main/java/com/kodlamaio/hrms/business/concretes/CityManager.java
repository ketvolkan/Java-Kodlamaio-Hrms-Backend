package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.CityService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CityDao;
import com.kodlamaio.hrms.entities.concretes.City;
@Service
public class CityManager implements CityService {
	@Autowired
	private CityDao citydao;
	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.citydao.findAll(),"Tüm Şehirler Listelendi");
	}

}
