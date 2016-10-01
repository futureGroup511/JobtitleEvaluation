package com.atfuture.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.atfuture.base.BaseAction;
import com.atfuture.base.BaseDao;
import com.atfuture.dao.SuperManagerDao;

@Controller
@Scope("prototype")
public class SuperManagerAction extends BaseAction {

}
