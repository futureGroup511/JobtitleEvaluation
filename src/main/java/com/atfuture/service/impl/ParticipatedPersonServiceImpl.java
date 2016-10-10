package com.atfuture.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.ParticipatedPersonDao;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.Statistics;
import com.atfuture.service.ParticipatedPersonService;
import com.atfuture.utils.Page_S;

@Service
public class ParticipatedPersonServiceImpl  implements ParticipatedPersonService{

	@Resource
	private ParticipatedPersonDao participatedPersonDao;

	public Page_S findAllParticipatedPerson(Page_S p,Integer id) {
		return participatedPersonDao.findAllParticipatedPerson(p,id);
	}

	public ParticipatedPerson findById(Integer id) {
		return participatedPersonDao.findById(id);
	}
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

	public void deleteAll() {
		participatedPersonDao.deleteAll();
	}

	public List<Statistics> getParticipatedPersonByName(String participatedPerson) {
		return participatedPersonDao.getParticipatedPersonByName(participatedPerson);
	}

	public List<Statistics> getParticipatedPersonByNameAndPage(String participatedPerson, Page_S pageBean) {
		return participatedPersonDao.getParticipatedPersonByNameAndPage(participatedPerson, pageBean);
	}

}
