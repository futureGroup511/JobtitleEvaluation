package com.atfuture.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.UnitDao;
import com.atfuture.service.UnitService;

@Service
public class UnitServiceImpl  implements UnitService {

	@Resource
	private UnitDao unitDao;
}
