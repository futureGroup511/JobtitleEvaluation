package com.atfuture.dao;

import java.util.List;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.Expert;
import com.future.utils.Page_S;

public interface ExpertDao extends BaseDao<Expert>{

	public Expert findById(Integer id);

	public List<Expert> getExpertByPage(Page_S page);
	
	//得到所有的专家
	public List<Expert> getAllExpert();
}
