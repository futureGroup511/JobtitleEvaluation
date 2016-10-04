package com.atfuture.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.EvaluatedRecordDao;
import com.atfuture.domain.EvaluatedRecord;
import com.atfuture.domain.EvaluatedStandard;
import com.atfuture.domain.Statistics;
import com.atfuture.service.EvaluatedRecordService;
import com.future.utils.Page_S;
@Service
public class EvaluatedRecordServiceImpl  implements EvaluatedRecordService{

	@Resource
	private EvaluatedRecordDao evaluatedRecordDao;

	public void save(EvaluatedRecord e) {
		evaluatedRecordDao.save(e);
	}

	public List<Object[]> calculateGroupCountByPersonId(Integer id) {
		return evaluatedRecordDao.calculateGroupCountByPersonId(id);
	}
	public List<EvaluatedRecord> getAllStatisticByExpert(Integer exp_id) {
		String sql = "from EvaluatedRecord evaluatedRecord where evaluatedRecord.evalRecor_expart.exp_id = ?";
		List<EvaluatedRecord> evaluatedRecordList = evaluatedRecordDao.findEntityByHQL(sql, exp_id);
		return evaluatedRecordList;
	}

	public List<EvaluatedRecord> getAllStatisticByPageAndExpert(Page_S page, Integer exp_id) {
		return evaluatedRecordDao.getAllStatisticByPageAndExpert(page, exp_id);
	}

	

}