package com.atfuture.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atfuture.dao.UnitDao;
import com.atfuture.domain.Unit;
import com.atfuture.service.UnitService;

@Service
public class UnitServiceImpl  implements UnitService {

	@Resource
	private UnitDao unitDao;

	public List<Unit> getAllUnit() {
		String sql = "from Unit";
		return unitDao.findEntityByHQL(sql);
	}
}
