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
import com.atfuture.domain.TypeNumber;
import com.atfuture.utils.Page_S;
@Controller
@Scope("prototype")
public class EvaluatedRecordAction extends BaseAction<EvaluatedRecord> implements RequestAware,SessionAware{

	private Integer currentPage=1;
	private Map<String, Object> requestMap;
	private Expert expert=Expert.newInstance();
	private Integer expert_id;
	private Integer person_id;
	private Map<String, Object> session;
	
	public String finishAssess(){
		Expert expert=(Expert) session.get("role");
		ParticipatedPerson participatedPerson=participatedPersonService.findById(person_id);
		EvaluatedRecord er=getModel();
		er.setEvalRecor_expart(expert);
		er.setEvalRecor_participatedPerson(participatedPerson);
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

	public String statisticByExpert(){
	//查询指定专家的评估记录
			Integer expId=((Expert)session.get("role")).getExp_id();
			Integer recordCount = evaluatedRecordService.getAllStatisticByExpert(expId).size();
			Integer pageSize = 8;
			if(currentPage == null || (currentPage+"").trim() == ""){
				currentPage = 1;
			}
			List<EvaluatedRecord> recordList = null; 
			Page_S page = new Page_S(currentPage, pageSize, recordCount, null);
			Integer id = ((Expert)session.get("role")).getExp_id();
			System.out.println("=========>>>"+id);
			System.out.println("===========>>"+currentPage);
			recordList = evaluatedRecordService.getAllStatisticByPageAndExpert(page, expId);
			setStatisticsByExpertId(expId);
			setTypeNumbersByExpertId(expId);
			page.setRecordlist(recordList);
			requestMap.put("pageBean", page);
			return "ShowRecordByExpert";
		}
	/**
	 * 得到所有审评记录
	 * @return
	 */
	public String findAllRecord(){
		Page_S page=Page_S.getDefaultInstace();
		page.setCurrentPage(currentPage);
		Page_S data=evaluatedRecordService.findAllRecord(page);
		requestMap.put("pageBean", data);
		return "findAllRecord";
	}
	
	public String FindByExpertNameOrAllassessment(){
		Page_S page=Page_S.getDefaultInstace();
		page.setCurrentPage(currentPage);
		String name=expert.getExp_name();
		Expert ex=expertService.findByname(name);
		Page_S data=null;
		if(ex==null){
			data=Page_S.newInstance();
			requestMap.put("pageBean", data);
			return "toFindAllRecord";
		}
		data=evaluatedRecordService.FindByExpertName(name, page);
		setTypeNumbersByExpertId(ex.getExp_id());
		setStatisticsByExpertId(ex.getExp_id());
		requestMap.put("pageBean", data);
		requestMap.put("expert", ex);
		return "fuzzyQuery";
	}
	
	
	
	
	public String  FindByExpertUnitOrSpecialty(){
		Page_S page=Page_S.getDefaultInstace();
		page.setCurrentPage(currentPage);
		List<ParticipatedPerson> persons=participatedPersonService.findByExpertUnitAndSpecialt(expert.getExp_unit(), expert.getExp_specialty());
		if(!(expert.getExp_unit()==null&&expert.getExp_specialty()==null)){
			if(expert.getExp_unit()==null) requestMap.put("choose","specialty");
			if(expert.getExp_specialty()==null)requestMap.put("choose","unit");
			if(expert.getExp_unit()!=null&&expert.getExp_specialty()!=null)requestMap.put("choose","all");
		}
		Page_S data=evaluatedRecordService.findByExpertUnitAndSpecialtyAndAllassessment(expert, page,persons,getModel().getEvalRecor_allAssessment());
		setTypeNumbersByExpertId(expert.getExp_id());
		setStatisticsByExpertId(expert.getExp_id());
		Expert ex=expertService.findById(expert.getExp_id());
		requestMap.put("allAssessment", getModel().getEvalRecor_allAssessment());
		requestMap.put("expert", ex);
		requestMap.put("pageBean", data);
		return "FindByExpertUnitOrSpecialty";
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

	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}

	public void setSession(Map<String, Object> arg0) {
		session=arg0;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Expert getExpert() {
		return expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	public void setStatisticsByExpertId(Integer id){
		List<Object[]> result=evaluatedRecordService.calculateGroupCountByExpertId(id);
		Statistics statistics=Statistics.newInstance();
		statistics.setScoredByTypes(result);
		requestMap.put("statistics", statistics);
	}
	
	public void setTypeNumbersByExpertId(Integer id){
		List<TypeNumber> numresult=evaluatedRecordService.getAssessmentCountByExpertId(id);
		requestMap.put("typeNumbers", numresult);
		
	}
	
	
	
	
	
}
