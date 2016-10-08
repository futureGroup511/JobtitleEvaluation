package com.atfuture.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.atfuture.dao.JobTitleDao;
import com.atfuture.domain.JobTitle;
import com.atfuture.utils.Page_S;

@Repository
public class JobTitleDaoImpl extends BaseDaoImpl<JobTitle> implements JobTitleDao{

	public JobTitle getJobTitle(int id) {
		
		return this.getEntity(id);
	}

	public List<JobTitle> findByName(String name) {
		// TODO Auto-generated method stub
		String hql="from JobTitle where jobTi_name like '%"+name+"%'";
		return this.findEntityByHQL(hql);
	}

	public Page_S page_s(Page_S page_s) {
		// TODO Auto-generated method stub
		int currentPage=page_s.getCurrentPage();
		int pageSize=page_s.getPageSize();
		String sql="select * from jobtitle limit ?,?";
		int startRow=pageSize*(currentPage-1);
		List<JobTitle> recordList=this.executeSQLQuery(JobTitle.class, sql, startRow,pageSize);
		String hql="select count(*) from JobTitle";
		int recordCount=((Long) this.uniqueResult(hql)).intValue();
		page_s=new Page_S(currentPage,pageSize,recordCount,recordList);
		return page_s;
	}

	public void addJobTitle(JobTitle jt) {
		this.saveEntity(jt);
	}

	public void changeJobTitle(JobTitle jt) {
		this.updateEntity(jt);
	}

	public boolean checkExist(String name) {
		String hql="select count(*) from JobTitle where jobTi_name = ?";
		int recordCount=((Long) this.uniqueResult(hql,name)).intValue();
		if(recordCount>0){
			return true;
		}else{
			return false;
		}
	}
}
