package com.atfuture.service;

import java.util.List;

import com.atfuture.domain.Statistics;
import com.future.utils.Page_S;

public interface StatisticsService {

	//根据参评人的ID查询统计结果
	public Statistics findByPersonId(Integer id);
	//添加或者更新
	public void saveOrUpdate(Statistics s);
	
	//得到所有的统计结果 分页查询
	public List<Statistics> getAllStatisticByPage(Page_S page);
	//得到所有的统计结果
	public List<Statistics> getAllStatistic();
	
}
