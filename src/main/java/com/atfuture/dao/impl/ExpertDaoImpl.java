package com.atfuture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.atfuture.dao.ExpertDao;
import com.atfuture.domain.Expert;
import com.future.utils.Page_S;
@Repository
public class ExpertDaoImpl extends BaseDaoImpl<Expert> implements ExpertDao {

	public Expert findById(Integer id) {
		return getEntity(id);
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

}
