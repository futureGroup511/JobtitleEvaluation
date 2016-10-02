package com.atfuture.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.atfuture.dao.JobTitleDao;
import com.atfuture.domain.JobTitle;
import com.future.utils.Page_S;

@Repository
public class JobTitleDaoImpl extends BaseDaoImpl<JobTitle> implements JobTitleDao{

	public JobTitle getJobTitle(int id) {
		return this.getEntity(id);
	}

	public List<JobTitle> findByName(String name) {
		// TODO Auto-generated method stub
		String hql="from JobTitle where jobTi_name like %?%";
		return this.findEntityByHQL(hql, name);
	}

	public Page_S page_s(Page_S page_s) {
		// TODO Auto-generated method stub
		int currentPage=page_s.getCurrentPage();
		int pageSize=page_s.getPageSize();
		String hql="from JobTitle";
		int startRow=pageSize*(currentPage-1);
		Query query=this.getsession().createQuery(hql);
		query.setFirstResult(startRow);
		query.setMaxResults(page_s.getPageSize());
		List recordList=query.list();
		hql="select count(s) from JobTitle as s";
		Integer recordCount=(Integer)this.uniqueResult(hql);
		page_s=new Page_S(currentPage,pageSize,recordCount,recordList);
		return page_s;
	}

	public void addJobTitle(JobTitle jt) {
		this.saveEntity(jt);
	}

	public void changeJobTitle(JobTitle jt) {
		this.updateEntity(jt);
	}


}
