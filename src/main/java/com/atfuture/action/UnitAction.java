package com.atfuture.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.Unit;
import com.atfuture.utils.Page_S;

@Controller
@Scope("prototype")
public class UnitAction extends BaseAction<Unit> {
	private Unit unit;
	private Page_S page_s;
	
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
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
		if(null==unit){
			return "addFail";
		}
		if("".equals(unit.getUni_name())){
			this.addRemind("添加失败,请不要输入空的名字!");
			return "addFail";
		}
		if(unitService.checkExist(unit.getUni_name())){
			this.addRemind("添加失败!单位名字已经存在");
			return "addFail";
		}
		unitService.addUnit(unit);
		this.addRemind("添加成功!");
		return "addSuccess";
	}
	
	//修改页面
	public String changePage(){
		if(unit==null||"".equals(unit.getUni_id())){
			return SUCCESS;
		}
		if(null!=page_s&&null!=page_s.getCurrentPage()){
			int pageNum=page_s.getCurrentPage();
			this.getRequest().setAttribute("pageNum", pageNum);
		}else{
			this.getRequest().setAttribute("pageNum", 1);
		}
		Unit jt=unitService.getUnit(unit.getUni_id());
		this.getRequest().setAttribute("findResult",jt);
		return "changePage";
	}
	
	//修改操作
	public String change(){
		int pageNum=page_s.getCurrentPage();
		this.getRequest().setAttribute("pageNum", pageNum);
		if(null==unit){
			this.addRemind("错误!请正确操作!");
			return "changePage";
		}
		if("".equals(unit.getUni_id())||"".equals(unit.getUni_name())){
			this.addRemind("修改失败,请正确操作!");
			Unit jt=null;
			try{
				jt=unitService.getUnit(unit.getUni_id());
			}catch(Exception e){}
			this.getRequest().setAttribute("findResult",jt);
			return "changePage";
		}
		if(unitService.checkExist(unit.getUni_name())){
			this.addRemind("修改失败,名字已存在!");
			Unit jt=unitService.getUnit(unit.getUni_id());
			this.getRequest().setAttribute("findResult",jt);
			return "changePage";
		}
		unitService.changeUnit(unit);
		this.addRemind("修改成功!");
		this.page_s.setPageSize(3);
		this.page_s.setCurrentPage(pageNum);
		this.page_s();
		return "page_sSuccess";
	}
	/*
	public String findByName(){
		List<Unit> findResults=unitService.findByName(unit.getUni_name());
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
		page_s.setPageSize(8);
		Page_S ps=unitService.page_s(page_s);
		this.getRequest().setAttribute("page_s",ps);
		return "page_sSuccess";
	}
}
