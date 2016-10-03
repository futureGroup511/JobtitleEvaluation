package com.atfuture.service.impl;

import java.util.List;

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

	public List<ParticipatedPerson> getAllParticipatedPerson() {
		String sql = "from ParticipatedPerson";
		return participatedPersonDao.findEntityByHQL(sql);
	}

	public ParticipatedPerson getParticipatedPersonById(Integer id) {
		return participatedPersonDao.getEntity(id);
	}

	public List<ParticipatedPerson> getParticipatedPersonByPage(Page_S page) {
		return participatedPersonDao.getParticipatedPersonByPage(page);
	}

	public void addParticipatedPerson(ParticipatedPerson participatedPerson) {
		participatedPersonDao.saveEntity(participatedPerson);
	}
	
	public void updateParticipatedPerson(ParticipatedPerson participatedPerson){
		participatedPersonDao.updateEntity(participatedPerson);
	}

}
