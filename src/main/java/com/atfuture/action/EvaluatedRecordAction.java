package com.atfuture.action;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.Evaluate;
import com.atfuture.domain.EvaluatedRecord;
import com.atfuture.domain.Expert;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.Statistics;
@Controller
@Scope("prototype")
public class EvaluatedRecordAction extends BaseAction<EvaluatedRecord> {

	private Integer expert_id;
	private Integer person_id;
	
	
	
	public String finishAssess(){
		Expert expert=expertService.findById(expert_id);
		ParticipatedPerson participatedPerson=participatedPersonService.findById(person_id);
		EvaluatedRecord er=getModel();
		er.setEvalRecor_expart(expert);
		er.setEvalRecor_participatedPerson(participatedPerson);
		if(er.getEvalRecor_allAssessment().equals(Evaluate.EXCELLENT.getName())){
			er.setEvalRecor_allAssessment(Evaluate.EXCELLENT.getValue());
		}
		if(er.getEvalRecor_allAssessment().equals(Evaluate.GOOD.getName())){
			er.setEvalRecor_allAssessment(Evaluate.GOOD.getValue());		
			}
		if(er.getEvalRecor_allAssessment().equals(Evaluate.MEDIUM.getName())){
			er.setEvalRecor_allAssessment(Evaluate.MEDIUM.getValue());
		}
		if(er.getEvalRecor_allAssessment().equals(Evaluate.POOR.getName())){
			er.setEvalRecor_allAssessment(Evaluate.POOR.getValue());
		}
		evaluatedRecordService.save(er);
		//判断类型
		List<Object[]> result=evaluatedRecordService.calculateGroupCountByPersonId(person_id);
		Statistics statistics=statisticsService.findByPersonId(person_id);
		if(statistics==null){
			statistics=Statistics.newInstance();
		}
		Iterator<Object[]> iterator=result.iterator();
		while(iterator.hasNext()){
			Object[] objects=iterator.next();
			if(String.valueOf(objects[1]).equals("A")){
				statistics.setSta_AScored(Float.valueOf(objects[0].toString()));
			}
			if(String.valueOf(objects[1]).equals("B")){
				statistics.setSta_BScored(Float.valueOf(objects[0].toString()));
						}
			if(String.valueOf(objects[1]).equals("C")){
				statistics.setSta_CScored(Float.valueOf(objects[0].toString()));
			}
		}
		statistics.calculate();
		statisticsService.saveOrUpdate(statistics);
		return "finishAssess";
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
	
	
	
	
	
}
