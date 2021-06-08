package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.EmployerService;
import com.kodlamaio.hrms.core.adapter.abstracts.EmployerConfirimationService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
	private EmployerService employerService;
	
	private EmployerConfirimationService employerConfirimationService;
	
	@Autowired
	public EmployersController(EmployerService employerService,EmployerConfirimationService employerConfirimationService) {
		super();
		this.employerService = employerService;

		this.employerConfirimationService =employerConfirimationService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll()
	{
		 return this.employerService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}

	@PostMapping("/approveConfirimation")
	public Result approveEmployer(int id) {
		return this.employerConfirimationService.approveEmployer(id);
	}
	@DeleteMapping("/delete")
	public Result delete(int id) {
		return this.employerService.delete(id);
		
	}
}
