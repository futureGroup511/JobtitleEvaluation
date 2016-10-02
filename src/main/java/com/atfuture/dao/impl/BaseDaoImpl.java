package com.atfuture.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atfuture.base.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T>  {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		/*ParameterizedType pType = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) pType.getActualTypeArguments()[0];*/
		Type type = this.getClass().getGenericSuperclass();
		if(!(type instanceof ParameterizedType)){
		    type = this.getClass().getSuperclass().getGenericSuperclass();
		}
		clazz = (Class<T>)((ParameterizedType)type).getActualTypeArguments()[0];
		System.out.println("======="+clazz);
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void saveEntity(T t) {
		getSession().save(t);
	}

	public void saveOrUpdateEntity(T t) {
		getSession().saveOrUpdate(t);
	}

	public void updateEntity(T t) {
		getSession().update(t);
	}

	public void deleteEntity(T t) {
		getSession().delete(t);
	}
	
	/**
	 * 按照HQL语句进行批量更新操作
	 */
	public void batchEntityByHQL(String hql, Object... objects) {
		Query query = getSession().createQuery(hql);
		for(int i=0;i<objects.length;i++){
			query.setParameter(i, objects[i]);
		}
		query.executeUpdate();
	}
	
	//执行原生的sql语句
	public void executeSQL(String sql, Object ...objects){
		SQLQuery sQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
		for(int i=0;i<objects.length;i++){
			sQuery.setParameter(i, objects[i]);
		}
		sQuery.executeUpdate();
	}
	
	//带返回值的类型的 
	//实现 sql查询
	public List executeSQLQuery(Class clazz,String sql, Object ...objects){
		SQLQuery sQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if(clazz!=null){//这样可以直接的将投影查询之后可以将数组包装成实体类型的数据格式
			sQuery.addEntity(clazz);
		}
		for(int i=0;i<objects.length;i++){
			sQuery.setParameter(i, objects[i]);
		}
		return sQuery.list();
	}

	public T loadEntity(Integer id) {
		return (T) getSession().load(clazz, id);
	}

	public T getEntity(Integer id) {
		return (T) getSession().get(clazz, id);
	}


	public List<T> findEntityByHQL(String hql, Object... objects) {
		Query query = getSession().createQuery(hql);
		for(int i=0;i<objects.length;i++){
			query.setParameter(i, objects[i]);
		}
		List<T> list = query.list();
		return list;
	}

	public Object uniqueResult(String hql, Object... objects) {
		Query query = getSession().createQuery(hql);
		for(int i=0;i<objects.length;i++){
			query.setParameter(i, objects[i]);
		}
		return query.uniqueResult();
	}

	
}
