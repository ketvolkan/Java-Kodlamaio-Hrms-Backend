package com.kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kodlamaio.hrms.entities.concretes.JobAdvertisement;
@Transactional
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

    List<JobAdvertisement> getByEmployerId( int employerId);
    List<JobAdvertisement> getByActive(boolean activity);
    List<JobAdvertisement> getByActive(boolean activity,Sort sort);
    @Modifying
    @Query("update JobAdvertisement j set j.active = false where j.id=:id")
    void setPasive(@Param("id") int id);
    
    @Modifying
    @Query("update JobAdvertisement j set j.active = true where j.id=:id")
    void setActive(@Param("id") int id);
  /* @Query("Select new com.kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
    		+ "(j.id,e.company_name,c.title,j.positionCount,j.releaseDate,j.deadline)"
    		+ "From JobAdvertisement j "
    		+ "INNER JOIN j.employer e"
    		+ "INNER JOIN j.jobPosition c "
    		+ "where j.active = :activity")*/
}
