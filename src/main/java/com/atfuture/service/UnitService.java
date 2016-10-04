package com.atfuture.service;

import java.util.List;

import com.atfuture.domain.Unit;
<<<<<<< HEAD
import com.future.utils.Page_S;

public interface UnitService {
	Unit getUnit(int id);
	List<Unit> findByName(String name);
	Page_S page_s(Page_S ps);
	void addUnit(Unit unit);
	void changeUnit(Unit unit);
	boolean checkExist(String name);
=======

public interface UnitService {

	
	public List<Unit> getAllUnit();
>>>>>>> fbda4f3b4a8a2c8ca47608a572d219af9c6e6541
}
