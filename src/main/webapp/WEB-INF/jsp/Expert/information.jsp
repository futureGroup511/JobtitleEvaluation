<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息页面</title>
</head>
<body>
	<form action="">
		姓名:<input type="text" value="${ expert.exp_name}" readonly="readonly"><br>
		账号:<input type="text" value="${ expert.exp_accountNum}" readonly="readonly"><br>
		密码:<input type="text" value="${ expert.exp_password}" readonly="readonly"><br>
		专业:<input type="text" value="${ expert.exp_specialty.spec_name}" readonly="readonly"><br>
		职称:<input type="text" value="${ expert.exp_jobTitle.jobTi_name}" readonly="readonly"><br>
		学历:<input type="text" value="${ expert.exp_educationLevel}" readonly="readonly"><br>
		单元:<input type="text" value="${ expert.exp_unit.uni_name}" readonly="readonly"><br>
	</form>
</body>
</html>