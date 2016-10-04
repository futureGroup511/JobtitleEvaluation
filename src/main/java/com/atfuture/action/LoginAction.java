package com.atfuture.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.Expert;
import com.atfuture.domain.SuperManager;
import com.atfuture.domain.Test;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class LoginAction extends BaseAction<Object> implements SessionAware{
	
		
	private String num;
	private String password;
	private int role;
	
	private static final int EXPERT=1;
	private static final int MANNGER=2;
	public String login(){
		int status=1;
		if(role==EXPERT){//专家登陆
			Expert expert=expertService.findByNumAndPassword(num, password);
			expert.getExp_jobTitle();
			expert.getExp_specialty();
			expert.getExp_unit();
			if(expert!=null){
				session.put("expert", expert);
				status=2;
				
			}
		}else if(role==MANNGER){//管理员登陆
			SuperManager superManager=superManagerService.findByNumAndPassword(num, password);
			if(superManager!=null){
				session.put("superManager", superManager);
				status=2;
			}
		}
		if(status==2){
			ActionContext.getContext().getValueStack().push("success");
		}else{
			ActionContext.getContext().getValueStack().push("erro");
		}
		return "login";
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	private Map<String, Object> session;
	public void setSession(Map<String, Object> arg0) {
		session=arg0;
	}

	

	

}
