package com.atfuture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.atfuture.dao.ExpertDao;
import com.atfuture.domain.Expert;
import com.atfuture.utils.Page_S;
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
	public List<Expert> getExpertByPage(Page_S page) {
		String sql = "from Expert";
		@SuppressWarnings("unchecked")
		List<Expert> expertList = getSession().createQuery(sql)
								.setFirstResult((page.getCurrentPage()-1)*page.getPageSize())
										.setMaxResults(page.getPageSize())
											.list();
		return expertList;
	}

	public List<Expert> getAllExpert() {
		String sql = "from Expert";
		return getSession().createQuery(sql).list();
	}

	@Override
	public void save(Expert e) {
		saveEntity(e);
	}

}
