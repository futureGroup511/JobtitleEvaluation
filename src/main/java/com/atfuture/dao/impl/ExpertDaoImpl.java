package com.atfuture.dao.impl;

import org.springframework.stereotype.Repository;

import com.atfuture.dao.ExpertDao;
import com.atfuture.domain.Expert;
@Repository
public class ExpertDaoImpl extends BaseDaoImpl<Expert> implements ExpertDao {

	public Expert findById(Integer id) {
		return getEntity(id);
	}

	public Expert findByNumAndPassword(String num, String password) {
		String hql="from Expert e where e.exp_accountNum=? and e.exp_password=?";
		Expert expert=(Expert) getSession().createQuery(hql).setParameter(0, num).setParameter(1, password).uniqueResult();
		return expert;
	}

}
