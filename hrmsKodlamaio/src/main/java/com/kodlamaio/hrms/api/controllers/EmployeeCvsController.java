package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.EmployeeCvService;
import com.kodlamaio.hrms.business.abstracts.JobExperienceService;
import com.kodlamaio.hrms.business.abstracts.LanguageService;
import com.kodlamaio.hrms.business.abstracts.ProgrameLanguageService;
import com.kodlamaio.hrms.business.abstracts.SchoolService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Cv;
import com.kodlamaio.hrms.entities.concretes.JobExperience;
import com.kodlamaio.hrms.entities.concretes.Language;
import com.kodlamaio.hrms.entities.concretes.ProgrameLanguage;
import com.kodlamaio.hrms.entities.concretes.School;


@RestController
@RequestMapping("/api/cv")
@CrossOrigin
public class EmployeeCvsController {

	private EmployeeCvService cv;
	private LanguageService language;
	private ProgrameLanguageService programeLanguage;
	private SchoolService school;
	private JobExperienceService jobExperience;
	
	@Autowired
	public EmployeeCvsController(EmployeeCvService cv, LanguageService language,
			ProgrameLanguageService programeLanguage, SchoolService school, JobExperienceService jobExperience) {
		super();
		this.cv = cv;
		this.language = language;
		this.programeLanguage = programeLanguage;
		this.school = school;
		this.jobExperience = jobExperience;
	}
	@GetMapping("/getallCv")
	public DataResult<List<Cv>> getAllCv(int id)
	{
		 return this.cv.getByEmployeeId(id);
	}
	@GetMapping("/getallSchool")
	public DataResult<List<School>> getAllSchool(int id)
	{
		 return this.school.getByEmployeeId(id);
	}
	@GetMapping("/getallJob")
	public DataResult<List<JobExperience>> getAllJob(int id)
	{
		 return this.jobExperience.getByEmployeeId(id);
	}
	@GetMapping("/getallLanguage")
	public DataResult<List<Language>> getAllLanguage(int id)
	{
		 return this.language.getByEmployeeId(id);
	}
	@GetMapping("/getallProgrameLanguage")
	public DataResult<List<ProgrameLanguage>> getAllProgrameLanguage(int id)
	{
		 return this.programeLanguage.getByEmployeeId(id);
	}
	@PostMapping("/addCv")
	public Result addCv(@RequestBody Cv cv) {
		return this.cv.add(cv);
	}
	@PostMapping("/addSchool")
	public Result addSchool(@RequestBody School school) {
		return this.school.add(school);
	}
	@PostMapping("/addJob")
	public Result addJobExperience(@RequestBody JobExperience jobExperience) {
		return this.jobExperience.add(jobExperience);
	}
	@PostMapping("/addLanguage")
	public Result add(@RequestBody Language language) {
		return this.language.add(language);
	}
	@PostMapping("/addProgrameLanguage")
	public Result add(@RequestBody ProgrameLanguage programeLanguage) {
		return this.programeLanguage.add(programeLanguage);
	}
}
