package com.atfuture.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atfuture.base.BaseAction;
import com.atfuture.domain.ParticipatedPerson;

@Controller
@Scope("prototype")
public class ParticipatedPersonAction extends BaseAction<ParticipatedPerson>{

	
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
}
