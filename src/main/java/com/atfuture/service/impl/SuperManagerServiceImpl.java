package com.atfuture.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.SuperManagerDao;
import com.atfuture.domain.SuperManager;
import com.atfuture.service.SuperManagerService;

@Service
public class SuperManagerServiceImpl implements SuperManagerService {

	@Resource
	private SuperManagerDao superManagerDao;

	public SuperManager findByNumAndPassword(String num, String password) {
		return superManagerDao.findByNumAndPassword(num, password);
	}

	public SuperManager findById(Integer id) {
		return superManagerDao.findById(id);
	}

	public void save(SuperManager s) {
		superManagerDao.save(s);
	}
}
