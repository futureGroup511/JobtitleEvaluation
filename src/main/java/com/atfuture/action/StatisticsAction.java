package com.atfuture.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.Statistics;

@Controller
@Scope("prototype")
public class StatisticsAction extends BaseAction<Statistics>{

}
