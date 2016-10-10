package com.atfuture.dao;

import java.util.List;
import java.util.Map;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.EvaluatedRecord;
import com.atfuture.domain.Expert;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.TypeNumber;
import com.atfuture.utils.Page_S;

public interface EvaluatedRecordDao extends BaseDao<EvaluatedRecord>{

	
	public void save(EvaluatedRecord e);
	
	public List<Object[]> calculateGroupCountByPersonId(Integer id);
	//评估记录 分页并按 指定专家进行查询
	public List<EvaluatedRecord> getAllStatisticByPageAndExpert(Page_S page, Integer exp_id);
	//评估记录 各种条件查询加上分页
	public List<EvaluatedRecord> getRecordByCondition(Integer participatedId, String familiarStatus,
			String evalRecor_allAssessment, Page_S pageBean);

	//评估记录 各种条件查询 得到所有的数量
	public List<EvaluatedRecord> getRecordByCondition(Integer participatedId, String familiarStatus,
			String evalRecor_allAssessment);
	//得到指定参评人被参评 的  专家评分为ABCD的 人数  返回 map  键为 A  B   C  D
	public Map<String, Integer> getExpertNumForSpec(Integer participatedId);

	/**
	 * 通过专家，单位，专业来选择获得评选记录
	 */
	public Page_S findByExpertUnitAndSpecialty(Expert expert,Page_S page,List<ParticipatedPerson> persons);
	/**
	 * 查询通过专家姓名和总平的分
	 * @param expertanme 专家姓名
	 * @param allassessment 总平均分
	 * @param page 分页
	 * @return
	 */
	public Page_S FindByExpertNameOrAllassessment(String expertanme,String allassessment,Page_S page);
	
	public Page_S findAllRecord(Page_S page);
	
	public List<Object[]> calculateGroupCountByExpertId(Integer id);
	
	public  List<TypeNumber> getAssessmentCountByExpertId(Integer id);
}

