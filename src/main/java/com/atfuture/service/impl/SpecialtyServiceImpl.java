package com.atfuture.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.SpecialtyDao;
import com.atfuture.domain.Specialty;
import com.atfuture.service.SpecialtyService;
import com.future.utils.Page_S;

@Service
public class SpecialtyServiceImpl  implements SpecialtyService  {

	@Resource
	private SpecialtyDao specialtyDao;
	
	public Specialty getSpecialty(int id) {
		return specialtyDao.getSpecialty(id);
		
	}

	public List<Specialty> findByName(String name) {
		// TODO Auto-generated method stub
		return specialtyDao.findByName(name);
	}

	public Page_S page_s(Page_S ps) {
		// TODO Auto-generated method stub
		return specialtyDao.page_s(ps);
	}

	public void addSpecialty(Specialty jt) {
		specialtyDao.addSpecialty(jt);
		
	}

	public void changeSpecialty(Specialty jt) {
		specialtyDao.changeSpecialty(jt);
		
	}

	public boolean checkExist(String name) {
		return specialtyDao.checkExist(name);
	}
	public List<Specialty> getAllSpecialty() {
		String sql = "from Specialty";
		return specialtyDao.findEntityByHQL(sql);
	}
}
