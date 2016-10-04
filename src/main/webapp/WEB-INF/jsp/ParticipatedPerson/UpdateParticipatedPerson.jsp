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
	<s:form action="participated_updateParticipatedPersonSuccess" method="post">
		<s:hidden name="currentPage" value="%{#request.currentPage}"></s:hidden>
		<s:hidden name="parti_id" value="%{#request.participatedPerson.parti_id}"></s:hidden>
		申请人姓名：<input type="text" name="parti_name" value="${requestScope.participatedPerson.parti_name }"><br/>
		所评职称：<s:select list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id" name="parti_jobTitle.jobTi_id" value="#request.participatedPerson.parti_jobTitle.jobTi_id"></s:select><br/>
		申报专业：<s:select list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="parti_specialty.spec_id" value="#request.participatedPerson.parti_specialty.spec_id"></s:select><br/>
		推荐单位：<s:select list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="parti_recommendUnit.uni_id" value="#request.participatedPerson.parti_recommendUnit.uni_id"></s:select><br/>
		<s:submit value="确定"></s:submit>
	</s:form>
</body>
</html>