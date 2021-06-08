package com.kodlamaio.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.kodlamaio.hrms.entities.concretes.Employee;


public interface EmployeeDao extends JpaRepository<Employee,Integer>  {

	 @Query("SELECT t FROM employees t WHERE t.mail = :mail OR t.nationality_id = :nationality_id")
	 Employee findByEmailandNid(@Param("mail") String mail,@Param("nationality_id") String nationality_id);
}
