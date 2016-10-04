<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
	//得到url的根路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path +"/";
	%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改专家信息</title>
</head>
<body>
	<s:form action="expert_updateExpertInfo"  method="post">
		<s:hidden name="currentPage" value="%{#request.currentPage}"></s:hidden>
		<s:hidden name="exp_id" value="%{#request.expert.exp_id}"></s:hidden>
		专家姓名：<input name="exp_name" value="${request.expert.exp_name }"><br/>
		账号：<input name="exp_accountNum" value="${request.expert.exp_accountNum }"><br/>
		专业：<s:select list="#request.specialtyList" listValue="spec_name" listKey="spec_id" name="exp_specialty.spec_id" value="#request.expert.exp_jobTitle.jobTi_id"></s:select><br/>
		职称：<s:select list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id"  name="exp_jobTitle.jobTi_id" value="#request.expert.exp_specialty.spec_id"></s:select><br/>
		学历：<input name="exp_educationLevel" value="${request.expert.exp_educationLevel }"><br/>
		所在单位：<s:select list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="exp_unit.uni_id" value="#request.expert.exp_unit.uni_id"></s:select><br/>
		<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>