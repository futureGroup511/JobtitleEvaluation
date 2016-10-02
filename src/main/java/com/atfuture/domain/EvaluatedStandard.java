package com.atfuture.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	//标题
	private String  evalStan_title;
	//内容
	private String evalStan_content;
	//选项A B C D
	private String evalStan_itemA;
	private String evalStan_itemB;
	private String evalStan_itemC;
	private String evalStan_itemD;
	
	@Id
	@GeneratedValue
	@Column(name="evalStan_id")
	public Integer getEvalStan_id() {
		return evalStan_id;
	}
	public void setEvalStan_id(Integer evalStan_id) {
		this.evalStan_id = evalStan_id;
	}
	
	public String getEvalStan_content() {
		return evalStan_content;
	}
	public void setEvalStan_content(String evalStan_content) {
		this.evalStan_content = evalStan_content;
	}
	@OneToOne()
	public JobTitle getEvalStan_jobtile() {
		return evalStan_jobtile;
	}
	public void setEvalStan_jobtile(JobTitle evalStan_jobtile) {
		this.evalStan_jobtile = evalStan_jobtile;
	}
	public String getEvalStan_title() {
		return evalStan_title;
	}
	public void setEvalStan_title(String evalStan_title) {
		this.evalStan_title = evalStan_title;
	}
	public String getEvalStan_itemA() {
		return evalStan_itemA;
	}
	public void setEvalStan_itemA(String evalStan_itemA) {
		this.evalStan_itemA = evalStan_itemA;
	}
	public String getEvalStan_itemB() {
		return evalStan_itemB;
	}
	public void setEvalStan_itemB(String evalStan_itemB) {
		this.evalStan_itemB = evalStan_itemB;
	}
	public String getEvalStan_itemC() {
		return evalStan_itemC;
	}
	public void setEvalStan_itemC(String evalStan_itemC) {
		this.evalStan_itemC = evalStan_itemC;
	}
	public String getEvalStan_itemD() {
		return evalStan_itemD;
	}
	public void setEvalStan_itemD(String evalStan_itemD) {
		this.evalStan_itemD = evalStan_itemD;
	}
	
	
}
