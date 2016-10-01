package com.atfuture.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.EvaluatedStandardDao;
import com.atfuture.service.EvaluatedStandardService;

@Service
public class EvaluatedStandardServiceImpl  implements EvaluatedStandardService{

	@Resource
	private EvaluatedStandardDao evaluatedStandardDao;
}
