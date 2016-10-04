package com.atfuture.service;

import java.util.List;

import com.atfuture.domain.Unit;
import com.future.utils.Page_S;

public interface UnitService {
	Unit getUnit(int id);
	List<Unit> findByName(String name);
	Page_S page_s(Page_S ps);
	void addUnit(Unit unit);
	void changeUnit(Unit unit);
	boolean checkExist(String name);
	List<Unit> getAllUnit();
	
}
