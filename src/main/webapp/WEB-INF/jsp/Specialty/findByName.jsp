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
<link rel="stylesheet" href="css/specialty_findResults.css">
</head>
<body>
<div class="dangqian">
  <div class="row">
    <div class="col-lg-1 col-lg-offset-1 col-md-2  col-xs-2 col-xs-offset-1">
            <a><p>专业管理</p></a>
        </div>
        <div class="col-lg-2 col-lg-offset-6 col-md-3 col-md-offset-3 col-xs-5  col-xs-offset-1">
            <p>当前位置：管理员>>搜索专业</p>
        </div>
        <div class="col-lg-2 col-md-3 col-xs-3">
            <p>欢迎登录本系统</p>
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
				
				<td>${jt.spec_name }</td>
				<td><a href="specialty_changePage?specialty.spec_id=${jt.spec_id }">修改</a></td>
				</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>