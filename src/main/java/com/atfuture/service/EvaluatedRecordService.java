package com.atfuture.service;

import java.util.List;

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
	
	/**
	 * 根据专家条件查询彩屏人员
	 * 
	 */
	public Page_S findByExpertUnitAndSpecialty(Expert expert,Page_S page,List<ParticipatedPerson> persons);
	
	/**
	 * 查询通过专家姓名和总平的分
	 * @param expertanme 专家姓名
	 * @param allassessment 总平均分
	 * @param page 分页
	 * @return
	 */
	public Page_S FindByExpertNameOrAllassessment(String expertanme, String allassessment,Page_S page);
	
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
