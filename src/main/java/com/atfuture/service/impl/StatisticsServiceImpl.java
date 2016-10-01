package com.atfuture.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.StatisticsDao;
import com.atfuture.service.StatisticsService;
@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Resource
	private StatisticsDao statisticsDao; 
}
