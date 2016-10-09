package com.atfuture.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.StatisticsDao;
import com.atfuture.domain.Specialty;
import com.atfuture.domain.Statistics;
import com.atfuture.domain.Unit;
import com.atfuture.service.StatisticsService;
import com.atfuture.utils.Page_S;
@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Resource
	private StatisticsDao statisticsDao;

	public Statistics findByPersonId(Integer id) {
		return statisticsDao.findByPersonId(id);
	}

	public void saveOrUpdate(Statistics s) {
		statisticsDao.saveOrUpdate(s);
	}

	public List<Statistics> getAllStatisticByPage(Page_S page) {
		return statisticsDao.getAllStatisticByPage(page);
	}

	public List<Statistics> getAllStatistic() {
		String sql = "from Statistics";
		return statisticsDao.findEntityByHQL(sql);
	}

	public Page_S getBySpecialty(Page_S page_s,Specialty s) {
		return statisticsDao.getBySpecialty(page_s, s);
	}

	public Page_S getByUnit(Page_S page_s,Unit u) {
		return statisticsDao.getByUnit(page_s, u);
	}

	


}
