<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查找结果</title>
</head>
<body>
<center>
	<h1>查找结果</h1>
	<table>
		<tbody>
			<tr>
				<td>单位ID</td>
				<td>单位名字</td>
				<td>修改</td>
			</tr>
			<c:forEach var="jt" items="${findResults }">
				<tr>
				<td>${jt.uni_id }</td>
				<td>${jt.uni_name }</td>
				<td><a href="unit_changePage?unit.uni_id=${jt.uni_id }">修改</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</center>
</body>
</html>