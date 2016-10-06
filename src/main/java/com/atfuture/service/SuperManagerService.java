package com.atfuture.service;

import com.atfuture.domain.SuperManager;

public interface SuperManagerService {

	public SuperManager findByNumAndPassword(String num, String password);

	public SuperManager findById(Integer id);
	
	public void save(SuperManager s);
}
