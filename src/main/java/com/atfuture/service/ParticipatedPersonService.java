package com.atfuture.service;

import com.atfuture.domain.ParticipatedPerson;
import com.future.utils.Page_S;

public interface ParticipatedPersonService {

	//分页查询所有评教人员
		public Page_S findAllParticipatedPerson(Page_S p);
	//通过id查找
		public ParticipatedPerson findById(Integer id);
}
