package com.atfuture.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.JobTitle;

@Controller
@Scope("prototype")
public class JobTitleAction extends BaseAction<JobTitle> implements RequestAware{

	
	private Map<String, Object> requestMap;
	
	//管理对应职称的申请标准
	public String manageJobTitleStandard(){
		List<JobTitle> jobTitleList = jobTitleService.getAllJobTitle();
		requestMap.put("jobTitleList", jobTitleList);
		return "ManageJobTitleList";
	}

	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}
}
