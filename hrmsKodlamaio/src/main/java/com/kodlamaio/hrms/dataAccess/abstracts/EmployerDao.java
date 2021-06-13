package com.kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kodlamaio.hrms.entities.concretes.Employer;

@Transactional
public interface EmployerDao extends JpaRepository<Employer,Integer> {
	
	 @Query("SELECT t FROM employers t WHERE t.mail = :mail")
	 Employer findByEmail(@Param("mail") String mail);

	 @Modifying
	 @Query("update employers u set u.is_confirmed = true where u.id = :id")
     void setConfirimation(@Param("id") int id);
	 
	 List<Employer> findById(int id);
}
