package com.atfuture.service;

import java.util.List;

import com.atfuture.domain.EvaluatedRecord;
import com.atfuture.domain.EvaluatedStandard;
import com.atfuture.domain.Statistics;
import com.atfuture.utils.Page_S;

public interface EvaluatedRecordService  {

	
	//添加
	public void save(EvaluatedRecord e);
	//计算不同类别的分数
	public List<Object[]> calculateGroupCountByPersonId(Integer id);
	
	public List<EvaluatedRecord> getAllStatisticByExpert(Integer exp_id);

	public List<EvaluatedRecord> getAllStatisticByPageAndExpert(Page_S page, Integer exp_id); 
	
}
