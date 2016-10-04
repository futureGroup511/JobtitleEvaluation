package com.atfuture.dao.impl;

import org.springframework.stereotype.Repository;

import com.atfuture.dao.EvaluatedStandardDao;
import com.atfuture.domain.EvaluatedStandard;
import com.atfuture.domain.Expert;

@Repository
public class EvaluatedStandardDaoImpl extends BaseDaoImpl<EvaluatedStandard> implements EvaluatedStandardDao{

	public EvaluatedStandard findByJobTitleId(Integer id) {
		String hql="from EvaluatedStandard e where e.evalStan_jobtile.jobTi_id=?";
		EvaluatedStandard expert=(EvaluatedStandard) uniqueResult(hql, id);
		return expert;
	}

}
