<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查找结果</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/unit_findResults.css">
</head>
<body>
<div class="dangqian">
  <div class="row">
        <div class="col-lg-3 col-lg-offset-5 col-md-5 col-md-offset-2 col-xs-6">
            <p><strong>当前位置：管理员>>搜索单位</strong></p>
        </div>
        <div class="col-lg-2 col-md-3 col-xs-3">
            <p><strong>欢迎  <s:property value="#session.role.helloName()"/>  登录本系统</strong></p>
        </div>
  </div>
</div>
<table class="table table-bordered table-hover">
	<tbody>
		<tr>
			<td>单位名字</td>
			<td>修改</td>
		</tr>
		<c:forEach var="jt" items="${findResults }">
				<tr>
				
				<td>${jt.uni_name }</td>
				<td><a href="unit_changePage?unit.uni_id=${jt.uni_id }">修改</a></td>
				</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>