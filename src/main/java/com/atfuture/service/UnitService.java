package com.atfuture.service;

import java.util.List;

import com.atfuture.domain.Unit;
import com.future.utils.Page_S;

public interface UnitService {
	Unit getById(int id);
	void add(Unit unit);
	void change(Unit unit);
	List<Unit> findByName(String name);
	Page_S page_s(Page_S ps);
}
