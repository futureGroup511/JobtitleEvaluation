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
}
