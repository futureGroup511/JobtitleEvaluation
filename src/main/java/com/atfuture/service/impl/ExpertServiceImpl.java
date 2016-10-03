package com.atfuture.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.atfuture.service.ExpertService;
import com.future.utils.Page_S;
import com.atfuture.dao.ExpertDao;
import com.atfuture.domain.Expert;
@Service
public class ExpertServiceImpl  implements ExpertService {
	
	@Resource
	private ExpertDao  expertDao ;

	public Expert findById(Integer id) {
		return expertDao.findById(id);
	}

	public Expert findByNumAndPassword(String num, String password) {
		return expertDao.findByNumAndPassword(num, password);
	}

}
