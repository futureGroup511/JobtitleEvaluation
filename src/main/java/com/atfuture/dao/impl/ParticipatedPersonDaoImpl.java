package com.atfuture.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.atfuture.dao.ParticipatedPersonDao;
import com.atfuture.domain.ParticipatedPerson;
import com.future.utils.Page_S;

@Repository
public class ParticipatedPersonDaoImpl extends BaseDaoImpl<ParticipatedPerson> implements ParticipatedPersonDao{

	public Page_S findAllParticipatedPerson(Page_S p) {
		Criteria criteria=getSession().createCriteria(ParticipatedPerson.class);
		Integer num=((Long)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(null);
		criteria.setFirstResult(p.getPageSize()*(p.getCurrentPage()-1));
		criteria.setMaxResults(p.getPageSize());
		List<ParticipatedPerson> persons=criteria.list(); 
		Page_S result=new Page_S(p.getCurrentPage(), p.getPageSize(), num, persons);
		return result;
	}

}
