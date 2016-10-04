package com.atfuture.dao;

import java.util.List;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.Statistics;
import com.future.utils.Page_S;

public interface StatisticsDao extends BaseDao<Statistics>{

	public Statistics findByPersonId(Integer id);
	
	//添加或更新
	public void saveOrUpdate(Statistics s);
	
	//分页查询得到统计结果
	public List<Statistics> getAllStatisticByPage(Page_S page);
}
