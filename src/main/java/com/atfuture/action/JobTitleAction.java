package com.atfuture.action;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.EvaluatedStandard;
import com.atfuture.domain.JobTitle;
import com.future.utils.Page_S;

@Controller
@Scope("prototype")

public class JobTitleAction extends BaseAction<JobTitle> implements RequestAware{
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
		this.page_s();
		return "page_sSuccess";
	}
	private HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	private void addRemind(String remind){
		ServletActionContext.getRequest().getSession().setAttribute("remind", remind);
	}
	public String add(){
		if(null==jobTitle){
			return "addFail";
		}
		if("".equals(jobTitle.getJobTi_name())){
			this.addRemind("添加失败,请不要输入空的名字!");
			return "addFail";
		}
		if(jobTitleService.checkExist(jobTitle.getJobTi_name())){
			this.addRemind("添加失败!职称名字已经存在");
			return "addFail";
		}
		jobTitleService.addJobTitle(jobTitle);
		this.addRemind("添加成功!");
		return "addSuccess";
	}
	
	//修改页面
	public String changePage(){
		if(jobTitle==null||"".equals(jobTitle.getJobTi_id())){
			return SUCCESS;
		}
		if(null!=page_s&&null!=page_s.getCurrentPage()){
			int pageNum=page_s.getCurrentPage();
			this.getRequest().setAttribute("pageNum", pageNum);
		}else{
			this.getRequest().setAttribute("pageNum", 1);
		}
		JobTitle jt=jobTitleService.getJobTitle(jobTitle.getJobTi_id());
		this.getRequest().setAttribute("findResult",jt);
		return "changePage";
	}
	
	//修改操作
	public String change(){
		int pageNum=page_s.getCurrentPage();
		this.getRequest().setAttribute("pageNum", pageNum);
		if(null==jobTitle){
			this.addRemind("错误!请正确操作!");
			return "changePage";
		}
		if("".equals(jobTitle.getJobTi_id())||"".equals(jobTitle.getJobTi_name())){
			this.addRemind("修改失败,请输入名字!");
			JobTitle jt=null;
			try{
				jt=jobTitleService.getJobTitle(jobTitle.getJobTi_id());
			}catch(Exception e){
				
			}
			this.getRequest().setAttribute("findResult",jt);
			return "changePage";
		}
		if(jobTitleService.checkExist(jobTitle.getJobTi_name())){
			this.addRemind("修改失败,名字已存在!");
			JobTitle jt=jobTitleService.getJobTitle(jobTitle.getJobTi_id());
			this.getRequest().setAttribute("findResult",jt);
			return "changePage";
		}
		jobTitleService.changeJobTitle(jobTitle);
		this.addRemind("修改成功!");
		this.page_s.setPageSize(3);
		this.page_s.setCurrentPage(pageNum);
		this.page_s();
		return "page_sSuccess";
	}
	/*
	public String findByName(){
		List<JobTitle> findResults=jobTitleService.findByName(jobTitle.getJobTi_name());
		this.getRequest().setAttribute("findResults",findResults);
		return "findByName";
	}
	*/
	public String page_s(){
		if(null==page_s){
			page_s=new Page_S();
		}
		if(page_s.getCurrentPage()==null||page_s.getCurrentPage()==0){
			page_s.setCurrentPage(1);
		}
		page_s.setPageSize(3);
		Page_S ps=jobTitleService.page_s(page_s);
		this.getRequest().setAttribute("page_s",ps);
		return "page_sSuccess";
	}
	

	private Map<String, Object> requestMap;
	
	//管理对应职称的申请标准
	public String manageJobTitleStandard(){
		List<JobTitle> jobTitleList = jobTitleService.getAllJobTitle();
		requestMap.put("jobTitleList", jobTitleList);
		return "ManageJobTitleList";
	}
	
	private Integer  jobTi_id;
	public String passToJobTitleStandardPage(){
		EvaluatedStandard evaluatedStandard = evaluatedStandardService.getStandardByJobTitleId(jobTi_id);
		requestMap.put("evaluatedStandard", evaluatedStandard);
		return "JobTitleStandardPage";
	}
	
	
	
	
	
	
	
	
	
	
	

	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}

	public Integer getJobTi_id() {
		return jobTi_id;
	}

	public void setJobTi_id(Integer jobTi_id) {
		this.jobTi_id = jobTi_id;
	}
	
}
