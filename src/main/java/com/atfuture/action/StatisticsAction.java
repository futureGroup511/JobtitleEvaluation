package com.atfuture.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.Statistics;
import com.future.utils.Page_S;

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
}
