package com.atfuture.dao.impl;

import org.springframework.stereotype.Repository;

import com.atfuture.dao.StatisticsDao;
import com.atfuture.domain.Statistics;

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

}
