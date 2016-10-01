package com.atfuture.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="participateperson")
public class ParticipatedPerson {

	private Integer parti_id;
	private String  parti_name;
	private Specialty parti_specialty;
	private JobTitle parti_jobTitle;
	private Unit parti_recommendUnit;
	
	@Id
	@GeneratedValue
	@Column(name="parti_id")
	public Integer getParti_id() {
		return parti_id;
	}
	public void setParti_id(Integer parti_id) {
		this.parti_id = parti_id;
	}
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true,fetch=FetchType.EAGER)
	public String getParti_name() {
		return parti_name;
	}
	public void setParti_name(String parti_name) {
		this.parti_name = parti_name;
	}
	public Specialty getParti_specialty() {
		return parti_specialty;
	}
	public void setParti_specialty(Specialty parti_specialty) {
		this.parti_specialty = parti_specialty;
	}
	@OneToOne()
	public JobTitle getParti_jobTitle() {
		return parti_jobTitle;
	}
	public void setParti_jobTitle(JobTitle parti_jobTitle) {
		this.parti_jobTitle = parti_jobTitle;
	}
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true,fetch=FetchType.EAGER)
	public Unit getParti_recommendUnit() {
		return parti_recommendUnit;
	}
	public void setParti_recommendUnit(Unit parti_recommendUnit) {
		this.parti_recommendUnit = parti_recommendUnit;
	}
	
	
}
