package com.atfuture.service;

import java.util.List;

import com.atfuture.domain.Specialty;
import com.future.utils.Page_S;

public interface SpecialtyService  {
	Specialty getSpecialty(int id);
	List<Specialty> findByName(String name);
	Page_S page_s(Page_S ps);
	void addSpecialty(Specialty unit);
	void changeSpecialty(Specialty unit);
	boolean checkExist(String name);
	public List<Specialty> getAllSpecialty();
}
