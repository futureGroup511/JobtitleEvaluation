package com.atfuture.service.impl;

import java.util.List;

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

	public List<Expert> getExpertByPage(Page_S page) {
		return expertDao.getExpertByPage(page);
	}

	public void saveExpertInfo(Expert expert) {
		expertDao.saveEntity(expert);
	}

	public void updateExpertInfo(Expert expert) {
		expertDao.updateEntity(expert);
	}

	public List<Expert> getAllExpert() {
		return expertDao.getAllExpert();
	}


}
