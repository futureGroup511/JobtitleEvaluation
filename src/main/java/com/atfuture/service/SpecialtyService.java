package com.atfuture.service;

import java.util.List;

import com.atfuture.domain.Specialty;
import com.future.utils.Page_S;

public interface SpecialtyService  {
	Specialty getById(int id);
	void add(Specialty specialty);//添加专业
	Page_S page_s(Page_S page_s);//分页
	void change(Specialty s);//修改专业信息
	List<Specialty> findByName(String name);//根据名字查找专业
}
