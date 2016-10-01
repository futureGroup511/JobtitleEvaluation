package com.atfuture.base;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.service.TestService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class BaseAction extends ActionSupport{

	@Resource
	protected TestService testser; 
}
