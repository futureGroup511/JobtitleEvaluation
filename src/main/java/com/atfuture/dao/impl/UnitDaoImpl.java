package com.atfuture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.atfuture.dao.UnitDao;
import com.atfuture.domain.Unit;
import com.future.utils.Page_S;

@Repository
public class UnitDaoImpl extends BaseDaoImpl<Unit> implements UnitDao {

public Unit getUnit(int id) {
		
		return this.getEntity(id);
	}

	public List<Unit> findByName(String name) {
		// TODO Auto-generated method stub
		String hql="from Unit where uni_name like '%"+name+"%'";
		return this.findEntityByHQL(hql);
	}

	public Page_S page_s(Page_S page_s) {
		// TODO Auto-generated method stub
		int currentPage=page_s.getCurrentPage();
		int pageSize=page_s.getPageSize();
		String sql="select * from unit limit ?,?";
		int startRow=pageSize*(currentPage-1);
		List<Unit> recordList=this.executeSQLQuery(Unit.class, sql, startRow,pageSize);
		String hql="select count(*) from Unit";
		int recordCount=((Long) this.uniqueResult(hql)).intValue();
		page_s=new Page_S(currentPage,pageSize,recordCount,recordList);
		return page_s;
	}

	public void addUnit(Unit jt) {
		this.saveEntity(jt);
	}

	public void changeUnit(Unit jt) {
		this.updateEntity(jt);
	}

	public boolean checkExist(String name) {
		String hql="select count(*) from Unit where uni_name = ?";
		int recordCount=((Long) this.uniqueResult(hql,name)).intValue();
		if(recordCount>0){
			return true;
		}else{
			return false;
		}
	}
}
