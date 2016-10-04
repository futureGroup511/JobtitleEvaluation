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

	public Unit getUnit(int id) {
		return unitDao.getUnit(id);
		
	}

	public List<Unit> findByName(String name) {
		// TODO Auto-generated method stub
		return unitDao.findByName(name);
	}

	public Page_S page_s(Page_S ps) {
		// TODO Auto-generated method stub
		return unitDao.page_s(ps);
	}

	public void addUnit(Unit jt) {
		unitDao.addUnit(jt);
		
	}

	public void changeUnit(Unit jt) {
		unitDao.changeUnit(jt);
		
	}

	public boolean checkExist(String name) {
		return unitDao.checkExist(name);
	}
	public List<Unit> getAllUnit() {
		String sql = "from Unit";
		return unitDao.findEntityByHQL(sql);
	}
}
