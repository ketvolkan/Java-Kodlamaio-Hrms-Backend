package com.kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kodlamaio.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School,Integer> {
	List<School> getByEmployeeId(int employeeId);
}
