package com.atfuture.action;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.Specialty;
import com.future.utils.Page_S;
import com.opensymphony.xwork2.ActionContext;
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

	public String execute(){
		
		return SUCCESS;
	}
	
	public String add(){
		if(specialty.getSpec_id()!=null||specialty.getSpec_name()==null||"".equals(specialty.getSpec_name())){
			this.addActionError("请正确填写专业信息!");
		}
		specialtyService.add(specialty);
		return "addSuccess";
	}
	
	
	public String page_s(){
		ActionContext ac=ActionContext.getContext();
		Map request=(Map) ac.get("request");
		Page_S ps=specialtyService.page_s(page_s);
		request.put("page_s",ps);
		return "page_sSuccess";
	}
	public String change(){
		specialtyService.change(specialty);
		return "changeSuccess";
	}
	public String findByName(){
		List<Specialty> findResults=specialtyService.findByName(specialty.getSpec_name());
		ActionContext ac=ActionContext.getContext();
		Map request=(Map)ac.get("request");
		request.put("findResults", findResults);
		return "findByNameSuccess";
	}
	public String findById(){
		Specialty findResult=specialtyService.getById(specialty.getSpec_id());
		ActionContext ac=ActionContext.getContext();
		Map request=(Map)ac.get("request");
		request.put("findResult", findResult);
		return "findByIdSuccess";
	}
}
