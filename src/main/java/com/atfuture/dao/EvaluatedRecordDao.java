package com.atfuture.dao;

import java.util.List;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.EvaluatedRecord;
import com.atfuture.domain.Expert;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.Specialty;
import com.atfuture.domain.Unit;
import com.atfuture.utils.Page_S;

public interface EvaluatedRecordDao extends BaseDao<EvaluatedRecord>{

	
	public void save(EvaluatedRecord e);
	
	public List<Object[]> calculateGroupCountByPersonId(Integer id);
	//评估记录 分页并按 指定专家进行查询
	public List<EvaluatedRecord> getAllStatisticByPageAndExpert(Page_S page, Integer exp_id);

	/**
	 * 通过专家，单位，专业来选择获得评选记录
	 */
	public Page_S findByExpertUnitAndSpecialty(Expert expert,Page_S page,List<ParticipatedPerson> persons);
	/**
	 * 模糊查询通过专家姓名和总平的分
	 * @param expertanme 专家姓名
	 * @param allassessment 总平均分
	 * @param page 分页
	 * @return
	 */
	public Page_S likeFindByExpertNameOrAllassessment(String expertanme,String allassessment,Page_S page);
}
