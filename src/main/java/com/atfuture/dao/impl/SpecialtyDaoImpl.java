package com.atfuture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.atfuture.dao.SpecialtyDao;
import com.atfuture.domain.Specialty;
import com.future.utils.Page_S;

@Repository
public class SpecialtyDaoImpl extends BaseDaoImpl<Specialty> implements SpecialtyDao  {

public Specialty getSpecialty(int id) {
		
		return this.getEntity(id);
	}

	public List<Specialty> findByName(String name) {
		// TODO Auto-generated method stub
		String hql="from Specialty where spec_name like '%"+name+"%'";
		return this.findEntityByHQL(hql);
	}

	public Page_S page_s(Page_S page_s) {
		// TODO Auto-generated method stub
		int currentPage=page_s.getCurrentPage();
		int pageSize=page_s.getPageSize();
		String sql="select * from specialty limit ?,?";
		int startRow=pageSize*(currentPage-1);
		List<Specialty> recordList=this.executeSQLQuery(Specialty.class, sql, startRow,pageSize);
		String hql="select count(*) from Specialty";
		int recordCount=((Long) this.uniqueResult(hql)).intValue();
		page_s=new Page_S(currentPage,pageSize,recordCount,recordList);
		return page_s;
	}

	public void addSpecialty(Specialty jt) {
		this.saveEntity(jt);
	}

	public void changeSpecialty(Specialty jt) {
		this.updateEntity(jt);
	}

	public boolean checkExist(String name) {
		String hql="select count(*) from Specialty where spec_name = ?";
		int recordCount=((Long) this.uniqueResult(hql,name)).intValue();
		if(recordCount>0){
			return true;
		}else{
			return false;
		}
	}

}
