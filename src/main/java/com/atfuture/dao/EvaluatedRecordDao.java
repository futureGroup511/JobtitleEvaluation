package com.atfuture.dao;

import java.util.List;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.EvaluatedRecord;
import com.atfuture.utils.Page_S;

public interface EvaluatedRecordDao extends BaseDao<EvaluatedRecord>{

	
	public void save(EvaluatedRecord e);
	
	public List<Object[]> calculateGroupCountByPersonId(Integer id);
	//评估记录 分页并按 指定专家进行查询
	public List<EvaluatedRecord> getAllStatisticByPageAndExpert(Page_S page, Integer exp_id);



	
}
