package com.atfuture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.atfuture.dao.EvaluatedRecordDao;
import com.atfuture.domain.EvaluatedRecord;
import com.atfuture.utils.Page_S;
@Repository
public class EvaluatedRecordDaoImpl extends BaseDaoImpl<EvaluatedRecord> implements EvaluatedRecordDao{

	public void save(EvaluatedRecord e) {
               saveOrUpdateEntity(e);
	}

	public List<Object[]> calculateGroupCountByPersonId(Integer id) {
		String sql="select (SUM(evalRecor_allAssessment)/COUNT(evalrecor_id)) as result,evalRecor_spciaFamiliar from  evaluaterecord e  where e.evalRecor_participatedPerson_parti_id=? GROUP BY evalRecor_spciaFamiliar";
		List<Object[]> result=getSession().createSQLQuery(sql).setParameter(0, id).list();
		return result;
	}

	public List<EvaluatedRecord> getAllStatisticByPageAndExpert(Page_S page, Integer exp_id) {
		String sql = "from EvaluatedRecord evaluatedRecord where evaluatedRecord.evalRecor_expart.exp_id = :exp_id";
		@SuppressWarnings("unchecked")
		List<EvaluatedRecord> evaluatedRecordList = getSession().createQuery(sql).setParameter("exp_id", exp_id)
																	.setFirstResult((page.getCurrentPage()-1)*page.getPageSize())
																		.setMaxResults(page.getPageSize())
																			.list();
		
		System.out.println(evaluatedRecordList);
		return evaluatedRecordList;
	}

}
