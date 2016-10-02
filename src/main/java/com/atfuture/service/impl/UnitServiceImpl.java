package com.atfuture.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.UnitDao;
import com.atfuture.domain.Unit;
import com.atfuture.service.UnitService;
import com.future.utils.Page_S;

@Service
public class UnitServiceImpl  implements UnitService {

	@Resource
	private UnitDao unitDao;

	public Unit getById(int id) {
		return unitDao.getById(id);
	}

	public void add(Unit unit) {
		// TODO Auto-generated method stub
		unitDao.add(unit);
		
	}

	public void change(Unit unit) {
		// TODO Auto-generated method stub
		unitDao.change(unit);
		
	}

	public List<Unit> findByName(String name) {
		// TODO Auto-generated method stub
		return unitDao.findByName(name);
	}

	public Page_S page_s(Page_S ps) {
		// TODO Auto-generated method stub
		return unitDao.page_s(ps);
	}
}
