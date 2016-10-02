package com.atfuture.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="requestcode")
public class RequestCode {
	//邀请码id
	private Integer reqCode_id;
	//邀请码内容
	private String reqCode_info;
	
	@Id
	@GeneratedValue
	@Column(name="reqCode_id")
	public Integer getReqCode_id() {
		return reqCode_id;
	}
	public void setReqCode_id(Integer reqCode_id) {
		this.reqCode_id = reqCode_id;
	}
	public String getReqCode_info() {
		return reqCode_info;
	}
	public void setReqCode_info(String reqCode_info) {
		this.reqCode_info = reqCode_info;
	}
	
	
	
}
