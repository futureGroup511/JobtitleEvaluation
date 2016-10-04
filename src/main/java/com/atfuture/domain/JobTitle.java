package com.atfuture.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="jobtitle")
public class JobTitle {
	
	//职称id
	private Integer jobTi_id;
	//职称名称
	private String jobTi_name;
	
	private EvaluatedStandard jobTi_evaluastand;
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
	
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY,mappedBy="evalStan_jobtile",targetEntity=EvaluatedStandard.class)
	public EvaluatedStandard getJobTi_evaluastand() {
		return jobTi_evaluastand;
	}
	public void setJobTi_evaluastand(EvaluatedStandard jobTi_evaluastand) {
		this.jobTi_evaluastand = jobTi_evaluastand;
	}
	
	
}
