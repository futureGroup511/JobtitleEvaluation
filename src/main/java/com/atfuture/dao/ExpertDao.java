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
	
	//通过专家姓名查找专家
	public Expert findByname(String name);
	
	//得到用户名最大的字符串
	public String getMaxAccountNum();
	//重置密码
	public void resetPwd(Integer exp_id);
	//置空密码
	public void resetPwdToNull(Integer exp_id);
	
	
	
}
