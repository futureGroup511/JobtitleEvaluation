<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加参评人员信息</title>
</head>
<body>
	<s:form action="participated_saveParticipatedPerson" enctype="multipart/form-data" method="post">
		申请人姓名：<input name="parti_name"><br/>
		所评职称：<s:select list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id" headerValue="==请选择==" headerKey="0" name="parti_jobTitle.jobTi_id"></s:select><br/>
		申报专业：<s:select list="#request.specialtyList" listValue="spec_name" listKey="spec_id" headerValue="==请选择==" headerKey="0" name="parti_specialty.spec_id"></s:select><br/>
		推荐单位：<s:select list="#request.unitList" listValue="uni_name" listKey="uni_id" headerValue="==请选择==" headerKey="0"  name="parti_recommendUnit.uni_id"></s:select><br/>
		个人资料上传：<input type="file" name="image">
		<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>