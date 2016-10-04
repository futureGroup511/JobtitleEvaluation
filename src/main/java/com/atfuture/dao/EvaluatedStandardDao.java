package com.atfuture.dao;

import com.atfuture.base.BaseDao;
import com.atfuture.domain.EvaluatedStandard;
import com.atfuture.domain.Expert;

public interface EvaluatedStandardDao extends BaseDao<EvaluatedStandard>{

	public EvaluatedStandard findByJobTitleId(Integer id);
}
