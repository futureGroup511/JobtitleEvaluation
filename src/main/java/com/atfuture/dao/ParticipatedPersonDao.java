package com.atfuture.dao;

import java.util.List;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.utils.Page_S;

public interface ParticipatedPersonDao extends BaseDao<ParticipatedPerson>{

	
	public Page_S findAllParticipatedPerson(Page_S p,Integer id);
	
	//通过id查找
	public ParticipatedPerson findById(Integer id);
	public List<ParticipatedPerson> getParticipatedPersonByPage(Page_S page);
	//删除所有参评人员
	public void deleteAll();
	//查询与专家单位和专家专业相关的参评人员
	public List<ParticipatedPerson> findByExpertUnitAndSpecialt(Integer unitId,Integer speciaId);
}
