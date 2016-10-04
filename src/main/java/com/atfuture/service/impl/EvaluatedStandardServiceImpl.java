package com.atfuture.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.EvaluatedStandardDao;
import com.atfuture.domain.EvaluatedStandard;
import com.atfuture.service.EvaluatedStandardService;

@Service
public class EvaluatedStandardServiceImpl  implements EvaluatedStandardService{

	@Resource
	private EvaluatedStandardDao evaluatedStandardDao;

	public EvaluatedStandard findByJobTitleId(Integer id) {
		return evaluatedStandardDao.findByJobTitleId(id);
	}

	public EvaluatedStandard getStandardByJobTitleId(Integer jobTi_id) {
		String hql = "from EvaluatedStandard standard where standard.evalStan_jobtile.jobTi_id = ?";
		return (EvaluatedStandard) evaluatedStandardDao.uniqueResult(hql, jobTi_id);
	}

	public void updateEvaluatedStandard(EvaluatedStandard model) {
		evaluatedStandardDao.updateEntity(model);
	}
}
