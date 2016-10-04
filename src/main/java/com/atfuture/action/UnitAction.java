package com.atfuture.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.JobTitle;
import com.atfuture.domain.Unit;
import com.future.utils.Page_S;
import com.opensymphony.xwork2.ActionContext;

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
		if("".equals(unit.getUni_name())||unit==null){
			this.addRemind("添加失败,请不要输入空的名字!");
			return "addSuccess";
		}
		if(unitService.checkExist(unit.getUni_name())){
			this.addRemind("添加失败!职称名字已经存在");
			return "addSuccess";
		}
		unitService.addUnit(unit);
		this.addRemind("添加成功!");
		return "addSuccess";
	}
	public String changePage(){
		Unit jt=unitService.getUnit(unit.getUni_id());
		this.getRequest().setAttribute("findResult",jt);
		return "changePage";
	}
	public String change(){
		if(null==unit||"".equals(unit.getUni_name())||"".equals(unit.getUni_id())){
			this.addRemind("修改失败,请正确操作!");
			Unit u=unitService.getUnit(unit.getUni_id());
			this.getRequest().setAttribute("findResult",u);
			return "changePage";
		}
		if(unitService.checkExist(unit.getUni_name())){
			this.addRemind("修改失败,名字已存在!");
			Unit u=unitService.getUnit(unit.getUni_id());
			this.getRequest().setAttribute("findResult",u);
			return "changePage";
		}
		unitService.changeUnit(unit);
		this.addRemind("修改成功!");
		return "changeSuccess";
	}
	public String findByName(){
		List<Unit> findResults=unitService.findByName(unit.getUni_name());
		this.getRequest().setAttribute("findResults",findResults);
		return "findByName";
	}
	
	public String page_s(){
		page_s.setPageSize(20);
		Page_S ps=unitService.page_s(page_s);
		this.getRequest().setAttribute("page_s",ps);
		return "page_sSuccess";
	}
}
