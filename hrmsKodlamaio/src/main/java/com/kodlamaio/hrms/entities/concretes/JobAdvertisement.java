package com.kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;



@Entity
@Table(name="job_advertisement")

public class JobAdvertisement {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private Job jobPosition;
	
	@Column(name="position_count")
	private int positionCount;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@Column(name="release_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreationTimestamp
	private Date releaseDate;
	
	@Column(name="deadline")
	private Date deadline;
	
	@Column(name="max_salary",columnDefinition = "integer default 0")
	private int maxSalary=0;
	
	@Column(name="min_salary",columnDefinition = "integer default 0")
	private int minSalary=0;
	
	@Column(name="active",columnDefinition = "boolean default false")
	private boolean active=false;
	
	@Column(name="description")
	private String description;
	
	@Column(name="way_of_working")
	private String wayOfWorking;
	
	@Column(name="full_or_half")
	private String fullOrHalf;

	public String getWayOfWorking() {
		return wayOfWorking;
	}
	public void setWayOfWorking(String wayOfWorking) {
		this.wayOfWorking = wayOfWorking;
	}
	public String getFullOrHalf() {
		return fullOrHalf;
	}
	public void setFullOrHalf(String fullOrHalf) {
		this.fullOrHalf = fullOrHalf;
	}
	public JobAdvertisement() 
	{
	
	}
	public JobAdvertisement(int id, Employer employer, Job jobPosition, int positionCount, City city,
			Date releaseDate, Date deadline, int maxSalary, int minSalary, boolean active, String description) 
	{
		super();
		this.id = id;
		this.employer = employer;
		this.jobPosition = jobPosition;
		this.positionCount = positionCount;
		this.city = city;
		this.releaseDate = releaseDate;
		this.deadline = deadline;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
		this.active = active;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Job getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(Job jobPosition) {
		this.jobPosition = jobPosition;
	}

	public int getPositionCount() {
		return positionCount;
	}

	public void setPositionCount(int positionCount) {
		this.positionCount = positionCount;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}

	public int getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
		
}
