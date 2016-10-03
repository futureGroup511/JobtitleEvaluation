package com.atfuture.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.atfuture.dao.ParticipatedPersonDao;
import com.atfuture.domain.ParticipatedPerson;
import com.future.utils.Page_S;

@Repository
public class ParticipatedPersonDaoImpl extends BaseDaoImpl<ParticipatedPerson> implements ParticipatedPersonDao{

	public Page_S findAllParticipatedPerson(Page_S p,Integer id) {
		/*Criteria criteria=getSession().createCriteria(ParticipatedPerson.class);
		Integer num=((Long)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(null);
		criteria.setFirstResult(p.getPageSize()*(p.getCurrentPage()-1));
		criteria.setMaxResults(p.getPageSize());
		List<ParticipatedPerson> persons=criteria.list(); 
		Page_S result=new Page_S(p.getCurrentPage(), p.getPageSize(), num, persons);*/
		String hql="select * from participateperson p join evaluaterecord e join expert ex where p.parti_id<>e.evalRecor_participatedPerson_parti_id and e.evalRecor_expart_exp_id<>?";
		
		Query query=getSession().createSQLQuery(hql).setParameter(0, id);
		List list = query.list(); 
		Integer num=((Integer) list.get(0)).intValue();
		getSession().flush();
		List<ParticipatedPerson> persons=query.setFirstResult(p.getPageSize()*(p.getCurrentPage()-1)).setMaxResults(p.getPageSize()).list();
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

}
