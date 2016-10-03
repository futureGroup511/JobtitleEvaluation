<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专家注册页面</title>
</head>
<body>
<s:form action="expert_registerExpertToDB"  method="post">
		专家姓名：<input name="exp_name"><br/>
		账号：<input name="exp_accountNum"><br/>
		密码：<input name="exp_password"><br/>
		专业：<s:select list="#request.specialtyList" listValue="spec_name" listKey="spec_id" headerValue="==请选择==" headerKey="0" name="exp_specialty.spec_id"></s:select><br/>
		职称：<s:select list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id" headerValue="==请选择==" headerKey="0" name="exp_jobTitle.jobTi_id"></s:select><br/>
		学历：<input name="exp_educationLevel"><br/>
		所在单位：<s:select list="#request.unitList" listValue="uni_name" listKey="uni_id" headerValue="==请选择==" headerKey="0"  name="exp_unit.uni_id"></s:select><br/>
		<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>