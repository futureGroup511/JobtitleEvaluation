package com.atfuture.action;

<<<<<<< HEAD

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
=======
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
>>>>>>> fbda4f3b4a8a2c8ca47608a572d219af9c6e6541
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.JobTitle;
import com.future.utils.Page_S;

@Controller
@Scope("prototype")
<<<<<<< HEAD
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
	private HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	private void addRemind(String remind){
		ServletActionContext.getRequest().getSession().setAttribute("remind", remind);
	}
	public String add(){
		if("".equals(jobTitle.getJobTi_name())||jobTitle==null){
			this.addRemind("添加失败,请不要输入空的名字!");
			return "addSuccess";
		}
		if(jobTitleService.checkExist(jobTitle.getJobTi_name())){
			this.addRemind("添加失败!职称名字已经存在");
			return "addSuccess";
		}
		jobTitleService.addJobTitle(jobTitle);
		this.addRemind("添加成功!");
		return "addSuccess";
	}
	public String changePage(){
		JobTitle jt=jobTitleService.getJobTitle(jobTitle.getJobTi_id());
		this.getRequest().setAttribute("findResult",jt);
		return "changePage";
	}
	
	public String change(){
		if(null==jobTitle||"".equals(jobTitle.getJobTi_id())){
			this.addRemind("修改失败,请正确操作!");
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
		return "changeSuccess";
	}
	public String findByName(){
		List<JobTitle> findResults=jobTitleService.findByName(jobTitle.getJobTi_name());
		this.getRequest().setAttribute("findResults",findResults);
		return "findByName";
	}
	public String page_s(){
		page_s.setPageSize(20);
		Page_S ps=jobTitleService.page_s(page_s);
		
		this.getRequest().setAttribute("page_s",ps);
		return "page_sSuccess";
=======
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
>>>>>>> fbda4f3b4a8a2c8ca47608a572d219af9c6e6541
	}
}
