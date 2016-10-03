package com.atfuture.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.Statistics;
import com.future.utils.Page_S;

@Controller
@Scope("prototype")
public class StatisticsAction extends BaseAction<Statistics>{

	private Integer currentPage;

	//统计记录
	public String statisticAll(){
		
		return null;
	}
	
	//查询所有的专家
	public String statisticByExpert(){
		
		return null;
	}
	
	//查询指定专家的记录情况
	public String statisticSpecialExpert(){
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
}
