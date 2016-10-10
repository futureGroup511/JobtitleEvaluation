package com.atfuture.service;

import java.util.List;
import java.util.Map;

import com.atfuture.domain.EvaluatedRecord;
import com.atfuture.utils.Page_S;

public interface EvaluatedRecordService  {

	
	//添加
	public void save(EvaluatedRecord e);
	//计算不同类别的分数
	public List<Object[]> calculateGroupCountByPersonId(Integer id);
	
	public List<EvaluatedRecord> getAllStatisticByExpert(Integer exp_id);

	public List<EvaluatedRecord> getAllStatisticByPageAndExpert(Page_S page, Integer exp_id);
	//分页得到当前条件下的列表记录
	public List<EvaluatedRecord> getRecordByCondition(Integer participatedId, String familiarStatus,
			String evalRecor_allAssessment, Page_S pageBean);
	
	
	//得到记录的条数 为分页准备条件
	public List<EvaluatedRecord> getRecordByCondition(Integer participatedId, String familiarStatus,
			String evalRecor_allAssessment);
	//得到指定参评人被参评 的  专家评分为ABCD的 人数  返回 map  键为 A  B   C  D
	public Map<String, Integer> getExpertNumForSpec(Integer participatedId); 
	
}
