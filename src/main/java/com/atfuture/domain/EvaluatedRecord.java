package com.atfuture.domain;

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
@Table(name="evaluaterecord")
public class EvaluatedRecord {

	private Integer evalRecor_id;
	private ParticipatedPerson evalRecor_participatedPerson;
	private Expert evalRecor_expart;
	private String evalRecor_spciaFamiliar;
	private String evalRecor_teaching;
	private String evalRecor_research;
	private String evalRecor_ethics;
	private String evalRecor_allAssessment;
	
	@Id
	@GeneratedValue
	@Column(name="evalrecor_id")
	public Integer getEvalRecor_id() {
		return evalRecor_id;
	}
	public void setEvalRecor_id(Integer evalRecor_id) {
		this.evalRecor_id = evalRecor_id;
	}
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true,fetch=FetchType.EAGER)
	public ParticipatedPerson getEvalRecor_participatedPerson() {
		return evalRecor_participatedPerson;
	}
	public void setEvalRecor_participatedPerson(ParticipatedPerson evalRecor_participatedPerson) {
		this.evalRecor_participatedPerson = evalRecor_participatedPerson;
	}
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true,fetch=FetchType.EAGER)
	public Expert getEvalRecor_expart() {
		return evalRecor_expart;
	}
	public void setEvalRecor_expart(Expert evalRecor_expart) {
		this.evalRecor_expart = evalRecor_expart;
	}
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy="evalRecor_spciaFamiliar")
	public String getEvalRecor_spciaFamiliar() {
		return evalRecor_spciaFamiliar;
	}
	public void setEvalRecor_spciaFamiliar(String evalRecor_spciaFamiliar) {
		this.evalRecor_spciaFamiliar = evalRecor_spciaFamiliar;
	}
	public String getEvalRecor_teaching() {
		return evalRecor_teaching;
	}
	public void setEvalRecor_teaching(String evalRecor_teaching) {
		this.evalRecor_teaching = evalRecor_teaching;
	}
	public String getEvalRecor_research() {
		return evalRecor_research;
	}
	public void setEvalRecor_research(String evalRecor_research) {
		this.evalRecor_research = evalRecor_research;
	}
	public String getEvalRecor_ethics() {
		return evalRecor_ethics;
	}
	public void setEvalRecor_ethics(String evalRecor_ethics) {
		this.evalRecor_ethics = evalRecor_ethics;
	}
	public String getEvalRecor_allAssessment() {
		return evalRecor_allAssessment;
	}
	public void setEvalRecor_allAssessment(String evalRecor_allAssessment) {
		this.evalRecor_allAssessment = evalRecor_allAssessment;
	}
	
	
	
	
}
