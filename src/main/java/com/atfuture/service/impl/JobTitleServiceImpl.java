package com.atfuture.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.JobTitleDao;
import com.atfuture.domain.JobTitle;
import com.atfuture.service.JobTitleService;
@Service
public class JobTitleServiceImpl  implements JobTitleService{

	@Resource
	private JobTitleDao  jobTitleDao ;

	public List<JobTitle> getAllJobTitle() {
		String sql = "from JobTitle";
		return jobTitleDao.findEntityByHQL(sql);
	}
}
