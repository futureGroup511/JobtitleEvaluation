package com.atfuture.dao;

import java.util.List;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.JobTitle;
import com.atfuture.utils.Page_S;

public interface JobTitleDao extends BaseDao<JobTitle>{
	JobTitle getJobTitle(int id);
	List<JobTitle> findByName(String name);
	Page_S page_s(Page_S ps);
	void addJobTitle(JobTitle jt);
	void changeJobTitle(JobTitle jt);
	boolean checkExist(String name);
}
