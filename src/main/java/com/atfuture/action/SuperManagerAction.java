package com.atfuture.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.RequestCode;
import com.atfuture.domain.SuperManager;
import com.atfuture.utils.GenerateString;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class SuperManagerAction extends BaseAction<SuperManager> implements RequestAware,SessionAware{

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
	//查看个人信息
	public String lookInformation(){
		return "lookInformation";
	}
	
	//修改个人信息
	public String modifyInformationView(){
		return "modifyInformationView";
	}
	
	public String modifyInformation(){
		SuperManager superManager=(SuperManager) session.get("role");
		superManager=superManagerService.findById(superManager.getSup_id());
		superManager.setSup_password(getModel().getSup_password());
		superManagerService.save(superManager);
		return "modifyInformation";
	}
	public String deleteInformation(){
		String path=ServletActionContext.getServletContext().getRealPath("UploadFile");
		File file=new File(path);
        File[] files=file.listFiles();
        for (File f:files){
        	if(f.exists()) f.delete();
        }
		participatedPersonService.deleteAll();
		return "deleteInformation";
	}
	
	//确定密码是否相同
	public String jugePassword(){
		SuperManager superManager=getModel();
		superManager=superManagerService.findByNumAndPassword(superManager.getSup_accountNum(), superManager.getSup_password());
		if(superManager!=null)ActionContext.getContext().getValueStack().push("success");
		else ActionContext.getContext().getValueStack().push("erro");
		return "jugePassword";
	}
	
	public void setRequest(Map<String, Object> requestMap) {
			this.requestMap = requestMap;
	}

	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> arg0) {
		session=arg0;
	}
	
}
