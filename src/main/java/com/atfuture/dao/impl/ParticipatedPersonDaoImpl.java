package com.atfuture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.atfuture.dao.ParticipatedPersonDao;
import com.atfuture.domain.ParticipatedPerson;
import com.future.utils.Page_S;

@Repository
public class ParticipatedPersonDaoImpl extends BaseDaoImpl<ParticipatedPerson> implements ParticipatedPersonDao{

	public Page_S findAllParticipatedPerson(Page_S p) {
		String hql="from ParticipatedPerson p";
		//List<ParticipatedPerson> persons=getsession().createQuery(hql).setFirstResult(arg0) 
		return null;
	}

	public List<ParticipatedPerson> getParticipatedPersonByPage(Page_S page) {
		String sql = "from ParticipatedPerson";
		@SuppressWarnings("unchecked")
		List<ParticipatedPerson> list = getsession().createQuery(sql).setFirstResult((page.getCurrentPage()-1)*page.getPageSize())
										.setMaxResults(page.getPageSize())
											.list();
		return list;
	}

}
