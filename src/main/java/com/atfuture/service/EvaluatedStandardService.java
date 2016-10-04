package com.atfuture.service;

import com.atfuture.domain.EvaluatedStandard;

public interface EvaluatedStandardService {

	//根据职称查询标准
	public EvaluatedStandard findByJobTitleId(Integer id);
	//得到指定的职称对应的评估标准
	public EvaluatedStandard getStandardByJobTitleId(Integer jobTi_id);
	//更新制定的评估标准
	public void updateEvaluatedStandard(EvaluatedStandard model);
	
}
