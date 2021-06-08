package com.kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.core.adapter.abstracts.EmailService;
import com.kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/approveEmail")
	public Result approve(int id) {
		return this.emailService.approveMail(id);
	}
}
