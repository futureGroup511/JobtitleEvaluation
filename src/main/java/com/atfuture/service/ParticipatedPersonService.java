package com.atfuture.service;

import java.util.List;

import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.Specialty;
import com.atfuture.domain.Unit;
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
	//根据与专家相同单位和专业查询参评人员
	public List<ParticipatedPerson> findByExpertUnitAndSpecialt(Unit unit, Specialty specia);

}
