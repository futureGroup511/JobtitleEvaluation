package com.atfuture.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.EvaluatedStandard;
import com.atfuture.domain.Expert;
import com.atfuture.domain.ParticipatedPerson;
import com.future.utils.Page_S;
@Controller
@Scope("prototype")
public class ExpertAction extends BaseAction<Expert> implements RequestAware{

	private Integer currentPage=1;
	private Integer pageSize=10;
	private ParticipatedPerson person=ParticipatedPerson.newInstance();
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
		EvaluatedStandard evaluatedStandard=evaluatedStandardService.findByJobTitleId(4);
		request.put("evaluatedStandard", evaluatedStandard);
		person=participatedPersonService.findById(person.getParti_id());
		request.put("person", person);
		return "assess";
	}
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	

	public ParticipatedPerson getPerson() {
		return person;
	}

	public void setPerson(ParticipatedPerson person) {
		this.person = person;
	}



	private Map<String, Object> request;
	public void setRequest(Map<String, Object> arg0) {
		request=arg0;
	}

	
	
}
