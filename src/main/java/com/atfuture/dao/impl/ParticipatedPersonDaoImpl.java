package com.atfuture.dao.impl;

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

}
