package com.atfuture.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.JobTitleDao;
import com.atfuture.domain.JobTitle;
import com.atfuture.service.JobTitleService;
import com.future.utils.Page_S;
@Service
public class JobTitleServiceImpl  implements JobTitleService{

	@Resource
	private JobTitleDao  jobTitleDao ;

	public JobTitle getJobTitle(int id) {
		jobTitleDao.getJobTitle(id);
		return null;
	}

	public List<JobTitle> findByName(String name) {
		// TODO Auto-generated method stub
		return jobTitleDao.findByName(name);
	}

	public Page_S page_s(Page_S ps) {
		// TODO Auto-generated method stub
		return jobTitleDao.page_s(ps);
	}

	public void addJobTitle(JobTitle jt) {
		jobTitleDao.addJobTitle(jt);
		
	}

	public void changeJobTitle(JobTitle jt) {
		jobTitleDao.changeJobTitle(jt);
		
	}
}
