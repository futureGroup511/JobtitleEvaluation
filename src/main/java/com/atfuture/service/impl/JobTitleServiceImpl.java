package com.atfuture.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.JobTitleDao;
import com.atfuture.service.JobTitleService;
@Service
public class JobTitleServiceImpl  implements JobTitleService{

	@Resource
	private JobTitleDao  jobTitleDao ;
}
