package com.atfuture.base;

import java.util.List;

public interface BaseDao<T> {
	
	
	
//写操作
	public void saveEntity(T t);
	public void saveOrUpdateEntity(T t);
	
	//执行原生的sql语句
	public void executeSQL(String sql, Object ...objects);
	
	public void updateEntity(T t);
	public void deleteEntity(T t);
	public void batchEntityByHQL(String hql,Object ...objects);
	
	//读操作
	public T loadEntity(Integer id);
	public T getEntity(Integer id);
	public List<T> findEntityByHQL(String hql,Object ...objects);
	//单值检索
	public Object uniqueResult(String hql,Object ...objects);
	
	//实现 sql查询  并指定是否封装成指定的实体
	public List executeSQLQuery(Class clazz,String sql, Object ...objects);
	
}
