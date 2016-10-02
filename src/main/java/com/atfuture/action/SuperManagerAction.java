package com.atfuture.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.RequestCode;
import com.atfuture.domain.SuperManager;
import com.future.utils.GenerateString;

@Controller
@Scope("prototype")
public class SuperManagerAction extends BaseAction<SuperManager> implements RequestAware{

	private Map<String, Object> requestMap ; 
	
	/**
	 * 生成邀请码并进行显示
	 */
	public String generateRequestCode(){
		//生成十六位的字母加数字的组合，并进行回显,保证表中只有一个邀请码
		List<RequestCode> rqCodeList = requestCodeService.getAllRequestCodes();
		String requestCodeStr = GenerateString.generateRandomString(16);
		RequestCode requestCode = null;
		if(rqCodeList == null || rqCodeList.size() == 0){//不存在邀请码
			requestCode = new RequestCode();
			requestCode.setReqCode_info(requestCodeStr);
		}else{
			requestCode = requestCodeService.getSpecialRequestCode(1);
			requestCode.setReqCode_info(requestCodeStr);
		}
		requestCodeService.saveOrUpdateRequestCode(requestCode);
		requestMap.put("requestCode", requestCode.getReqCode_info());
		System.out.println("注册码是"+requestCode.getReqCode_info());
		return "RequestCodePublish";
	}

	//显示邀请码
	public String showRequestCode(){
		RequestCode requestCode = requestCodeService.getSpecialRequestCode(1);
		requestMap.put("requestCode", requestCode.getReqCode_info());
		return "RequestCodePublish";
	}

	
	
	public void setRequest(Map<String, Object> requestMap) {
			this.requestMap = requestMap;
	}
	
}
