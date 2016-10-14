package com.atfuture.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.EvaluatedRecord;
import com.atfuture.domain.JobTitle;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.Specialty;
import com.atfuture.domain.Statistics;
import com.atfuture.domain.Unit;
import com.atfuture.utils.FileUpLoadUtils;
import com.atfuture.utils.Page_S;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ParticipatedPersonAction extends BaseAction<ParticipatedPerson> implements RequestAware, ServletRequestAware{

	private HttpServletRequest httpServletRequest;
	
	private Map<String, Object> requestMap;
	private InputStream inputStream;
	private String filename;
	private Integer currentPage=1;
	//上传文件相关
	 private File image; //上传的文件
	 private String imageFileName; //文件名称
	 private String imageContentType; //文件类型
	
	//管理参评人员信息 分页查询
	public String manageParticipatedPerson(){
		Integer recordCount = participatedPersonService.getAllParticipatedPerson().size();
		Integer pageSize = 2;
		if(currentPage == null || (currentPage+"").trim() == ""){
			currentPage = 1;
		}
		List<ParticipatedPerson> recordList = null; 
		Page_S page = new Page_S(currentPage, pageSize, recordCount, null);
		recordList = participatedPersonService.getParticipatedPersonByPage(page);
		page.setRecordlist(recordList);
		requestMap.put("pageBean", page);
		return "ManageParticipatedPerson";
	}
	
	//到达增加参评人员信息页面
	public String incrementParticipatedPerson(){
		
		List<JobTitle> jobTitleList = jobTitleService.getAllJobTitle();
		List<Specialty> specialtyList = specialtyService.getAllSpecialty();
		List<Unit> unitList = unitService.getAllUnit();
		requestMap.put("jobTitleList", jobTitleList);
		requestMap.put("specialtyList", specialtyList);
		requestMap.put("unitList", unitList);
		return "ToIncrementParticipatedPersonPage";
	}

	public String saveParticipatedPerson(){
		String imagePath;
		try {
			imagePath = FileUpLoadUtils.processUploadFile(image, imageFileName, imageContentType);
		} catch (IOException e) {
			//"请上传符合规范的文件，不要上传过大的文件";
			return "FileTypeNotAllowed";
		}
		model.setParti_pathurl(imagePath);
		participatedPersonService.addParticipatedPerson(model);
		return "RedirectManageParticipatedPerson";
	}
	
	private Integer parti_id;
	private ParticipatedPerson participatedPerson ;
	public String updateParticipatedPerson(){
		List<JobTitle> jobTitleList = jobTitleService.getAllJobTitle();
		List<Specialty> specialtyList = specialtyService.getAllSpecialty();
		List<Unit> unitList = unitService.getAllUnit();
		requestMap.put("jobTitleList", jobTitleList);
		requestMap.put("specialtyList", specialtyList);
		requestMap.put("unitList", unitList);
		participatedPerson = participatedPersonService.getParticipatedPersonById(parti_id);
		requestMap.put("participatedPerson", participatedPerson);
		requestMap.put("currentPage", currentPage);
		System.out.println("当前页数是"+currentPage);
		System.out.println(participatedPerson);
		return "ToUpdateParticipatedPerson";
	}
	
	public String updateParticipatedPersonSuccess(){
		System.out.println(currentPage);
		System.out.println(model);
		participatedPersonService.updateParticipatedPerson(model);
		return "RedirectManageParticipatedPersonToPage";
	}
	
	
//========================================================================	
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	
	//原做查看资料现在做下载文件
	public String lookResource() throws IOException{
		String realpath=ServletActionContext.getServletContext().getRealPath(getModel().getParti_pathurl());
		String path=new String(realpath.getBytes("GBK"),"ISO-8859-1");
		InputStream in=new FileInputStream(path);
		String[] name=realpath.split("\\\\");
		this.filename=name[name.length-1];
		this.setInputStream(in);
		return "lookResource" ;
	}
	
	
	
	
	
	//赵硕   新增功能  模块一
	private String participatedPersonName;
	//模糊查询某个申报人
	public String findParticipatedPersonByName(){
		
		List<Statistics> statisticList = null;
System.out.println(participatedPersonName);
/*if(new String(participatedPersonName).length() == participatedPersonName.getBytes().length){
	try {
		//对汉字进行解码 
		participatedPersonName = new String(participatedPersonName.getBytes("iso-8859-1"), "utf-8");
		System.out.println(participatedPersonName);
		participatedPersonName = URLDecoder.decode(participatedPersonName, "utf-8");
		System.out.println(participatedPersonName);
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
}*/

if(httpServletRequest.getMethod()=="GET"){
	try {
		participatedPersonName = URLDecoder.decode(URLDecoder.decode(participatedPersonName, "UTF-8"), "UTF-8");
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
}
		Integer pageSize = 2;
		statisticList= participatedPersonService.getParticipatedPersonByName(participatedPersonName);
		Integer recordCount = statisticList.size();
		Page_S pageBean = new Page_S(currentPage, pageSize, recordCount, null);
		statisticList = participatedPersonService.getParticipatedPersonByNameAndPage(participatedPersonName, pageBean);
	    pageBean.setRecordlist(statisticList);
	    requestMap.put("pageBean", pageBean);
	    requestMap.put("participatedPersonName", participatedPersonName);
		return "ParticipatedPersonListByName";
	}
	
	//查询得到某个人之后 ，进行 查询该参评人被 专家评议的信息记录
	private Integer participatedId;//参评人id
	private String familiarStatus;//熟悉度
	private String evalRecor_allAssessment;//总评
	public String fetchSpecialRecord(){
		
		//得到总评分为 ABCD的专家的人数
		//得到指定参评人被参评 的  专家评分为ABCD的 人数  返回 map  键为 A  B   C  D
		Map<String, Integer> expertNumMap = evaluatedRecordService.getExpertNumForSpec(participatedId);
		//该参评人的统计数据   
		Statistics statistics = statisticsService.findByPersonId(participatedId);
		ParticipatedPerson participatedPerson = participatedPersonService.findById(participatedId);
		requestMap.put("participatedPerson", participatedPerson);
		
		requestMap.put("statistics", statistics);
		requestMap.put("aScore", expertNumMap.get("A"));
		requestMap.put("bScore", expertNumMap.get("B"));
		requestMap.put("cScore", expertNumMap.get("C"));
		requestMap.put("dScore", expertNumMap.get("D"));
		System.out.println("A"+expertNumMap.get("A")+"B"+expertNumMap.get("B"));
		System.out.println("C"+expertNumMap.get("C")+"D"+expertNumMap.get("D"));
		
		requestMap.put("participatedId", participatedId);
		requestMap.put("familiarStatus", familiarStatus);
		requestMap.put("evalRecor_allAssessment", evalRecor_allAssessment);
		requestMap.put("currentPage", currentPage);
		/*if(participatedId != null && (participatedId+"").trim() != ""){
			requestMap.put("participatedId", participatedId);
		}
		if(familiarStatus== null || familiarStatus.trim() == ""){
			requestMap.put("familiarStatus", null);
			familiarStatus = null;
		}
		if(evalRecor_allAssessment == null || evalRecor_allAssessment.trim() == ""){
			requestMap.put("evalRecor_allAssessment", null);
			evalRecor_allAssessment = null;
		}
		if(currentPage == null || (currentPage+"").trim() == ""){
			requestMap.put("currentPage", 1);
		}
		*/
		Integer pageSize = 2;
		Integer recordCount = evaluatedRecordService.getRecordByCondition(participatedId, familiarStatus, evalRecor_allAssessment).size();
		Page_S pageBean = new Page_S(currentPage, pageSize, recordCount, null);
		List<EvaluatedRecord> recordList = evaluatedRecordService.getRecordByCondition(participatedId, familiarStatus, evalRecor_allAssessment, pageBean);
		pageBean.setRecordlist(recordList);
		requestMap.put("pageBean", pageBean);
		
		return "ParticipatedPersonInspectExperts";
	}
	
	
	
	
	
	public String lookPicture(){
		requestMap.put("parti_pathurl", getModel().getParti_pathurl());
		return "lookPicture";
	}
	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public Map<String, Object> getRequestMap() {
		return requestMap;
	}

	public void setRequestMap(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}

	public Integer getParti_id() {
		return parti_id;
	}

	public void setParti_id(Integer parti_id) {
		this.parti_id = parti_id;
	}

	public ParticipatedPerson getParticipatedPerson() {
		return participatedPerson;
	}

	public void setParticipatedPerson(ParticipatedPerson participatedPerson) {
		this.participatedPerson = participatedPerson;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	
	
	
//==============================================
//新增功能所需
//===============================================
	
	
	
	
	
	public String getParticipatedPersonName() {
		return participatedPersonName;
	}

	public void setParticipatedPersonName(String participatedPersonName) {
		this.participatedPersonName = participatedPersonName;
	}

	public Integer getParticipatedId() {
		return participatedId;
	}

	public void setParticipatedId(Integer participatedId) {
		this.participatedId = participatedId;
	}

	public String getFamiliarStatus() {
		return familiarStatus;
	}

	public void setFamiliarStatus(String familiarStatus) {
		this.familiarStatus = familiarStatus;
	}

	public String getEvalRecor_allAssessment() {
		return evalRecor_allAssessment;
	}

	public void setEvalRecor_allAssessment(String evalRecor_allAssessment) {
		this.evalRecor_allAssessment = evalRecor_allAssessment;
	}

	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	
	
	
	
	
	
}
