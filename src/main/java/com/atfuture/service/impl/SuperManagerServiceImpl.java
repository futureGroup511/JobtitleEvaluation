package com.atfuture.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.SuperManagerDao;
import com.atfuture.service.SuperManagerService;

@Service
public class SuperManagerServiceImpl implements SuperManagerService {

	@Resource
	private SuperManagerDao superManagerDao;
}
