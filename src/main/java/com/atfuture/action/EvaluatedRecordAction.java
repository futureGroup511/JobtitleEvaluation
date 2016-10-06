package com.atfuture.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.EvaluatedRecord;
import com.atfuture.domain.Expert;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.Statistics;
import com.future.utils.Page_S;
@Controller
@Scope("prototype")
public class EvaluatedRecordAction extends BaseAction<EvaluatedRecord> implements RequestAware,SessionAware{

	private Integer currentPage;
	private Map<String, Object> requestMap;
	
	private Integer expert_id;
	private Integer person_id;
	
	
	public String finishAssess(){
		Expert expert=(Expert) session.get("role");
		ParticipatedPerson participatedPerson=participatedPersonService.findById(person_id);
		EvaluatedRecord er=getModel();
		er.setEvalRecor_expart(expert);
		er.setEvalRecor_participatedPerson(participatedPerson);
		er.changeAssessment();//综合评价为分值
		evaluatedRecordService.save(er);
		//判断类型
		List<Object[]> result=evaluatedRecordService.calculateGroupCountByPersonId(person_id);
		Statistics statistics=statisticsService.findByPersonId(person_id);
		if(statistics==null){
			statistics=Statistics.newInstance();
		}
		statistics.setSta_participatedPerson(participatedPerson);
		statistics.setScoredByTypes(result);//根据类型设置统计类的分值,并计算总分值
		statisticsService.saveOrUpdate(statistics);
		return "finishAssess";
	}

	//查询指定专家的评估记录
		private Integer exp_id = 1;
		public String statisticByExpert(){
			Integer recordCount = evaluatedRecordService.getAllStatisticByExpert(exp_id).size();
			Integer pageSize = 2;
			if(currentPage == null || (currentPage+"").trim() == ""){
				currentPage = 1;
			}
			List<EvaluatedRecord> recordList = null; 
			Page_S page = new Page_S(currentPage, pageSize, recordCount, null);
			recordList = evaluatedRecordService.getAllStatisticByPageAndExpert(page, exp_id);
			page.setRecordlist(recordList);
			requestMap.put("pageBean", page);
			return "ShowRecordByExpert";
		}

	public Integer getExpert_id() {
		return expert_id;
	}
	public void setExpert_id(Integer expert_id) {
		this.expert_id = expert_id;
	}
	public Integer getPerson_id() {
		return person_id;
	}
	public void setPerson_id(Integer person_id) {
		this.person_id = person_id;
	}



	public Integer getExp_id() {
		return exp_id;
	}



	public void setExp_id(Integer exp_id) {
		this.exp_id = exp_id;
	}



	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}


	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> arg0) {
		session=arg0;
	}
	
	
	
	
	
}
