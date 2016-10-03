package com.atfuture.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.EvaluatedStandard;
import com.atfuture.domain.Expert;
import com.atfuture.domain.JobTitle;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.RequestCode;
import com.atfuture.domain.Specialty;
import com.atfuture.domain.Unit;
import com.future.utils.Page_S;
@Controller
@Scope("prototype")
public class ExpertAction extends BaseAction<Expert> implements RequestAware{

	private Integer currentPage=1;
	private Integer pageSize=10;
	private ParticipatedPerson person=ParticipatedPerson.newInstance();
	//所有参评人员
	public String allEvaluaTeacher(){
		
		Page_S p=Page_S.newInstance();
		p.setCurrentPage(currentPage);
		p.setPageSize(pageSize);
		p=participatedPersonService.findAllParticipatedPerson(p,1);
		request.put("p", p);
		return "allEvaluaTeacher";
	}

	//审评
	public String assess(){
		EvaluatedStandard evaluatedStandard=evaluatedStandardService.findByJobTitleId(4);
		request.put("evaluatedStandard", evaluatedStandard);
		person=participatedPersonService.findById(person.getParti_id());
		request.put("person", person);
		return "assess";
	}
	
	
	
	//========================================
	
	//到达输入邀请码页面
	public String registerExpert(){
		return "InputRequestCodePage";
	}
	
	//到达专家注册页面
	private String requestCodeStr;
	public String checkRightToRegister(){
		RequestCode requestCode = requestCodeService.getSpecialRequestCode(1);
		if(requestCodeStr != null && requestCodeStr.trim() != "" && requestCodeStr.equals(requestCode.getReqCode_info())){
			List<JobTitle> jobTitleList = jobTitleService.getAllJobTitle();
			List<Specialty> specialtyList = specialtyService.getAllSpecialty();
			List<Unit> unitList = unitService.getAllUnit();
			request.put("jobTitleList", jobTitleList);
			request.put("specialtyList", specialtyList);
			request.put("unitList", unitList);
			return "ExpertRegisterPage";
		}
		return "RequestCodeWrong";
	}
	
	public String registerExpertToDB(){
		System.out.println(model);
		expertService.saveExpertInfo(model);
		return "ExpertRegisterSuccess";
	}
	public String manageExpertInfoList(){
		Integer recordCount = expertService.getAllExpert().size();
		Integer pageSize = 2;
		if(currentPage == null || (currentPage+"").trim() == ""){
			currentPage = 1;
		}
		List<Expert> recordList = null; 
		Page_S page = new Page_S(currentPage, pageSize, recordCount, null);
		recordList = expertService.getExpertByPage(page); 
		page.setRecordlist(recordList);
		request.put("pageBean", page);
		return "ManageExpertInfoPage";
	}
	//到达更新页面
	private Integer exp_id;
	public String updateExpertInfoPage(){
		Expert expert = expertService.findById(exp_id);
		request.put("expert", expert);
		request.put("currentPage", currentPage);
		List<JobTitle> jobTitleList = jobTitleService.getAllJobTitle();
		List<Specialty> specialtyList = specialtyService.getAllSpecialty();
		List<Unit> unitList = unitService.getAllUnit();
		request.put("jobTitleList", jobTitleList);
		request.put("specialtyList", specialtyList);
		request.put("unitList", unitList);
		return "ShowExpertInfoPage";
	}
	//更新记录
	public String updateExpertInfo(){
		System.out.println(model);
		expertService.updateExpertInfo(model);
		return "RedirectToManageExpertInfo";
	}
	
	
	
	
	
	
	
	public Integer getExp_id() {
		return exp_id;
	}

	public void setExp_id(Integer exp_id) {
		this.exp_id = exp_id;
	}

	public String getRequestCodeStr() {
		return requestCodeStr;
	}

	public void setRequestCodeStr(String requestCodeStr) {
		this.requestCodeStr = requestCodeStr;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	

	public ParticipatedPerson getPerson() {
		return person;
	}

	public void setPerson(ParticipatedPerson person) {
		this.person = person;
	}



	private Map<String, Object> request;
	public void setRequest(Map<String, Object> arg0) {
		request=arg0;
	}

	
	
}
