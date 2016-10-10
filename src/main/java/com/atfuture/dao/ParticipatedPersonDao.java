package com.atfuture.dao;

import java.util.List;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.Statistics;
import com.atfuture.utils.Page_S;

public interface ParticipatedPersonDao extends BaseDao<ParticipatedPerson>{

	
	public Page_S findAllParticipatedPerson(Page_S p,Integer id);
	
	//通过id查找
	public ParticipatedPerson findById(Integer id);
	public List<ParticipatedPerson> getParticipatedPersonByPage(Page_S page);
	//删除所有参评人员
	public void deleteAll();
	
	//通过姓名进行模糊查找 申报人信息
	public List<Statistics> getParticipatedPersonByName(String participatedPerson);
	//分页查找申报人的信息， 通过申报人的姓名
	public List<Statistics> getParticipatedPersonByNameAndPage(String participatedPerson, Page_S pageBean);

}
