package com.atfuture.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.EvaluatedRecordDao;
import com.atfuture.domain.EvaluatedRecord;
import com.atfuture.service.EvaluatedRecordService;
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
}
