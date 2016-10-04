package com.atfuture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.atfuture.dao.StatisticsDao;
import com.atfuture.domain.Statistics;
import com.future.utils.Page_S;

@Repository
public class StatisticsDaoImpl extends BaseDaoImpl<Statistics> implements StatisticsDao {

	public Statistics findByPersonId(Integer id) {
		String hql="from Statistics s where s.sta_participatedPerson.parti_id=?";
		Statistics result=(Statistics) getSession().createQuery(hql).setParameter(0, id).uniqueResult();
		return result;
	}

	public void saveOrUpdate(Statistics s) {
		saveOrUpdateEntity(s);
	}

	public List<Statistics> getAllStatisticByPage(Page_S page) {
		String sql = "from Statistics";
		@SuppressWarnings("unchecked")
		List<Statistics> statisticList = getSession().createQuery(sql).setFirstResult((page.getCurrentPage()-1)*page.getPageSize())
														.setMaxResults(page.getPageSize())
															.list();
		return statisticList;
	}

}
