package com.atfuture.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.EvaluatedRecord;
@Controller
@Scope("prototype")
public class EvaluatedRecordAction extends BaseAction<EvaluatedRecord> {

}
