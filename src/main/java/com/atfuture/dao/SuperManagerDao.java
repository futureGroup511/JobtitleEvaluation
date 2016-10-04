package com.atfuture.dao;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.SuperManager;

public interface SuperManagerDao extends BaseDao<SuperManager>{

	//根据账号密码查询
	public SuperManager findByNumAndPassword(String num,String password);
}
