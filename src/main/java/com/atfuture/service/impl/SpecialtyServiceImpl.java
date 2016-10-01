package com.atfuture.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.SpecialtyDao;
import com.atfuture.service.SpecialtyService;

@Service
public class SpecialtyServiceImpl  implements SpecialtyService  {

	@Resource
	private SpecialtyDao specialtyDao;
}
