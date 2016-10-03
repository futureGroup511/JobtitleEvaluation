package com.atfuture.dao.impl;

import org.springframework.stereotype.Repository;

import com.atfuture.dao.ExpertDao;
import com.atfuture.domain.Expert;
@Repository
public class ExpertDaoImpl extends BaseDaoImpl<Expert> implements ExpertDao {

	public Expert findById(Integer id) {
		return getEntity(id);
	}

}
