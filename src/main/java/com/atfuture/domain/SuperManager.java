package com.atfuture.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.atfuture.interfaceUtils.Role;

@Entity
@Table(name="supermanager")
public class SuperManager implements Role{
	
	//超级管理员id
	private Integer sup_id;
	//超级管理员姓名
	private String sup_name;
	//超级管理员账号
	private String sup_accountNum;
	//超级管理员密码
	private String sup_password;
	@Id
	@GeneratedValue
	@Column(name="sup_id")
	public Integer getSup_id() {
		return sup_id;
	}
	public void setSup_id(Integer sup_id) {
		this.sup_id = sup_id;
	}
	public String getSup_name() {
		return sup_name;
	}
	public void setSup_name(String sup_name) {
		this.sup_name = sup_name;
	}
	public String getSup_accountNum() {
		return sup_accountNum;
	}
	public void setSup_accountNum(String sup_accountNum) {
		this.sup_accountNum = sup_accountNum;
	}
	public String getSup_password() {
		return sup_password;
	}
	public void setSup_password(String sup_password) {
		this.sup_password = sup_password;
	}
	public String findSelfName() {
		return "superManager";
	}
	public String helloName() {
		return this.sup_name;
	}
	
}
