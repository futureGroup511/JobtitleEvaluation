package com.atfuture.service;

import java.util.List;

import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.Statistics;
import com.atfuture.utils.Page_S;

public interface ParticipatedPersonService {

	//分页查询所有评教人员
		public Page_S findAllParticipatedPerson(Page_S p,Integer id);
	//通过id查找
		public ParticipatedPerson findById(Integer id);
	
	//查询得到所有参评人
	public List<ParticipatedPerson> getAllParticipatedPerson();
	//查询得到指定参评人
	public ParticipatedPerson getParticipatedPersonById(Integer id);
	//分页查询得到参评人信息
	public List<ParticipatedPerson> getParticipatedPersonByPage(Page_S page);
	//增加参评人员信息
	public void addParticipatedPerson(ParticipatedPerson participatedPerson);
	public void updateParticipatedPerson(ParticipatedPerson participatedPerson);
	//删除所有人员信息
	public void deleteAll();
	//通过姓名进行模糊查找 申报人信息
	public List<Statistics> getParticipatedPersonByName(String participatedPerson);
	//分页查找申报人的信息， 通过申报人的姓名
	public List<Statistics> getParticipatedPersonByNameAndPage(String participatedPerson, Page_S pageBean);
	

}
