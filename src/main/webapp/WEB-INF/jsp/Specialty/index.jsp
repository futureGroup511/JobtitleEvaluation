<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专业管理-Specialty</title>
</head>
<body>
	<center>
	<h1>专业管理-Specialty</h1>
	<hr>
	<h1 color="red">${remind }</h1>
	<s:set name="remind" value=" " scope="session"></s:set>
	<hr>
	<h2>增加专业</h2>
	<form method="post" action="specialty_add">
		专业名字:<input name="specialty.spec_name" size="50">
		<input type="submit" value="增加">
	</form>
	<hr>
	<h2>查看、管理(修改)专业</h2>
		<form action="specialty_findByName" method="post">
			请输入要管理的专业的名字:<input type="text" name="specialty.spec_name" size="50">
			<input type="submit" value="查找">
		</form>
	<hr>
	<h2><a href="specialty_page_s?page_s.currentPage=1">查看所有专业</a></h2>
	
	</center>
</body>
</html>