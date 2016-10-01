package com.atfuture.base;

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
@Controller
@Scope("prototype")
public class BaseAction extends ActionSupport{

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
	
	
	
	
}
