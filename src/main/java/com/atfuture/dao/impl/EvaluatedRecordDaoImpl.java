package com.atfuture.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
<<<<<<< HEAD
import org.hibernate.Hibernate;
=======
import org.hibernate.criterion.Expression;
>>>>>>> c34d4edbb054b6fac0a20d6440460d4eaa155e00
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import com.atfuture.dao.EvaluatedRecordDao;
import com.atfuture.domain.EvaluatedRecord;
import com.atfuture.domain.Expert;
import com.atfuture.domain.ParticipatedPerson;
<<<<<<< HEAD
import com.atfuture.domain.TypeNumber;
=======
>>>>>>> c34d4edbb054b6fac0a20d6440460d4eaa155e00
import com.atfuture.utils.Page_S;
@Repository
public class EvaluatedRecordDaoImpl extends BaseDaoImpl<EvaluatedRecord> implements EvaluatedRecordDao{

	public static final Integer[] SCORECLASS = {30, 20, 10, 0}; 
	public static final String[] SCORECLASSStr = {"A", "B", "C", "D"}; 
	
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
																			.list();
		System.out.println(evaluatedRecordList);
		return evaluatedRecordList;
	}

	public List<EvaluatedRecord> getRecordByCondition(Integer participatedId, String familiarStatus,
			String evalRecor_allAssessment, Page_S pageBean) {
		//附加基本的条件进行查询  //基本的必须的条件
		Criteria criteria = getSession().createCriteria(EvaluatedRecord.class);
		criteria.add(Expression.eq("evalRecor_participatedPerson.parti_id", participatedId));
		if((familiarStatus != null) && ((""+familiarStatus).trim() != "")&& familiarStatus.length()>0){//数据库中是ABC
			criteria.add(Expression.eq("evalRecor_spciaFamiliar", familiarStatus));
		}
		if((evalRecor_allAssessment != null) && ((""+evalRecor_allAssessment).trim() != "") && evalRecor_allAssessment.length()>0){// 30 20 10 0
			criteria.add(Expression.eq("evalRecor_allAssessment", evalRecor_allAssessment));
		}
		List<EvaluatedRecord> list = criteria.setFirstResult((pageBean.getCurrentPage()-1)*pageBean.getPageSize())
				.setMaxResults(pageBean.getPageSize())
				.list();
		return list;
		
		
		
		
		
		
		
		
		
		
		/*ParticipatedPerson participatedPerson = new ParticipatedPerson();
		participatedPerson.setParti_id(participatedId);
		EvaluatedRecord evaluatedRecord = new EvaluatedRecord();
		evaluatedRecord.setEvalRecor_participatedPerson(participatedPerson);
		if((familiarStatus != null && familiarStatus.trim() != "")){//数据库中是ABC
			evaluatedRecord.setEvalRecor_spciaFamiliar(familiarStatus);
		}
		if((evalRecor_allAssessment != null && evalRecor_allAssessment.trim() != "")){// 30 20 10 0
			evaluatedRecord.setEvalRecor_allAssessment(evalRecor_allAssessment);
		}
		
		Criteria criteria = getSession().createCriteria(EvaluatedRecord.class).addOrder(Order.desc("evalRecor_allAssessment")).add(Example.create(evaluatedRecord)).createCriteria("evalRecor_participatedPerson")
				.add(Example.create(evaluatedRecord.getEvalRecor_participatedPerson()));
		@SuppressWarnings("unchecked")
		List<EvaluatedRecord> recordList = criteria.setFirstResult((pageBean.getCurrentPage()-1)*pageBean.getPageSize())
														.setMaxResults(pageBean.getPageSize())
															.list();
		return recordList;*/
	}

	public List<EvaluatedRecord> getRecordByCondition(Integer participatedId, String familiarStatus,
			String evalRecor_allAssessment) {
		
		Criteria criteria = getSession().createCriteria(EvaluatedRecord.class);
		criteria.add(Expression.eq("evalRecor_participatedPerson.parti_id", participatedId));
		System.out.println(((evalRecor_allAssessment != null) && ((""+evalRecor_allAssessment).trim() != "") && evalRecor_allAssessment.length()>0));
		if((familiarStatus != null) && ((familiarStatus+"").trim() != "") && familiarStatus.length() >0){//数据库中是ABC
			criteria.add(Expression.eq("evalRecor_spciaFamiliar", familiarStatus));
		}
		if((evalRecor_allAssessment != null) && ((evalRecor_allAssessment+"").trim() != "") && evalRecor_allAssessment.length()>0){// 30 20 10 0
			criteria.add(Expression.eq("evalRecor_allAssessment", evalRecor_allAssessment));
		}
		
		return criteria.list();
		
		
		
		
		
		//附加基本的条件进行查询  //基本的必须的条件
				/*ParticipatedPerson participatedPerson = new ParticipatedPerson();
				participatedPerson.setParti_id(participatedId);
				
				EvaluatedRecord evaluatedRecord = new EvaluatedRecord();
				evaluatedRecord.setEvalRecor_participatedPerson(participatedPerson);
				if((familiarStatus != null && familiarStatus.trim() != "")){//数据库中是ABC
					evaluatedRecord.setEvalRecor_spciaFamiliar(familiarStatus);
				}
				if((evalRecor_allAssessment != null && evalRecor_allAssessment.trim() != "")){// 30 20 10 0
					evaluatedRecord.setEvalRecor_allAssessment(evalRecor_allAssessment);
				}
				
				Criteria criteria = getSession().createCriteria(EvaluatedRecord.class).addOrder(Order.desc("evalRecor_allAssessment")).add(Example.create(evaluatedRecord)).createCriteria("evalRecor_participatedPerson")
																	.add(Example.create(evaluatedRecord.getEvalRecor_participatedPerson()));
				
				List<EvaluatedRecord> recordList = criteria.list();
				return recordList;*/
	}

	public Map<String, Integer> getExpertNumForSpec(Integer participatedId) {
		Map<String, Integer> expertNumMap = new HashMap<String, Integer>();
		
		// 的专家人数
		for(int i=0;i<SCORECLASS.length;i++){
			String sql = "from EvaluatedRecord record where record.evalRecor_participatedPerson.parti_id = :participatedId and record.evalRecor_allAssessment = :evalRecor_allAssessment";
			int num = getSession().createQuery(sql).setParameter("participatedId", participatedId)
												.setParameter("evalRecor_allAssessment", SCORECLASS[i]+"")
													.list().size();
			expertNumMap.put(SCORECLASSStr[i], num);
			System.out.println("id为"+participatedId +"数量"+num);
		}
		return expertNumMap;
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

	public  List<TypeNumber> getAssessmentCountByExpertId(Integer id) {
		String sql="select e.evalRecor_allAssessment as assessmentType ,COUNT(evalrecor_id) as count from  evaluaterecord e  where evalRecor_expart_exp_id=? GROUP BY evalRecor_allAssessment";
		List<TypeNumber> result=getSession().createSQLQuery(sql).addScalar("assessmentType",StandardBasicTypes.STRING).addScalar("count",StandardBasicTypes.INTEGER).setParameter(0, id).setResultTransformer(Transformers.aliasToBean(TypeNumber.class)).list();
		return result;
	}
	
	
	

	

}
