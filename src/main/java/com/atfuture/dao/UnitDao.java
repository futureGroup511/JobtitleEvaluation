package com.atfuture.dao;

import java.util.List;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.Unit;
import com.future.utils.Page_S;

public interface UnitDao extends BaseDao<Unit>{
	Unit getUnit(int id);
	List<Unit> findByName(String name);
	Page_S page_s(Page_S ps);
	void addUnit(Unit jt);
	void changeUnit(Unit jt);
	boolean checkExist(String name);
}
