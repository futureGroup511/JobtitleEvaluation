package com.atfuture.dao;

import java.util.List;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.Unit;
import com.future.utils.Page_S;
import com.future.utils.Page_S;

public interface UnitDao extends BaseDao<Unit>{
	Unit getById(int id);
	void add(Unit unit);
	void change(Unit unit);
	List<Unit> findByName(String name);
	Page_S page_s(Page_S ps);
}
