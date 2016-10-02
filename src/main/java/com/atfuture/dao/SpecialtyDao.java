package com.atfuture.dao;

import java.util.List;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.Specialty;
import com.future.utils.Page_S;

public interface SpecialtyDao  extends BaseDao<Specialty>{
	
	//查询
	Specialty getSpecialtyById(int id);
	List<Specialty> getAllSpecialty();
	Page_S getByPage(Page_S page_s);
	List<Specialty> getSpecialtyByName(String name);
	
	//增加
	boolean addSpecialty(Specialty specialty);
	
	
	//修改
	boolean changeSpecialty(Specialty specialty);

}
