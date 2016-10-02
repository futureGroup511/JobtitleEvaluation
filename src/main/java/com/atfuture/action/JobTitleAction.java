package com.atfuture.action;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.JobTitle;
import com.future.utils.Page_S;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class JobTitleAction extends BaseAction<JobTitle>{
	private JobTitle jobTitle;
	private Page_S page_s;
	
	public JobTitle getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Page_S getPage_s() {
		return page_s;
	}
	public void setPage_s(Page_S page_s) {
		this.page_s = page_s;
	}
	
	public String execute(){
		return SUCCESS;
	}
	
	public String get(){
		JobTitle jt=jobTitleService.getJobTitle(jobTitle.getJobTi_id());
		ActionContext ac=ActionContext.getContext();
		Map<String,Object> request=(Map)ac.get("request");
		request.put("jobTitle",jt);
		return "getSuccess";
	}
	
	public String add(){
		jobTitleService.addJobTitle(jobTitle);
		return "addSuccess";
	}
	public String change(){
		jobTitleService.changeJobTitle(jobTitle);
		return "changeSuccess";
	}
	public String findByName(){
		List<JobTitle> findResults=jobTitleService.findByName(jobTitle.getJobTi_name());
		ActionContext ac=ActionContext.getContext();
		Map<String,Object> request=(Map)ac.get("request");
		request.put("findResults",findResults);
		return "findSuccess";
	}
	public String page_s(){
		ActionContext ac=ActionContext.getContext();
		Map request=(Map) ac.get("request");
		Page_S ps=jobTitleService.page_s(page_s);
		request.put("page_s",ps);
		return "page_sSuccess";
	}
}
