package com.atfuture.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.atfuture.dao.ParticipatedPersonDao;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.Statistics;
import com.atfuture.utils.Page_S;

@Repository
public class ParticipatedPersonDaoImpl extends BaseDaoImpl<ParticipatedPerson> implements ParticipatedPersonDao{

	public Page_S findAllParticipatedPerson(Page_S p,Integer id) {
		String hql="select count(*) from participateperson p where p.parti_id not in(select e.evalRecor_participatedPerson_parti_id from evaluaterecord e where e.evalRecor_expart_exp_id =?) ";
		Query query=getSession().createSQLQuery(hql).setParameter(0, id);
		List list = query.list(); 
		Integer num=Integer.valueOf(String.valueOf(list.get(0)));
		getSession().flush();
		String hq2="select  * from participateperson p where p.parti_id not in(select e.evalRecor_participatedPerson_parti_id from evaluaterecord e where e.evalRecor_expart_exp_id =?) order by parti_jobTitle_jobTi_id";
		List<ParticipatedPerson> persons=getSession().createSQLQuery(hq2).addEntity(ParticipatedPerson.class).setParameter(0, id).setFirstResult(p.getPageSize()*(p.getCurrentPage()-1)).setMaxResults(p.getPageSize()).list();
		Page_S result=new Page_S(p.getCurrentPage(), p.getPageSize(), num, persons);
		return result;
	}

	public ParticipatedPerson findById(Integer id) {
		return getEntity(id);
	}

	public List<ParticipatedPerson> getParticipatedPersonByPage(Page_S page) {
		String sql = "from ParticipatedPerson";
		@SuppressWarnings("unchecked")
		List<ParticipatedPerson> list = getSession().createQuery(sql).setFirstResult((page.getCurrentPage()-1)*page.getPageSize())
										.setMaxResults(page.getPageSize())
											.list();
		return list;
	}

	public void deleteAll() {
		String sql="delete from participateperson";
		executeSQL(sql);
	}

	public List<Statistics> getParticipatedPersonByName(String participatedPerson) {
		String sql = "from Statistics statistic where statistic.sta_participatedPerson.parti_name like '%"+participatedPerson+"%'";
		List<Statistics> statisticList = getSession().createQuery(sql).list();
		return statisticList;
	}

	public List<Statistics> getParticipatedPersonByNameAndPage(String participatedPerson, Page_S pageBean) {
		String sql = "from Statistics statistic where 1=1 and statistic.sta_participatedPerson.parti_name like '%"+participatedPerson+"%'";
		@SuppressWarnings("unchecked")
		List<Statistics> statisticList = getSession().createQuery(sql)
															.setFirstResult((pageBean.getCurrentPage()-1)*pageBean.getPageSize())
															.setMaxResults(pageBean.getPageSize())
															.list();
																				
		return statisticList;
	}

}
