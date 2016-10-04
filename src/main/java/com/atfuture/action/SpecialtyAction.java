package com.atfuture.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.JobTitle;
import com.atfuture.domain.Specialty;
import com.future.utils.Page_S;
@Controller
@Scope("prototype")
public class SpecialtyAction extends BaseAction<Specialty>  {
	
	private Specialty specialty;
	private Page_S page_s;
	
	public Page_S getPage_s() {
		return page_s;
	}
	public void setPage_s(Page_S page_s) {
		this.page_s = page_s;
	}
	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	private HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	private void addRemind(String remind){
		ServletActionContext.getRequest().getSession().setAttribute("remind", remind);
	}
	
	public String execute(){
		return SUCCESS;
	}
	
	public String add(){
		if("".equals(specialty.getSpec_name())||specialty==null){
			this.addRemind("添加失败,请不要输入空的名字!");
			return "addSuccess";
		}
		if(specialtyService.checkExist(specialty.getSpec_name())){
			this.addRemind("添加失败!名字已经存在");
			return "addSuccess";
		}
		specialtyService.addSpecialty(specialty);
		this.addRemind("添加成功!");
		return "addSuccess";
	}
	public String changePage(){
		Specialty jt=specialtyService.getSpecialty(specialty.getSpec_id());
		this.getRequest().setAttribute("findResult",jt);
		return "changePage";
	}
	public String change(){
		if(null==specialty||"".equals(specialty.getSpec_id())){
			this.addRemind("修改失败,请正确操作!");
			return "changePage";
		}
		if(specialtyService.checkExist(specialty.getSpec_name())){
			this.addRemind("修改失败,名字已存在!");
			Specialty jt=specialtyService.getSpecialty(specialty.getSpec_id());
			this.getRequest().setAttribute("findResult",jt);
			return "changePage";
		}
		specialtyService.changeSpecialty(specialty);
		this.addRemind("修改成功!");
		return "changeSuccess";
	}
	public String findByName(){
		List<Specialty> findResults=specialtyService.findByName(specialty.getSpec_name());
		this.getRequest().setAttribute("findResults",findResults);
		return "findByName";
	}
	public String page_s(){
		page_s.setPageSize(20);
		Page_S ps=specialtyService.page_s(page_s);
		
		this.getRequest().setAttribute("page_s",ps);
		return "page_sSuccess";
	}
}
