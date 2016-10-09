package com.atfuture.dao.impl;

import org.springframework.stereotype.Repository;

import com.atfuture.dao.SuperManagerDao;
import com.atfuture.domain.SuperManager;

@Repository
public class SuperManagerDaoImpl extends BaseDaoImpl<SuperManager> implements SuperManagerDao {

	public SuperManager findByNumAndPassword(String num, String password) {
		String hql="from SuperManager s where s.sup_accountNum=? and  s.sup_password=?";
		SuperManager superm=(SuperManager) getSession().createQuery(hql).setParameter(0, num).setParameter(1, password).uniqueResult();
		return superm;
	}

	public SuperManager findById(Integer id) {
		return getEntity(id);
	}

	public void save(SuperManager s) {
		getSession().save(s);
	}

}
