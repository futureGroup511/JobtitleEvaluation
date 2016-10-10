package com.atfuture.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.Specialty;
import com.atfuture.domain.Statistics;
import com.atfuture.domain.Unit;
import com.atfuture.utils.Page_S;

@Controller
@Scope("prototype")
public class StatisticsAction extends BaseAction<Statistics> implements RequestAware{

	private Integer currentPage;
	private Map<String, Object> requestMap;
	
	//统计记录
	public String statisticAll(){
		Integer recordCount = statisticsService.getAllStatistic().size();
		Integer pageSize = 2;
		if(currentPage == null || (currentPage+"").trim() == ""){
			currentPage = 1;
		}
		List<Statistics> recordList = null; 
		Page_S page = new Page_S(currentPage, pageSize, recordCount, null);
		recordList = statisticsService.getAllStatisticByPage(page);
		page.setRecordlist(recordList);
		requestMap.put("pageBean", page);
		return "ShowStatisticListPage";
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}
	
	//开始分类查看
	
	private Page_S page_s;
	private Unit unit;
	private Specialty specialty;
	
	
	public Page_S getPage_s() {
		return page_s;
	}

	public void setPage_s(Page_S page_s) {
		this.page_s = page_s;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	
	public String viewBySpecialty(){
		if(specialty==null||specialty.getSpec_id()==null){
			requestMap.put("chosedSpec_id",0);
		}else if(specialty.getSpec_id()>0){
			requestMap.put("chosedSpec_id",specialty.getSpec_id());
		}
		if(page_s==null){
			page_s=new Page_S();
			page_s.setCurrentPage(1);
		}
		page_s.setPageSize(2);
		requestMap.put("pageBean",this.statisticsService.getBySpecialty(page_s, specialty));
		requestMap.put("specialtyList", specialtyService.getAllSpecialty());
		return "viewBySpecialty";
	}
	
	public String viewByUnit(){
		if(unit==null||unit.getUni_id()==null){
			requestMap.put("chosedUni_id",0);
		}else if(unit.getUni_id()>=0){
			requestMap.put("chosedUni_id",unit.getUni_id());
		}
		if(page_s==null){
			page_s=new Page_S();
			page_s.setCurrentPage(1);
		}
		page_s.setPageSize(2);
		requestMap.put("pageBean",this.statisticsService.getByUnit(page_s, unit));
		requestMap.put("unitList", unitService.getAllUnit());
		return "viewByUnit";
	}
	//分类查看结束
}
