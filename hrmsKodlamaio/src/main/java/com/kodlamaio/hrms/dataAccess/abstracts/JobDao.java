package com.kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kodlamaio.hrms.entities.concretes.Job;


public interface JobDao extends JpaRepository<Job,Integer> {
	
	 @Query("SELECT t FROM job_title t WHERE t.title = :title")
	 Job findByTitle(@Param("title") String title);

}
