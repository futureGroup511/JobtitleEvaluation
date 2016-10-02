package com.atfuture.service;

import java.util.List;

import com.atfuture.domain.EvaluatedRecord;

public interface EvaluatedRecordService  {

	
	//添加
	public void save(EvaluatedRecord e);
	//计算不同类别的分数
	public List<Object[]> calculateGroupCountByPersonId(Integer id);
}
