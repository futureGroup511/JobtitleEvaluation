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
@Table(name="evaluatedstandard")
public class EvaluatedStandard {
	
	//评价标准id
	private Integer evalStan_id;
	//职称
	private JobTitle evalStan_jobtile;
	//教学指标
	private String evalStan_teachStandard;
	//科研指标
	private String evalStan_scientifiStandard;
	//师德指标
	private String evalStan_moralityStandard; 
	
	@Id
	@GeneratedValue
	@Column(name="evalStan_id")
	public Integer getEvalStan_id() {
		return evalStan_id;
	}
	public void setEvalStan_id(Integer evalStan_id) {
		this.evalStan_id = evalStan_id;
	}
	
	@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY,targetEntity=JobTitle.class)
	public JobTitle getEvalStan_jobtile() {
		return evalStan_jobtile;
	}
	public void setEvalStan_jobtile(JobTitle evalStan_jobtile) {
		this.evalStan_jobtile = evalStan_jobtile;
	}
	public String getEvalStan_teachStandard() {
		return evalStan_teachStandard;
	}
	public void setEvalStan_teachStandard(String evalStan_teachStandard) {
		this.evalStan_teachStandard = evalStan_teachStandard;
	}
	public String getEvalStan_scientifiStandard() {
		return evalStan_scientifiStandard;
	}
	public void setEvalStan_scientifiStandard(String evalStan_scientifiStandard) {
		this.evalStan_scientifiStandard = evalStan_scientifiStandard;
	}
	public String getEvalStan_moralityStandard() {
		return evalStan_moralityStandard;
	}
	public void setEvalStan_moralityStandard(String evalStan_moralityStandard) {
		this.evalStan_moralityStandard = evalStan_moralityStandard;
	}
	
	
}
