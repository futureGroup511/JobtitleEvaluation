package com.atfuture.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.TestDao;
import com.atfuture.domain.Test;
import com.atfuture.service.TestService;

@Service
public class TestServiceImpl implements TestService{
	@Resource
	private TestDao testDaO;
	public Test loginByNumAndPassword(String num, String password) {
		return testDaO.loginByNumAndPassword(num, password);

	}

	
	
}
