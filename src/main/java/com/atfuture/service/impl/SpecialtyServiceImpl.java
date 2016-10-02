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
	
	public void add(Specialty specialty) {
		specialtyDao.addSpecialty(specialty);
		
	}

	public Page_S page_s(Page_S page_s) {
		return specialtyDao.getByPage(page_s);
	}

	public void change(Specialty s) {
		specialtyDao.changeSpecialty(s);
		
	}

	public List<Specialty> findByName(String name) {
		return specialtyDao.getSpecialtyByName(name);
	}

	public Specialty getById(int id) {
		return specialtyDao.getSpecialtyById(id);
	}
	
}
