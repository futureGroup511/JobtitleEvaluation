package com.atfuture.dao.impl;

import org.springframework.stereotype.Repository;

import com.atfuture.dao.TestDao;
import com.atfuture.domain.Test;


@Repository
public class TestDaoImpl extends BaseDaoImpl<Test> implements TestDao {

	public Test loginByNumAndPassword(String num, String password) {
		String hql="from Test t where t.num = ? and t.password= ?";
		Test test=(Test) getSession().createQuery(hql).setString(0, num).setString(1, password).uniqueResult();
		return test;
	}
}
