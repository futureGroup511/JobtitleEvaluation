package com.atfuture.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.ParticipatedPerson;
import com.future.utils.Page_S;

@Controller
@Scope("prototype")
public class ParticipatedPersonAction extends BaseAction<ParticipatedPerson> implements RequestAware{

	
	private Map<String, Object> requestMap;
	
	private Integer currentPage;
	
	//管理参评人员信息 分页查询
	public String manageParticipatedPerson(){
		Integer recordCount = participatedPersonService.getAllParticipatedPerson().size();
		Integer pageSize = 10;
		if(currentPage == null || (currentPage+"").trim() == ""){
			currentPage = 0;
		}
		List<ParticipatedPerson> recordList = null; 
		Page_S page = new Page_S(currentPage, pageSize, recordCount, null);
		recordList = participatedPersonService.getParticipatedPersonByPage(page);
		page.setRecordlist(recordList);
		requestMap.put("pageBean", page);
		return "ManageParticipatedPerson";
	}
	
	//到达增加参评人员信息页面
	public String incrementParticipatedPerson(){
		
		return "ToIncrementParticipatedPersonPage";
	}

	
	
	
	
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}
	
	
	
	
	
	
}
