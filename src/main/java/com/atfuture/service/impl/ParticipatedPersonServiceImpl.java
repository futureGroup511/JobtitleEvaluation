package com.atfuture.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.ParticipatedPersonDao;
import com.atfuture.service.ParticipatedPersonService;

@Service
public class ParticipatedPersonServiceImpl  implements ParticipatedPersonService{

	@Resource
	private ParticipatedPersonDao participatedPersonDao;
}
