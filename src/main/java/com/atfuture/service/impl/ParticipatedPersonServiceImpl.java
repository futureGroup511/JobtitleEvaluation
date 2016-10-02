package com.atfuture.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.ParticipatedPersonDao;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.service.ParticipatedPersonService;
import com.future.utils.Page_S;

@Service
public class ParticipatedPersonServiceImpl  implements ParticipatedPersonService{

	@Resource
	private ParticipatedPersonDao participatedPersonDao;

	public Page_S findAllParticipatedPerson(Page_S p) {
		return participatedPersonDao.findAllParticipatedPerson(p);
	}

	public ParticipatedPerson findById(Integer id) {
		return participatedPersonDao.findById(id);
	}
}
