package com.atfuture.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class FileUpLoadUtils {

	
	/**
	 * zhaoshuo 
	 * 处理文件上传
	 */
	
	public static String processUploadFile(File compeProgramFile, String compeProgramFileFileName, String compeProgramFileContentType) throws IOException{
		if(compeProgramFile != null){
			String realPath = ServletActionContext.getServletContext().getRealPath("/UploadFile/");
			String fileprefix = compeProgramFileFileName.substring(0,compeProgramFileFileName.indexOf("."));
			//文件前缀 加上一个随机生成的uuid防止文件名重复
			//fileprefix = fileprefix+"_"+UUID.randomUUID();
			fileprefix  = "upload_"+UUID.randomUUID();
			//文件后缀
			String fileSuffix = compeProgramFileFileName.substring(compeProgramFileFileName.indexOf("."));
			
	System.out.println(fileprefix +":"+fileSuffix);
			
			File saveFile = new File(realPath, fileprefix+fileSuffix);
			FileUtils.copyFile(compeProgramFile, saveFile);
			return "/UploadFile/"+fileprefix+fileSuffix;
		}
		return null;
	}

	//把指定文件删除，并重新写入同名字的文件
	public static String processUploadFile(File compeProgramFile, String compeProgramFileFileName, String imageContentType,	String realPath) {
		System.out.println(realPath);
		File file = new File(realPath);
		if(file.exists()){
			file.delete();
		}
		try {
			FileUtils.copyFile(compeProgramFile, new File(realPath));
		} catch (IOException e) {
			System.out.println("文件复制发生错误");
			e.printStackTrace();
		}
		
		return null;
	}
}
