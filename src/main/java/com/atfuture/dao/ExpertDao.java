package com.atfuture.dao;

import java.util.List;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.Expert;
import com.atfuture.utils.Page_S;

public interface ExpertDao extends BaseDao<Expert>{

	public Expert findById(Integer id);
	
	public Expert findByNumAndPassword(String num,String password);

	public List<Expert> getExpertByPage(Page_S page);
	
	//得到所有的专家
	public List<Expert> getAllExpert();
	
	//保存专家
	public void save(Expert e);
	
	
	
}
