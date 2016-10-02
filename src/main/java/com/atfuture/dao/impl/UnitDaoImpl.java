package com.atfuture.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.atfuture.dao.UnitDao;
import com.atfuture.domain.Unit;
import com.future.utils.Page_S;

@Repository
public class UnitDaoImpl extends BaseDaoImpl<Unit> implements UnitDao {

	public Unit getById(int id) {
		return this.getEntity(id);
	}

	public void add(Unit unit) {
		this.saveEntity(unit);
	}

	public void change(Unit unit) {
		this.updateEntity(unit);
	}

	public List<Unit> findByName(String name) {
		String hql="from Unit where uni_name like %?%";
		return this.findEntityByHQL(hql, name);
	}

	public Page_S page_s(Page_S page_s) {
		int currentPage=page_s.getCurrentPage();
		int pageSize=page_s.getPageSize();
		String hql="from Unit";
		int startRow=pageSize*(currentPage-1);
		Query query=this.getsession().createQuery(hql);
		query.setFirstResult(startRow);
		query.setMaxResults(page_s.getPageSize());
		List recordList=query.list();
		hql="select count(s) from Unit as s";
		Integer recordCount=(Integer)this.uniqueResult(hql);
		page_s=new Page_S(currentPage,pageSize,recordCount,recordList);
		return page_s;
	}

}
