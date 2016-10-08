package com.atfuture.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.JobTitle;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.Specialty;
import com.atfuture.domain.Unit;
import com.atfuture.utils.FileUpLoadUtils;
import com.atfuture.utils.Page_S;

@Controller
@Scope("prototype")
public class ParticipatedPersonAction extends BaseAction<ParticipatedPerson> implements RequestAware{

	
	private Map<String, Object> requestMap;
	private InputStream inputStream;
	private String filename;
	private Integer currentPage;
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
	
	
	
	
}
