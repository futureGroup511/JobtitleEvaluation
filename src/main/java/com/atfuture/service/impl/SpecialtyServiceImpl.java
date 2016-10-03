package com.atfuture.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.SpecialtyDao;
import com.atfuture.domain.Specialty;
import com.atfuture.service.SpecialtyService;

@Service
public class SpecialtyServiceImpl  implements SpecialtyService  {

	@Resource
	private SpecialtyDao specialtyDao;

	public List<Specialty> getAllSpecialty() {
		String sql = "from Specialty";
		return specialtyDao.findEntityByHQL(sql);
	}
}
