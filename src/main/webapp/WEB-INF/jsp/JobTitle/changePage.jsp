<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改职称</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/jobTitle_change.css">
</head>
<body>

<div class="dangqian">
  <div class="row">
        <div class="col-lg-3 col-lg-offset-5 col-md-5 col-md-offset-2 col-xs-6">
            <p><strong>当前位置：管理员>>修改职称</strong></p>
        </div>
        <div class="col-lg-2 col-md-3 col-xs-3">
            <p> <strong>欢迎  <s:property value="#session.role.helloName()"/>  登录本系统</strong></p>
        </div>
  </div>
</div>
<center>

<h1 class="remind">${remind }</h1>
<s:set name="remind" value=" " scope="session"></s:set>
</center>
<s:set name="remind" value=" " scope="session"></s:set>
<form class="form-horizontal" role="form" method="post" action="jobTitle_change">
    <div class="form-group">
       <label for="inputEmail3" class="col-lg-2 col-lg-offset-4 col-md-2 col-md-offset-4 col-xs-3 col-xs-offset-4 control-label">请输入要修改的职称：</label>
       <div class="col-lg-2 col-md-2 col-xs-3">
          <input type="text" class="form-control" id="inputEmail3" name="jobTitle.jobTi_name" placeholder="${findResult.jobTi_name }">
          <input type="hidden" name="jobTitle.jobTi_id" value="${findResult.jobTi_id }">
          <input type="hidden" name="page_s.currentPage" value="${pageNum}">
       </div>
       <div class="col-lg-2  col-md-2  col-xs-3 ">
           <button class="btn btn-primary" type="submit" >修改</button>
       </div>
    </div>
</form>
</body>
</html>