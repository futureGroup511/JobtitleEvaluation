package com.atfuture.dao.impl;

import java.util.LinkedList;
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
		String hql="from Statistics statistics order by statistics.sta_participatedPerson.parti_specialty, statistics.sta_AllScored desc";
		// group by statistics.sta_participatedPerson.parti_specialty 
		List<Statistics> list=this.findEntityByHQL(hql);
		System.out.println(list.size());
		int temp=page_s.getCurrentPage()*page_s.getPageSize();
		if(specialty==null||"".equals(specialty.getSpec_id())||specialty.getSpec_id()<=0){
			if(page_s.getPageSize()>=list.size()){
				Page_S ps=new Page_S(page_s.getCurrentPage(),page_s.getPageSize(),list.size(),list);
				return ps;
			}else{
				Page_S ps=new Page_S(page_s.getCurrentPage(),page_s.getPageSize(),list.size(),list.subList(temp-page_s.getPageSize(), temp>list.size()?list.size():temp));
				return ps;
			}
		};
		List<Statistics> rList=new LinkedList();
		
		int num=0;
		for(Statistics s:list){
			if(specialty.getSpec_id()==s.getSta_participatedPerson().getParti_specialty().getSpec_id()){
				num++;
				if(num>temp){
					continue;
				}
				if(num>(temp-page_s.getPageSize())){
					rList.add(s);
				}
			}
		}
		Page_S ps=new Page_S(page_s.getCurrentPage(),page_s.getPageSize(),num,rList);
		return ps;
	}

	public Page_S getByUnit(Page_S page_s,Unit unit) {
		
		String hql="from Statistics statistics order by statistics.sta_participatedPerson.parti_recommendUnit,statistics.sta_AllScored desc";
		int temp=page_s.getCurrentPage()*page_s.getPageSize();
		List<Statistics> list=this.findEntityByHQL(hql);
		if(unit==null||"".equals(unit.getUni_id())||unit.getUni_id()<=0){
			if(page_s.getPageSize()>=list.size()){
				Page_S ps=new Page_S(page_s.getCurrentPage(),page_s.getPageSize(),list.size(),list);
				return ps;
			}else{
				Page_S ps=new Page_S(page_s.getCurrentPage(),page_s.getPageSize(),list.size(),list.subList(temp-page_s.getPageSize(), temp>list.size()?list.size():temp));
				return ps;
			}
		};
		List<Statistics> rList=new LinkedList();
		
		int num=0;
		for(Statistics s:list){
			if(unit.getUni_id()==s.getSta_participatedPerson().getParti_recommendUnit().getUni_id()){
				num++;
				if(num>temp){
					continue;
				}
				if(num>(temp-page_s.getPageSize())){
					rList.add(s);
				}
			}
		}
		Page_S ps=new Page_S(page_s.getCurrentPage(),page_s.getPageSize(),num,rList);
		return ps;
	}

	
}
