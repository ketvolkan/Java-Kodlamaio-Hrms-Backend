package com.kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity(name = "employees")
@Table(name = "employees")
@DiscriminatorValue("2")
@PrimaryKeyJoinColumn(name = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","JobAdvertisement"})
public class Employee extends User {
		
	@Column(name= "first_name")
	private String first_name;
	
	@Column(name= "last_name")
	private String last_name;
	  
	@Column(name= "nationality_id")
	private String nationality_id;
	
	@Column(name= "date_year")
	private String date_year;
	
	@OneToMany(mappedBy="employee")
	private List<Cv> cv;
	
	@OneToMany(mappedBy="employee")
	private List<School> school;
	
	@OneToMany(mappedBy="employee")
	private List<Language> language;
	
	@OneToMany(mappedBy="employee")
	private List<ProgrameLanguage> programLanguage;
	
	@OneToMany(mappedBy="employee")
	private List<JobExperience> jobExperience;
	
	public Employee() {}
	
	public Employee(int id, String mail, String password,String first_name,
			String last_name, String nationality_id, String date_year) {
		super(mail, password);
		this.first_name = first_name;
		this.last_name = last_name;
		this.nationality_id = nationality_id;
		this.date_year = date_year;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getNationality_id() {
		return nationality_id;
	}

	public void setNationality_id(String nationality_id) {
		this.nationality_id = nationality_id;
	}

	public String getDate_year() {
		return date_year;
	}

	public void setDate_year(String date_year) {
		this.date_year = date_year;
	}

}
