package com.atfuture.action;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
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
	
	public String execute(){
		return SUCCESS;
	}
	
	public String get(){
		Unit u=unitService.getById(unit.getUni_id());
		ActionContext ac=ActionContext.getContext();
		Map<String,Object> request=(Map)ac.get("request");
		request.put("unit", u);
		return "getSuccess";
	}
	
	public String add(){
		unitService.add(unit);
		return "addSuccess";
	}
	
	public String change(){
		unitService.change(unit);
		return "changeSuccess";
	}
	
	public String findByName(){
		List<Unit> findResults=unitService.findByName(unit.getUni_name());
		ActionContext ac=ActionContext.getContext();
		Map<String,Object> request=(Map)ac.get("request");
		request.put("findResults", findResults);
		return "findSuccess";
	}
	
	public String page_s(){
		Page_S ps=unitService.page_s(page_s);
		ActionContext ac=ActionContext.getContext();
		Map<String,Object> request=(Map)ac.get("request");
		request.put("page_s", ps);
		return "page_sSuccess";
	}
}
