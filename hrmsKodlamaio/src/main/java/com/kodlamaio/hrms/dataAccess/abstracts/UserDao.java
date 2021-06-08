package com.kodlamaio.hrms.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kodlamaio.hrms.entities.concretes.User;
@Transactional
public interface UserDao  extends JpaRepository<User,Integer>{
	@Modifying
	@Query("update users u set u.email_verification = true where u.id = :id")
    void setVerification(@Param("id") int id);
}
