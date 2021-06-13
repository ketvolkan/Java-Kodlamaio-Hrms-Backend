package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.CityService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/city")
@CrossOrigin
public class CitysController {
	@Autowired
	private CityService cityService;
	@GetMapping("/getallCity")
	public DataResult<List<City>> getAllCv()
	{
		 return this.cityService.getAll();
	}
}
