package com.atfuture.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="expert")
public class Expert {

	//专家id
	private Integer exp_id;
	//专家姓名
	private String exp_name;
	//专家账号
	private String exp_accountNum;
	//专家密码
	private String exp_password;
	//专家专业
	private Specialty exp_specialty;
	//专家职称
	private JobTitle exp_jobTitle;
	//专家学历
	private String exp_educationLevel;
	//所属单元
	private Unit exp_unit;
	//评议记录
	private Set<EvaluatedRecord> exp_evaluateRecord=new HashSet<EvaluatedRecord>();
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
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true,fetch=FetchType.EAGER)
	public Unit getExp_unit() {
		return exp_unit;
	}
	public void setExp_unit(Unit exp_unit) {
		this.exp_unit = exp_unit;
	}
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy="evalRecor_expart")
	public Set<EvaluatedRecord> getExp_evaluateRecord() {
		return exp_evaluateRecord;
	}
	public void setExp_evaluateRecord(Set<EvaluatedRecord> exp_evaluateRecord) {
		this.exp_evaluateRecord = exp_evaluateRecord;
	}
	
	
	
	
	
	
}
