package com.atfuture.service;

import java.util.List;
import java.util.Map;

import com.atfuture.domain.EvaluatedRecord;
import com.atfuture.domain.EvaluatedStandard;
import com.atfuture.domain.Expert;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.Statistics;
import com.atfuture.domain.TypeNumber;
import com.atfuture.utils.Page_S;

public interface EvaluatedRecordService  {

	
	//添加
	public void save(EvaluatedRecord e);
	//计算不同类别的分数
	public List<Object[]> calculateGroupCountByPersonId(Integer id);
	
	public List<EvaluatedRecord> getAllStatisticByExpert(Integer exp_id);

	public List<EvaluatedRecord> getAllStatisticByPageAndExpert(Page_S page, Integer exp_id);
	//分页得到当前条件下的列表记录
	public List<EvaluatedRecord> getRecordByCondition(Integer participatedId, String familiarStatus,
			String evalRecor_allAssessment, Page_S pageBean);
	
	
	//得到记录的条数 为分页准备条件
	public List<EvaluatedRecord> getRecordByCondition(Integer participatedId, String familiarStatus,
			String evalRecor_allAssessment);
	//得到指定参评人被参评 的  专家评分为ABCD的 人数  返回 map  键为 A  B   C  D
	public Map<String, Integer> getExpertNumForSpec(Integer participatedId); 
	
	/**
	 * 根据专家条件查询彩屏人员
	 * 
	 */
	public Page_S findByExpertUnitAndSpecialtyAndAllassessment(Expert expert,Page_S page,List<ParticipatedPerson> persons,String allassessment);
	
	/**
	 * 查询通过专家姓名和总平的分
	 * @param expertanme 专家姓名
	 * @param allassessment 总平均分
	 * @param page 分页
	 * @return
	 */
	public Page_S FindByExpertName(String expertanme,Page_S page);
	
	/**
	 * 得到所有审评记录
	 * @param page
	 * @return
	 */
	public Page_S findAllRecord(Page_S page);
	
	public List<Object[]> calculateGroupCountByExpertId(Integer id);
	
	//查找专家评选不同综合分值类型的人数
	public  List<TypeNumber> getAssessmentCountByExpertId(Integer id);
}
