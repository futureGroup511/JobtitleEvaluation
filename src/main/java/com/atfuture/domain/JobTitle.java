package com.atfuture.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jobtitle")
public class JobTitle {

	private Integer jobTi_id;
	private String jobTi_name;
	
	@Id
	@GeneratedValue
	@Column(name="jobTi_id")
	public Integer getJobTi_id() {
		return jobTi_id;
	}
	public void setJobTi_id(Integer jobTi_id) {
		this.jobTi_id = jobTi_id;
	}
	public String getJobTi_name() {
		return jobTi_name;
	}
	public void setJobTi_name(String jobTi_name) {
		this.jobTi_name = jobTi_name;
	}
	
}