package com.atfuture.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.JobTitle;
import com.atfuture.domain.ParticipatedPerson;
import com.atfuture.domain.Specialty;
import com.atfuture.domain.Unit;
import com.future.utils.FileUpLoadUtils;
import com.future.utils.Page_S;

@Controller
@Scope("prototype")
public class ParticipatedPersonAction extends BaseAction<ParticipatedPerson> implements RequestAware{

	
	private Map<String, Object> requestMap;
	
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

	
	//查看资料
	public InputStream getInputStream() throws IOException{
		File f=new File("E://shuju.png");
		/*HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("multipart/form-data");
		ServletOutputStream  out=response.getOutputStream();
		FileInputStream in=new FileInputStream(f);
		byte[] data=new byte[1024];
		int length=0;
		while((length=in.read(data))!=-1){
			out.write(data, 0, length);
		}
		out.flush();
		in.close();
		out.close();*/
		FileInputStream in=new FileInputStream(f);
		BufferedInputStream bis=new BufferedInputStream(in);
		return bis;
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
	
	
}
