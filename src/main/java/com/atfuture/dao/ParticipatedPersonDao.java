package com.atfuture.dao;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.ParticipatedPerson;
import com.future.utils.Page_S;

public interface ParticipatedPersonDao extends BaseDao<ParticipatedPerson>{

	
	public Page_S findAllParticipatedPerson(Page_S p);
}
