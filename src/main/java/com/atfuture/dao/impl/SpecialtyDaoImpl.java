package com.atfuture.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.atfuture.dao.SpecialtyDao;
import com.atfuture.domain.Specialty;
import com.future.utils.Page_S;

@Repository
public class SpecialtyDaoImpl extends BaseDaoImpl<Specialty> implements SpecialtyDao  {

	public Specialty getSpecialtyById(int id) {
		return this.getEntity(id);
	}

	public List<Specialty> getAllSpecialty() {
		String hql="from Specialty";
		List<Specialty> allSpecialty=this.findEntityByHQL(hql);
		return allSpecialty;
	}

	public Page_S getByPage(Page_S page_s) {
		int currentPage=page_s.getCurrentPage();
		int pageSize=page_s.getPageSize();
		String hql="from Specialty";
		int startRow=pageSize*(currentPage-1);
		Query query=this.getsession().createQuery(hql);
		query.setFirstResult(startRow);
		query.setMaxResults(page_s.getPageSize());
		List recordList=query.list();
		hql="select count(s) from Specialty as s";
		Integer recordCount=(Integer)this.uniqueResult(hql);
		page_s=new Page_S(currentPage,pageSize,recordCount,recordList);
		return page_s;
	}

	public boolean addSpecialty(Specialty specialty) {
		this.saveEntity(specialty);
		return true;
	}

	public boolean changeSpecialty(Specialty specialty) {
		if(specialty.getSpec_id()==null){
			return false;
		}
		this.updateEntity(specialty);
		return true;
	}


	public List<Specialty> getSpecialtyByName(String name) {
		String hql="from Specialty where spec_name like %?%";
		return this.findEntityByHQL(hql, name);
	}

}
