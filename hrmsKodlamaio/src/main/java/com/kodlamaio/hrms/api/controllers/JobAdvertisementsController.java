package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll()
	{
		 return this.jobAdvertisementService.getAll();
	}
	@GetMapping("/getallbyEmployerId")
	public DataResult<List<JobAdvertisement>> getallbyEmployerId(int id)
	{
		 return this.jobAdvertisementService.getByEmployerId(id);
	}
	@GetMapping("/getallbyActivity")
	public DataResult<List<JobAdvertisement>> getallbyActivity(boolean activity)
	{
		 return this.jobAdvertisementService.getByActive(activity);
	}
	@GetMapping("/getallbyAcvitityAndSortByreleaseDate")
	public DataResult<List<JobAdvertisement>> getallbyAcvitityAndSort(boolean activity)
	{
		 return this.jobAdvertisementService.getByActive(activity,Sort.by(Sort.Direction.ASC, "releaseDate"));
	}
	@GetMapping("/getallbyPage")
	public DataResult<List<JobAdvertisement>> getallbyPage(int pageNo,int pageSize)
	{
		 return this.jobAdvertisementService.getAll(pageNo-1, pageSize);
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement)
	{
		 return this.jobAdvertisementService.add(jobAdvertisement);
	}
	@PostMapping("/setPasive")
	public Result setPasive(int id)
	{
		 return this.jobAdvertisementService.setPasive(id);
	}
	@PostMapping("/setActive")
	public Result setActive(int id)
	{
		 return this.jobAdvertisementService.setActive(id);
	}
	@DeleteMapping("/delete")
	public Result delete(int id) {
		return this.jobAdvertisementService.delete(id);
		
	}
}
