package com.atfuture.dao;

import java.util.List;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.Specialty;
import com.atfuture.domain.Statistics;
import com.atfuture.domain.Unit;
import com.atfuture.utils.Page_S;

public interface StatisticsDao extends BaseDao<Statistics>{

	public Statistics findByPersonId(Integer id);
	
	//添加或更新
	public void saveOrUpdate(Statistics s);
	
	//分页查询得到统计结果
	public List<Statistics> getAllStatisticByPage(Page_S page);
	
	//根据专业获取数据
	Page_S getBySpecialty(Page_S page_s,Specialty s);
	//根据单位获取数据
	Page_S getByUnit(Page_S page_s,Unit u);
}
