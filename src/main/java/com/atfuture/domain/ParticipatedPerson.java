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

	//参评人id
	private Integer parti_id;
	//参评人姓名
	private String  parti_name;
	//参评人申报专业
	private Specialty parti_specialty;
	//参评人申报职称
	private JobTitle parti_jobTitle;
	//推荐单位
	private Unit parti_recommendUnit;
	//资料url路径
	private String parti_pathurl;
	
	@Id
	@GeneratedValue
	@Column(name="parti_id")
	public Integer getParti_id() {
		return parti_id;
	}
	public void setParti_id(Integer parti_id) {
		this.parti_id = parti_id;
	}
	
	public String getParti_name() {
		return parti_name;
	}
	public void setParti_name(String parti_name) {
		this.parti_name = parti_name;
	}
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true,fetch=FetchType.EAGER)
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
	public String getParti_pathurl() {
		return parti_pathurl;
	}
	public void setParti_pathurl(String parti_pathurl) {
		this.parti_pathurl = parti_pathurl;
	}
	
	public static ParticipatedPerson newInstance(){
		return new ParticipatedPerson();
	}
	
}
