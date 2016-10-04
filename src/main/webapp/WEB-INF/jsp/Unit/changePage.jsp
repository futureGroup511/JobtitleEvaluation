<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改单位</title>
</head>
<body>
<center>
	<h1>修改单位</h1>
	<hr>
	<h1 color="red">${remind }</h1>
	<s:set name="remind" value=" " scope="session"></s:set>
	<hr>
	<form method="post" action="unit_change">
	请输入要修改的名字:<input type="text" name="unit.uni_name" size="50" placeholder="${findResult.uni_name }">
	<input type="hidden" name="unit.uni_id" value="${findResult.uni_id }">
	<input type="submit" value="修改">
	</form>
</center>
</body>
</html>