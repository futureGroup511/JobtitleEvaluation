<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专家注册验证页面</title>
</head>
<body>
	<s:form action="expert_checkRightToRegister" method="post">
		请输入邀请码：<input name="requestCodeStr"><br/>
		<s:submit value="确认"></s:submit>
	</s:form>
</body>
</html>