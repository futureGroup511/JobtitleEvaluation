package com.atfuture.dao;

import java.util.List;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.Specialty;
import com.atfuture.utils.Page_S;

public interface SpecialtyDao  extends BaseDao<Specialty>{
	Specialty getSpecialty(int id);
	List<Specialty> findByName(String name);
	Page_S page_s(Page_S ps);
	void addSpecialty(Specialty jt);
	void changeSpecialty(Specialty jt);
	boolean checkExist(String name);

}
