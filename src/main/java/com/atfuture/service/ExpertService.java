package com.atfuture.service;

import java.util.List;

import com.atfuture.domain.Expert;
import com.atfuture.utils.Page_S;

public interface ExpertService {

	
	//通过id查询专家
	public Expert findById(Integer id);
	
	//根据账号密码查询
	public Expert findByNumAndPassword(String num, String password);
	
	//分页查询专家信息
	public List<Expert> getExpertByPage(Page_S page);
	//保存专家信息
	public void saveExpertInfo(Expert expert);
	//更新专家信息
	public void updateExpertInfo(Expert expert);
	//得到所有的专家信息
	public List<Expert> getAllExpert();
	//根据账号查询指定专家
	public Expert querySpecialExpertByAccountNum(String accountNum);
	//保存专家
	public void save(Expert e);
	//根据姓名查找专家
	public Expert findByname(String name);
	//得到最大的账号字符串
	public String getMaxAccountNum();
	//重置密码
	public void resetPwd(Integer exp_id);
	//置空密码
	public void resetPwdToNull(Integer exp_id);
}
