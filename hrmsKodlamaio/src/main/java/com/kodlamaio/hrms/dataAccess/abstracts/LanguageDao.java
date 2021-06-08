package com.kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.entities.concretes.Language;


public interface LanguageDao extends JpaRepository<Language, Integer>{
	List<Language> getByEmployeeId(int id);
}
