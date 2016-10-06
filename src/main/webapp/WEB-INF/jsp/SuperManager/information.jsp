<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息页面</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/liwen15.css">
</head>
<body>
	<div class="dangqian">
	   <div class="row">
	        <div class="col-lg-3 col-lg-offset-5 col-md-5 col-md-offset-2 col-xs-6">
	            <p><strong>当前位置：管理员>>个人信息</strong></p>
	        </div>
	        <div class="col-lg-2 col-md-3 col-xs-3">
	            <p><strong>欢迎  <s:property value="#session.role.helloName()"/>  登录本系统</strong></p>
	        </div>
	    </div>
	</div>
	<form action="">
		<div class="row">
        	<div class="col-lg-1 col-lg-offset-2 col-md-2 col-md-offset-3 col-xs-2 col-xs-offset-2"><p>姓名：</p></div>
            <div class="col-lg-2 col-md-2 col-xs-3" style="margin-left:-12%;"><input type="text" value="${ role.sup_name}" readonly="readonly" class="form-control"> </div>
            <div class="col-lg-1 col-lg-offset-1 col-md-2 col-md-offset-1 col-xs-2 col-xs-offset-1"><p>账号：</p></div>
            <div class="col-lg-2 col-md-2 col-xs-3" style="margin-left:-12%;"><input type="text" value="${ role.sup_accountNum}" readonly="readonly" class="form-control"> </div>
     </div>
     <div class="row">
        	<%-- <div class="col-lg-1 col-lg-offset-2 col-md-2 col-md-offset-3 col-xs-2 col-xs-offset-2"><p>密码：</p></div> 
            <div class="col-lg-2 col-md-2 col-xs-3"><input type="text" value="${ role.sup_password}" readonly="readonly" class="form-control"></div>
		     --%>
     </div> 
	</form>
</body>
</html>