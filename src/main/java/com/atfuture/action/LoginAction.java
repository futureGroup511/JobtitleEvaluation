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
import com.atfuture.interfaceUtils.Role;
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
		session.clear();
		if(jugeRole(role)==2){
			ActionContext.getContext().getValueStack().push("success");
		}else{
			ActionContext.getContext().getValueStack().push("erro");
		}
		return "login";
	}
	public String loginOut(){
		session.clear();
		return "loginOut";
	}
	public  String finishLogin(){
		return "finishLogin";
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
	

	/**
	 * 角色登陆判断
	 * @param role 角色
	 * @return 判断是否存在的状态
	 */
	public int jugeRole(int role){
		Role r = null;
		if(role==EXPERT){//专家登陆
			Expert expert=expertService.findByNumAndPassword(num, password);
			if(expert!=null) expert.getAllCascadeInformation();
			r=expert;
		}else if(role==MANNGER){//管理员登陆
			SuperManager superManager=superManagerService.findByNumAndPassword(num, password);
			r=superManager;
		}
		if(r!=null){
			session.put("role",r);
			return 2;
		}
		return 1;
	}
	

	

}
