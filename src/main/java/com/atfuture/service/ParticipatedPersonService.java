package com.atfuture.service;

import java.util.List;

import com.atfuture.domain.ParticipatedPerson;
import com.future.utils.Page_S;

public interface ParticipatedPersonService {

	
	//查询得到所有参评人
	public List<ParticipatedPerson> getAllParticipatedPerson();
	//查询得到指定参评人
	public ParticipatedPerson getParticipatedPersonById(Integer id);
	//分页查询得到参评人信息
	public List<ParticipatedPerson> getParticipatedPersonByPage(Page_S page);

}
