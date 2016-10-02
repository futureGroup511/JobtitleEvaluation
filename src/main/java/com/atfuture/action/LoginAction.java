package com.atfuture.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.Expert;
import com.atfuture.domain.Test;

@Controller
@Scope("prototype")
public class LoginAction extends BaseAction<Object> {
	
		
	private String num;
	private String password;
	public String login(){
		
		Test test=testser.loginByNumAndPassword(num, password);
		if(test!=null){
			return "success";
		}
		System.out.println();
		return "erro";
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

}
