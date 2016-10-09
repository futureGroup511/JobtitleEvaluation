package com.atfuture.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.atfuture.dao.StatisticsDao;
import com.atfuture.domain.Specialty;
import com.atfuture.domain.Statistics;
import com.atfuture.domain.Unit;
import com.atfuture.utils.Page_S;

@Repository
public class StatisticsDaoImpl extends BaseDaoImpl<Statistics> implements StatisticsDao {

	public Statistics findByPersonId(Integer id) {
		String hql="from Statistics s where s.sta_participatedPerson.parti_id=?";
		Statistics result=(Statistics) getSession().createQuery(hql).setParameter(0, id).uniqueResult();
		return result;
	}

	public void saveOrUpdate(Statistics s) {
		saveOrUpdateEntity(s);
	}

	public List<Statistics> getAllStatisticByPage(Page_S page) {
		String sql = "from Statistics statistics order by statistics.sta_AllScored desc";
		@SuppressWarnings("unchecked")
		List<Statistics> statisticList = getSession().createQuery(sql).setFirstResult((page.getCurrentPage()-1)*page.getPageSize())
														.setMaxResults(page.getPageSize())
															.list();
		return statisticList;
	}

	public Page_S getBySpecialty(Page_S page_s,Specialty specialty) {
		String hql="from Statistics statistics order by statistics.sta_AllScored desc";
		List<Statistics> list=this.findEntityByHQL(hql);
		
		if(specialty==null||"".equals(specialty.getSpec_id())||specialty.getSpec_id()<=0){
			if(page_s.getPageSize()>=list.size()){
				page_s.setRecordlist(list);
			}else{
				page_s.setRecordlist(list.subList(0, page_s.getPageSize()));
			}
			return page_s;
		};
		
		List<Statistics> rList=new ArrayList(page_s.getPageSize());
		
		int num=0;
		for(Statistics s:list){
			if(specialty.getSpec_id()==s.getSta_participatedPerson().getParti_specialty().getSpec_id()){
				rList.add(s);
				num++;
				if(num==page_s.getPageSize()){
					break;
				}
			}
			
		}
		page_s.setRecordlist(rList);
		return page_s;
	}

	public Page_S getByUnit(Page_S page_s,Unit unit) {
		
		String hql="from Statistics statistics order by statistics.sta_AllScored desc";
		List<Statistics> list=this.findEntityByHQL(hql);
		
		if(unit==null||"".equals(unit.getUni_id())||unit.getUni_id()<=0){
			if(page_s.getPageSize()>=list.size()){
				page_s.setRecordlist(list);
			}else{
				page_s.setRecordlist(list.subList(0, page_s.getPageSize()));
			}
			return page_s;
		};
		
		List<Statistics> rList=new ArrayList(page_s.getPageSize());
		
		int num=0;
		for(Statistics s:list){
			if(unit.getUni_id()==s.getSta_participatedPerson().getParti_recommendUnit().getUni_id()){
				rList.add(s);
				num++;
				if(num==page_s.getPageSize()){
					break;
				}
			}
			
		}
		page_s.setRecordlist(rList);
		return page_s;
	}

	
}
