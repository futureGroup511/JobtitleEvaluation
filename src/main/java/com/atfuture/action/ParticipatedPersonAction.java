package com.atfuture.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.base.BaseDao;
import com.atfuture.dao.ParticipatedPersonDao;

@Controller
@Scope("prototype")
public class ParticipatedPersonAction extends BaseAction{

}