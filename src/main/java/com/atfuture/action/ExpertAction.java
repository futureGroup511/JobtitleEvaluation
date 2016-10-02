package com.atfuture.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.Expert;
import com.future.utils.Page_S;
@Controller
@Scope("prototype")
public class ExpertAction extends BaseAction<Expert> implements RequestAware{

	private Integer currentPage=1;
	private Integer pageSize=10;
	
	//所有参评人员
	public String allEvaluaTeacher(){
		
		Page_S p=Page_S.newInstance();
		p.setCurrentPage(currentPage);
		p.setPageSize(pageSize);
		p=participatedPersonService.findAllParticipatedPerson(p);
		request.put("p", p);
		return "allEvaluaTeacher";
	}

	//审评
	public String assess(){
		
		return null;
	}
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	private Map<String, Object> request;
	public void setRequest(Map<String, Object> arg0) {
		request=arg0;
	}
	
}
