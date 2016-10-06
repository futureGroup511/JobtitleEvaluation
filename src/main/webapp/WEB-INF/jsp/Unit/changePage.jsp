<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改单位</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/unit_change.css">
</head>
<body>

<div class="dangqian">
  <div class="row">
        <div class="col-lg-3 col-lg-offset-5 col-md-5 col-md-offset-2 col-xs-6">
            <p>当前位置：管理员>>修改单位</p>
        </div>
        <div class="col-lg-2 col-md-3 col-xs-3">
            <p>欢迎<s:property value="#session.role.findSelfName()"/>登录本系统</p>
        </div>
  </div>
</div>
<center>
<s:debug></s:debug>
<h1 class="remind">${remind }</h1>
<s:set name="remind" value=" " scope="session"></s:set>
</center>
<s:set name="remind" value=" " scope="session"></s:set>
<form class="form-horizontal" role="form" method="post" action="unit_change">
    <div class="form-group">
       <label for="inputEmail3" class="col-lg-2 col-lg-offset-4 col-md-2 col-md-offset-4 col-xs-3 col-xs-offset-4 control-label">请输入要修改的名字：</label>
       <div class="col-lg-2 col-md-2 col-xs-3">
          <input type="text" class="form-control" id="inputEmail3" name="unit.uni_name" placeholder="${findResult.uni_name }">
          <input type="hidden" name="unit.uni_id" value="${findResult.uni_id }">
          <input type="hidden" name="page_s.currentPage" value="${pageNum}">
       </div>
       <div class="col-lg-2  col-md-2  col-xs-3 ">
           <button class="btn btn-primary" type="submit" >修改</button>
       </div>
    </div>
</form>
</body>
</html>