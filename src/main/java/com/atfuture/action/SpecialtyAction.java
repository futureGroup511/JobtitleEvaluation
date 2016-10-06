package com.atfuture.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.Specialty;
import com.future.utils.Page_S;
@Controller
@Scope("prototype")
public class SpecialtyAction extends BaseAction<Specialty>  {
	private Specialty specialty;
	private Page_S page_s;
	
	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
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
		if(null==specialty){
			return "addFail";
		}
		if("".equals(specialty.getSpec_name())){
			this.addRemind("添加失败,请不要输入空的名字!");
			return "addFail";
		}
		if(specialtyService.checkExist(specialty.getSpec_name())){
			this.addRemind("添加失败!名字已经存在");
			return "addFail";
		}
		specialtyService.addSpecialty(specialty);
		this.addRemind("添加成功!");
		return "addSuccess";
	}
	public String changePage(){
		if(specialty==null||"".equals(specialty.getSpec_id())){
			return SUCCESS;
		}
		
		if(null!=page_s&&null!=page_s.getCurrentPage()){
			String pageNum=page_s.getCurrentPage().toString();
			this.getRequest().setAttribute("pageNum", pageNum);
		}else{
			this.getRequest().setAttribute("pageNum", 1);
		}
		Specialty jt=specialtyService.getSpecialty(specialty.getSpec_id());
		this.getRequest().setAttribute("findResult",jt);
		return "changePage";
	}
	
	public String change(){
		int pageNum=page_s.getCurrentPage();
		this.getRequest().setAttribute("pageNum", pageNum);
		if(null==specialty){
			this.addRemind("错误!请正确操作!");
			return "changePage";
		}
		if("".equals(specialty.getSpec_id())||"".equals(specialty.getSpec_name())){
			this.addRemind("修改失败,请正确操作!");
			Specialty jt=null;
			try{
				jt=specialtyService.getSpecialty(specialty.getSpec_id());
			}catch(Exception e){}
			this.getRequest().setAttribute("findResult",jt);
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
		this.page_s.setPageSize(3);
		this.page_s.setCurrentPage(pageNum);
		this.page_s();
		return "page_sSuccess";
	}
	/*
	public String findByName(){
		List<Specialty> findResults=specialtyService.findByName(specialty.getSpec_name());
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
		Page_S ps=specialtyService.page_s(page_s);
		this.getRequest().setAttribute("page_s",ps);
		return "page_sSuccess";
	}
}
