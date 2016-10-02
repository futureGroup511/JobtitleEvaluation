package com.atfuture.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.service.EvaluatedRecordService;
import com.atfuture.service.EvaluatedStandardService;
import com.atfuture.service.ExpertService;
import com.atfuture.service.JobTitleService;
import com.atfuture.service.ParticipatedPersonService;
import com.atfuture.service.SpecialtyService;
import com.atfuture.service.StatisticsService;
import com.atfuture.service.SuperManagerService;
import com.atfuture.service.TestService;
import com.atfuture.service.UnitService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>,Preparable{

	@Resource
	protected TestService testser; 
	@Resource
	protected EvaluatedRecordService evaluatedRecordService; 
	@Resource
	protected EvaluatedStandardService evaluatedStandardService;
	@Resource
	protected ExpertService expertService;
	@Resource
	protected JobTitleService jobTitleService;
	@Resource
	protected ParticipatedPersonService participatedPersonService;
	@Resource
	protected SpecialtyService specialtyService;
	@Resource
	protected StatisticsService statisticsService;
	@Resource
	protected SuperManagerService superManagerService;
	@Resource
	protected UnitService unitService;
	
	protected T model;
	public BaseAction(){
		try {
			Type type = this.getClass().getGenericSuperclass();
			if(!(type instanceof ParameterizedType)){
			    type = this.getClass().getSuperclass().getGenericSuperclass();
			}
			Class clazz = (Class<T>)((ParameterizedType)type).getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void prepare() throws Exception {}

	public  T getModel(){
		return model;
	}
	
		
	
	
}
