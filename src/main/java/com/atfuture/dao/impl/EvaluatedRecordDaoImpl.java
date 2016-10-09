package com.atfuture.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.atfuture.dao.EvaluatedRecordDao;
import com.atfuture.domain.EvaluatedRecord;
import com.atfuture.domain.Expert;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.TypeNumber;
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

	public Page_S findByExpertUnitAndSpecialty(Expert expert,Page_S page,List<ParticipatedPerson> persons) {
		Criteria criteria=getSession().createCriteria(EvaluatedRecord.class);
		if(expert==null) return null; //如果专家为空则所有条件不成立
		criteria.add(Restrictions.eq("evalRecor_expart", expert));
		//集合为空的时候说明只是查询了此专家的审评记录，为零的时候说明与这个专家相同的专业和单位相同的人员不存在所以结果为0
		if(persons!=null) criteria.add(Restrictions.in("evalRecor_participatedPerson",persons));
		getPageByCriteriaSet(criteria, page);
		return page;
	}

	public Page_S FindByExpertNameOrAllassessment(String expertanme, String allassessment,Page_S page) {
		Criteria criteria=getSession().createCriteria(EvaluatedRecord.class); 
		if(expertanme!=null) criteria.createCriteria("evalRecor_expart").add(Restrictions.eq("exp_name", expertanme));
		if(!allassessment.equals("请选择"))criteria.add(Restrictions.eq("evalRecor_allAssessment", allassessment));
		criteria.setProjection(Projections.rowCount());
		getPageByCriteriaSet(criteria, page);
		return page;
	}
	
	public Page_S findAllRecord(Page_S page) {
		Criteria criteria=getSession().createCriteria(EvaluatedRecord.class);
		criteria.setProjection(Projections.rowCount());
		getPageByCriteriaSet(criteria, page);
		return page;
	}
	
	public Page_S getPageByCriteriaSet(Criteria criteria,Page_S page){
		criteria.setProjection(Projections.rowCount());
		Integer num = ((Number)criteria.uniqueResult()).intValue();//查询总数
		criteria.setProjection(null);
		criteria.setFirstResult(page.getPageSize()*(page.getCurrentPage()-1));
		criteria.setMaxResults(page.getPageSize());
		List ers=criteria.list();
		page.setRecordCount(num);
		page.setRecordlist(ers);
		page.calculatePageEndAndBeginIndex();
		return page;
	}

	public List<Object[]> calculateGroupCountByExpertId(Integer id) {
		String sql="select (SUM(evalRecor_allAssessment)/COUNT(evalrecor_id)) as result,evalRecor_spciaFamiliar from  evaluaterecord e  where evalRecor_expart_exp_id=? GROUP BY evalRecor_spciaFamiliar";
		List<Object[]> result=getSession().createSQLQuery(sql).setParameter(0, id).list();
		return result;
	} 

	public  List<Object[]> getAssessmentCountByExpertId(Integer id) {
		String sql="select COUNT(evalrecor_id) as count,e.evalRecor_allAssessment  from  evaluaterecord e  where evalRecor_expart_exp_id=? GROUP BY evalRecor_allAssessment";
		List<Object[]> result=getSession().createSQLQuery(sql).setParameter(0, id).list();
		return result;
	}
	
	
	

	

}
