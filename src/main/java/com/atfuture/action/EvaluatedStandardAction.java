package com.atfuture.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.EvaluatedStandard;

@Controller
@Scope("prototype")
public class EvaluatedStandardAction extends BaseAction<EvaluatedStandard> {

	
	public String UpdateJobTitleStandard(){
		System.out.println(model);
		evaluatedStandardService.updateEvaluatedStandard(model);
		return "JumpToJobTitleAction";
	}
	

}
