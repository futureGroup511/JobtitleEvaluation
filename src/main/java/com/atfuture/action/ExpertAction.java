package com.atfuture.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.EvaluatedStandard;
import com.atfuture.domain.Expert;
import com.atfuture.domain.JobTitle;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.RequestCode;
import com.atfuture.domain.Specialty;
import com.atfuture.domain.Statistics;
import com.atfuture.domain.Unit;
import com.future.utils.StringUtils;
import com.atfuture.utils.Page_S;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class ExpertAction extends BaseAction<Expert> implements RequestAware,SessionAware, ParameterAware{
	//批量导入专家信息的 数量大小
	private static final Integer bashRegisterSize = 8;
	private Integer currentPage=1;
	private Integer pageSize=10;
	private ParticipatedPerson person=ParticipatedPerson.newInstance();
	private Map<String, String[]> paramMap;
	//所有参评人员
	public String allEvaluaTeacher(){
		Expert expert=(Expert) session.get("role");
		Page_S p=Page_S.newInstance();
		p.setCurrentPage(currentPage);
		p.setPageSize(pageSize);
		p=participatedPersonService.findAllParticipatedPerson(p,expert.getExp_id());
		request.put("p", p);
		return "allEvaluaTeacher";
	}

	//审评
	public String assess(){
		person=participatedPersonService.findById(person.getParti_id());
		EvaluatedStandard evaluatedStandard=evaluatedStandardService.findByJobTitleId(person.getParti_jobTitle().getJobTi_id());
		request.put("evaluatedStandard", evaluatedStandard);
		person=participatedPersonService.findById(person.getParti_id());
		request.put("person", person);
		return "assess";
	}
	
	//查看个人信息
	public String lookInformation(){
		return "lookInformation";
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
	
	//到达批量注册专家信息 页面
	public String bashRegisterExpert(){
		List<JobTitle> jobTitleList = jobTitleService.getAllJobTitle();
		List<Specialty> specialtyList = specialtyService.getAllSpecialty();
		List<Unit> unitList = unitService.getAllUnit();
		request.put("jobTitleList", jobTitleList);
		request.put("specialtyList", specialtyList);
		request.put("unitList", unitList);
		return "BashRegisterExpertPage";
	}
	
	
	/**
	 * <tr>
				<td><input class="expName_0" name="expName_0"/></td>
				<td><input class="expNum_0" name="expNum_0" onblur="queryCompeName(this)"></td>
				<td><s:select class="form-control" list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="expUnit_0"></s:select></td>
				<td><s:select class="form-control" list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="expSpe_0"></s:select></td>
				<td><s:select class="form-control" list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id"  name="expJobTi_0"></s:select></td>
				<td><input class="expEdu_0" name="expEdu_0"></td>
			</tr>
	 */
	
	//批量注册专家信息的保存
	public String bashRegisterrToDb(){
		for(int i=0;i<bashRegisterSize;i++){
			//姓名  账号   学历信息，只有有一个为空就放弃该条数据不进行录入 
			String expName = StringUtils.isValidArr(paramMap.get("expName_"+i))?paramMap.get("expName_"+i)[0]+"":null;
			String expNum = StringUtils.isValidArr(paramMap.get("expNum_"+i))?paramMap.get("expNum_"+i)[0]+"":null;
			String expEdu = StringUtils.isValidArr(paramMap.get("expEdu_"+i))?paramMap.get("expEdu_"+i)[0]+"":null;
			String[] strArr = {expName, expNum, expEdu};
			if(StringUtils.isInvalidArr(strArr)){
				Expert expert = new Expert();
				expert.setExp_name(expName);
				expert.setExp_accountNum(expNum);
				expert.setExp_educationLevel(expEdu);
				expert.setExp_password("123");
				Integer unitId = Integer.parseInt(paramMap.get("expUnit_"+i)[0]+"");
				Integer speId = Integer.parseInt(paramMap.get("expSpe_"+i)[0]+"");
				Integer jobTiId = Integer.parseInt(paramMap.get("expJobTi_"+i)[0]+"");
				Unit unit = new Unit();
				unit.setUni_id(unitId);
				Specialty specialty = new Specialty();
				specialty.setSpec_id(speId);
				JobTitle jobTitle = new JobTitle();
				jobTitle.setJobTi_id(jobTiId);
				expert.setExp_unit(unit);
				expert.setExp_specialty(specialty);
				expert.setExp_jobTitle(jobTitle);
				expertService.saveExpertInfo(expert);
				 
			}else{  //放弃该组数据
				continue;
			}
		}
		return "RedirectToExpertPage";
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
	
	
	
	//查找指定账号的专家是否存在
	private String accountNum;
	private boolean accountNumExists = false;
	public String querySpecialAccountNum(){
System.out.println(accountNum);
		Expert expert = expertService.querySpecialExpertByAccountNum(accountNum);
		if(expert != null){
			accountNumExists = true;
		}
System.out.println(accountNumExists);
		try {
			ServletActionContext.getResponse().getWriter().print(accountNumExists);
		} catch (IOException e) {
			System.out.println("querySpecialAccountNum方法出错");
			e.printStackTrace();
		}
		return null;
	}
	//判断原密码
	public String jugePassword(){
		Expert expert=getModel();
		expert=expertService.findByNumAndPassword(expert.getExp_accountNum(), expert.getExp_password());
		if(expert!=null) ActionContext.getContext().getValueStack().push("success");
		else ActionContext.getContext().getValueStack().push("erro");
		return "jugePassword";
	}
	public String modifyInformationView(){
		return "modifyInformationView";
	}
	
	public String modifyInformation(){
		Expert expert=(Expert) session.get("role");
		expert=expertService.findById(expert.getExp_id());
		expert.setExp_password(getModel().getExp_password());
		expertService.save(expert);
		return "modifyInformation";
	}
	
	
	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
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
	
	
	private Map<String, Object> session;
	public void setSession(Map<String, Object> arg0) {
		session=arg0;
	}

	public void setParameters(Map<String, String[]> paramMap) {
		this.paramMap = paramMap;
	}

}
