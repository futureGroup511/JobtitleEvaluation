<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专家注册验证页面</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/liwen8.css">
</head>
<body>
	<div class="dangqian">
  <div class="row">
        <div class="col-lg-2 col-lg-offset-6 col-md-3 col-md-offset-3 col-xs-5  col-xs-offset-1">
            <p><strong>当前位置：邀请码》》发布</strong></p>
        </div>
        <div class="col-lg-2 col-md-3 col-xs-3">
            <p><strong>欢迎  <s:property value="#session.role.helloName()"/> 登录本系统</strong></p>
        </div> 
  </div>
</div>
	<!-- <form class="form-horizontal" role="form">
    <div class="form-group">
       <label for="inputEmail3" class="col-lg-3 col-lg-offset-3 col-md-3 col-md-offset-3 col-xs-3 col-xs-offset-3 control-label">请输入邀请码（区分大小写，请注意！！！）：</label>
       <div class="col-lg-2 col-md-2 col-xs-3">
          <input type="email" class="form-control" id="inputEmail3" placeholder="12345678">
       </div>
       <div class="col-lg-2  col-md-2  col-xs-3 ">
           <button class="btn btn-primary" type="button" >确认</button>
       </div>
    </div>
</form> -->
	<s:form  class="form-horizontal" role="form" action="expert_checkRightToRegister" method="post">
	 <div class="form-group">
       <label for="inputEmail3" class="col-lg-3 col-lg-offset-3 col-md-3 col-md-offset-3 col-xs-3 col-xs-offset-3 control-label">请输入邀请码（区分大小写，请注意！！！）：</label>
       <div class="col-lg-2 col-md-2 col-xs-3">
       <!-- 	<input name="requestCodeStr"> -->
          <input  name="requestCodeStr"  class="form-control" id="inputEmail3" >
       </div>
       <div class="col-lg-2  col-md-2  col-xs-3 ">
         <!--   <button class="btn btn-primary" type="button" >确认</button> -->
			<s:submit class="btn btn-primary" value="确认"></s:submit>
       </div>
    </div>
		<!-- 请输入邀请码(区分大小写，请注意！！！)：<input name="requestCodeStr"><br/> -->
	</s:form>
</body>
</html>