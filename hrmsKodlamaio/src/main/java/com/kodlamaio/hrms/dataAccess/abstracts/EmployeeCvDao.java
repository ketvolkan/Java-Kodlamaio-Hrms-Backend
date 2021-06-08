package com.kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kodlamaio.hrms.entities.concretes.Cv;

public interface EmployeeCvDao extends JpaRepository<Cv,Integer>{

	List<Cv> getByEmployeeId(int employeeId);
}
