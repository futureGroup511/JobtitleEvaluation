package com.atfuture.service;

import com.atfuture.domain.Expert;
import com.future.utils.Page_S;

public interface ExpertService {

	
	//通过id查询专家
	public Expert findById(Integer id);
	
	//根据账号密码查询
	public Expert findByNumAndPassword(String num, String password);
	
}
