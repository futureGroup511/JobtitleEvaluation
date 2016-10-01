package com.atfuture.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="expert")
public class Expart {

	private Integer exp_id;
	private String exp_name;
	private String exp_accountNum;
	private String exp_password;
	private Specialty exp_specialty;
	private JobTitle exp_jobTitle;
	private String exp_educationLevel;
	private Unit exp_unit;
	private EvaluateRecord exp_evaluateRecord;
	@Id
	@GeneratedValue
	@Column(name="exp_id")
	public Integer getExp_id() {
		return exp_id;
	}
	public void setExp_id(Integer exp_id) {
		this.exp_id = exp_id;
	}
	public String getExp_name() {
		return exp_name;
	}
	public void setExp_name(String exp_name) {
		this.exp_name = exp_name;
	}
	public String getExp_accountNum() {
		return exp_accountNum;
	}
	public void setExp_accountNum(String exp_accountNum) {
		this.exp_accountNum = exp_accountNum;
	}
	public String getExp_password() {
		return exp_password;
	}
	public void setExp_password(String exp_password) {
		this.exp_password = exp_password;
	}
	
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true,fetch=FetchType.EAGER)
	public Specialty getExp_specialty() {
		return exp_specialty;
	}
	public void setExp_specialty(Specialty exp_specialty) {
		this.exp_specialty = exp_specialty;
	}
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true,fetch=FetchType.EAGER)
	public JobTitle getExp_jobTitle() {
		return exp_jobTitle;
	}
	public void setExp_jobTitle(JobTitle exp_jobTitle) {
		this.exp_jobTitle = exp_jobTitle;
	}
	public String getExp_educationLevel() {
		return exp_educationLevel;
	}
	public void setExp_educationLevel(String exp_educationLevel) {
		this.exp_educationLevel = exp_educationLevel;
	}
	public Unit getExp_unit() {
		return exp_unit;
	}
	public void setExp_unit(Unit exp_unit) {
		this.exp_unit = exp_unit;
	}
	public EvaluateRecord getExp_evaluateRecord() {
		return exp_evaluateRecord;
	}
	public void setExp_evaluateRecord(EvaluateRecord exp_evaluateRecord) {
		this.exp_evaluateRecord = exp_evaluateRecord;
	}
	
	
	
}
