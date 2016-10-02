package com.atfuture.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.atfuture.service.ExpertService;
import com.future.utils.Page_S;
import com.atfuture.dao.ExpertDao;
@Service
public class ExpertServiceImpl  implements ExpertService {
	
	@Resource
	private ExpertDao  expertDao ;

}
