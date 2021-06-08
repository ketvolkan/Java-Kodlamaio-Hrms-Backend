package com.kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity(name = "employers")
@Table(name = "employers")
@DiscriminatorValue("1")
@PrimaryKeyJoinColumn(name = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","JobAdvertisement"})
public class Employer extends User {


	@Column(name= "company_name")
	private String company_name;
	
	@Column(name= "website")
	private String website;
	 
	@Column(name= "phone_number")
	private String phone_number;
	
	@Column(name = "is_confirmed",columnDefinition = "boolean default false")
	private boolean is_confirmed = false;
	
	@OneToMany(mappedBy="employer")
	private List<JobAdvertisement> jobAdvertisement;



	public Employer() {

	}
	
	public Employer( String mail, String password,String company_name,
			String website, String phone_number) {
		super(mail, password);
		this.company_name = company_name;
		this.website = website;
		this.phone_number = phone_number;
	}
	
	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
}
