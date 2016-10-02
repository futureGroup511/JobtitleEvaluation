package com.atfuture.dao;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.Statistics;

public interface StatisticsDao extends BaseDao<Statistics>{

	public Statistics findByPersonId(Integer id);
	
	//添加或更新
	public void saveOrUpdate(Statistics s);
}
