package com.atfuture.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.atfuture.service.ExpertService;
import com.atfuture.utils.Page_S;
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

	public Expert querySpecialExpertByAccountNum(String accountNum) {
		String hql = "from Expert expert where expert.exp_accountNum = ?";
		return (Expert) expertDao.uniqueResult(hql, accountNum);
	}
	public void save(Expert e) {
		expertDao.save(e);
	}
	public Expert findByname(String name) {
		
		return expertDao.findByname(name);
	}
	public String getMaxAccountNum() {
		return expertDao.getMaxAccountNum();
	}
	public void resetPwd(Integer exp_id) {
		expertDao.resetPwd(exp_id);
	}


}
