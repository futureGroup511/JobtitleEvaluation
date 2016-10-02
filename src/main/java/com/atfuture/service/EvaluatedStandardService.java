package com.atfuture.service;

import com.atfuture.domain.EvaluatedStandard;

public interface EvaluatedStandardService {

	//根据职称查询标准
	public EvaluatedStandard findByJobTitleId(Integer id);
	
}
