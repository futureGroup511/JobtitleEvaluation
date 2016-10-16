<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/liwen15.css">
<style type="text/css">
	.col-centered{
    float: none;
    margin: 0 auto;
}
</style>
</head>
<body>
		<form action="expert_modifyInformation"   class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2">
			<input type="hidden" value="${role.exp_accountNum}" id="num" name="sup_accountNum">
			<div class="row" style="margin-top:100px; margin-left:-10%;">
	        	<div class="col-lg-2 col-lg-offset-4 col-md-2 col-md-offset-4 col-xs-2 col-xs-offset-4"><p>原始密码：</p></div>
	            <div class="col-lg-3 col-md-3 col-xs-3" ><input type="password" class=" form-control "  id="oldpassword" onchange="jugeOldPassword('expert_jugePassword',2);"> </div>
	     	</div>
	     	
			<div class="row" style="margin-left:-10%;">
	        	<div class="col-lg-2 col-lg-offset-4 col-md-2 col-md-offset-4 col-xs-2 col-xs-offset-4"><p>新密码：</p></div>
	            <div class="col-lg-3 col-md-3 col-xs-3" ><input type="password"  class="form-control"  id="newpassword" onchange="compareInput();"> </div>
	     	</div>
	     	<div class="row" style="margin-left:-10%;">
	        	<div class="col-lg-2 col-lg-offset-4 col-md-2 col-md-offset-4 col-xs-2 col-xs-offset-4"><p>再次输入：</p></div>
	            <div class="col-lg-3 col-md-3 col-xs-3" ><input type="password"  class="form-control" name="exp_password" id="secondpassword" onchange="compareInput();"> </div>
	     	</div>
	     	<br>
	     	<div class="col-lg-5 col-lg-offset-3 col-md-3 col-md-offset-3 col-xs-3 col-xs-offset-3">
	     		<h3 class="text text-danger" id="information"></h3>
	     		<button class="btn btn-large  btn-primary" >确定修改</button>
	     	</div>
	     	
		</form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/modifyInformation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/asyncJuge.js"></script>
</html>