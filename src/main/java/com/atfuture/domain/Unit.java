package com.atfuture.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unit")
public class Unit {

	private Integer uni_id;
	private String uni_name;
	
	@Id
	@GeneratedValue
	@Column(name="uni_id")
	public Integer getUni_id() {
		return uni_id;
	}
	public void setUni_id(Integer uni_id) {
		this.uni_id = uni_id;
	}
	public String getUni_name() {
		return uni_name;
	}
	public void setUni_name(String uni_name) {
		this.uni_name = uni_name;
	}
	
	
	
}
