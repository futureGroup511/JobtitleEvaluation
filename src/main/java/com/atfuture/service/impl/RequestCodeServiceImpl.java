package com.atfuture.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.RequestCodeDao;
import com.atfuture.domain.RequestCode;
import com.atfuture.service.RequestCodeService;

@Service
public class RequestCodeServiceImpl implements RequestCodeService{

	@Resource
	private RequestCodeDao requestCodeDao;

	public RequestCode getSpecialRequestCode(Integer id) {
		return requestCodeDao.getEntity(id);
	}

	public List<RequestCode> getAllRequestCodes() {
		String sql = "from RequestCode";
		return requestCodeDao.findEntityByHQL(sql);
	}

	public void updateSpecialRequestCode(RequestCode requestCode) {
		requestCodeDao.saveOrUpdateEntity(requestCode);
	}

	public void saveRequestCode(RequestCode requestCode) {
		requestCodeDao.saveEntity(requestCode);
	}

	public void saveOrUpdateRequestCode(RequestCode requestCode) {
		requestCodeDao.saveOrUpdateEntity(requestCode);
	}
	
	
	
	
	
	
}
