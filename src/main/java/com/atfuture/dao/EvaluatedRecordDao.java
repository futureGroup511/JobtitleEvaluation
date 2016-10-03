package com.atfuture.dao;

import java.util.List;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.EvaluatedRecord;

public interface EvaluatedRecordDao extends BaseDao<EvaluatedRecord>{

	
	public void save(EvaluatedRecord e);
	
	public List<Object[]> calculateGroupCountByPersonId(Integer id);



	
}
