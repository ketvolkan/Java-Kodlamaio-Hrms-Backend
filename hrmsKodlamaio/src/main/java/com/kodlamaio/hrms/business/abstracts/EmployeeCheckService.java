package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.entities.concretes.Employee;

public interface EmployeeCheckService {
	
	boolean allFieldsAreRequired(Employee employee);
	boolean findByMailAndNId(Employee employee);
	boolean checkMernis(Employee employee);
	String allMatch(Employee employee);
}
