package com.atfuture.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.EvaluatedRecordDao;
import com.atfuture.service.EvaluatedRecordService;
@Service
public class EvaluatedRecordServiceImpl  implements EvaluatedRecordService{

	@Resource
	private EvaluatedRecordDao evaluatedRecordDao;
}
