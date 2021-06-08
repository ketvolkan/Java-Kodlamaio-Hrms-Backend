package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerCheckService {
	
	boolean allFieldsAreRequired(Employer employer);
	boolean findByMail(Employer employer);
	boolean checkMailOnSite(Employer employer);
	String allMatch(Employer employer);
}
