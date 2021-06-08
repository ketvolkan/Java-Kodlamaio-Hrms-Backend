package com.kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.entities.concretes.ProgrameLanguage;


public interface ProgrameLanguageDao extends JpaRepository<ProgrameLanguage, Integer> {
	List<ProgrameLanguage> getByEmployeeId(int id);
}
