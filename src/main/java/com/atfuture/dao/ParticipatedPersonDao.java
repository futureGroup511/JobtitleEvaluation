package com.atfuture.dao;

import java.util.List;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.ParticipatedPerson;
import com.future.utils.Page_S;

public interface ParticipatedPersonDao extends BaseDao<ParticipatedPerson>{

	
	public Page_S findAllParticipatedPerson(Page_S p);
	
	public List<ParticipatedPerson> getParticipatedPersonByPage(Page_S page);
}
