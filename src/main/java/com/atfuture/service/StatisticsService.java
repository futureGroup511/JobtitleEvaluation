package com.atfuture.service;

import com.atfuture.domain.Statistics;

public interface StatisticsService {

	//根据参评人的ID查询统计结果
	public Statistics findByPersonId(Integer id);
	//添加或者更新
	public void saveOrUpdate(Statistics s);
}
