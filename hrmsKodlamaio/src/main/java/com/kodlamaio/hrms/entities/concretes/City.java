package com.kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="city")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","JobAdvertisement"})
public class City {

	@Column(name= "id")
	@Id
	private int id;
	@Column(name= "city_name")
	private String cityName;
	
	@OneToMany(mappedBy="city")
	private List<JobAdvertisement> jobAdvertisement;

	public City() {}
	public City(int id, String cityName) {
		super();
		this.id = id;
		this.cityName = cityName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
