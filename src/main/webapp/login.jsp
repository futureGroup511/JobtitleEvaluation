<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
<link href="${pageContext.request.contextPath}/css/denglu.css" rel="stylesheet" >
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>

</head>
<body>
<div id="nav">
    <div class="left">
        <img src="images/header-logo.png"> 
        <span>河南科技学院职称评审专家网评系统</span>
    </div>
</div>

<form action="loginAction_finishLogin" method="post">
   <div id="banous">
       <div class="one">
          <div class="col-lg-7 col-lg-offset-2 col-md-2 col-md-offset-2 col-xs-2 col-xs-offset-2">
           <img src="images/xiaoren.png"> </div>
       </div>
       <div class="col-lg-4 col-md-3 col-xs-3">
          <div class="right">
        	  <div class="input-one">
	        		  <div class="input-group">
	            		  <div class="input-group-addon"><span>身份</span></div>
	    		               <select name="role" class="form-control input-lg">
				                     <option value="1">审评人员</option>
									 <option value="2">管理员</option>
	             			</select>
	            	   </div>
                    </div>
                    <div class="input-two">
        		        <div class="input-group">
                            <div class="input-group-addon"><a><img src="images/yonghu.png" ></a></div>
                             	<input type="text" class="form-control" name="num" placeholder="账号">
                            </div>
                    </div>
                    <div class="input-three">
            	         <div class="input-group">
                              <div class="input-group-addon"><a><img src="images/mima.png"></a></div>
                              <input type="password" class="form-control" name="password" placeholder="密码">
                          </div>
                    </div>
                    <button class="btn btn-large btn-block btn-primary" onclick="return juge();">登录</button>
                    <a class="btn btn-large btn-block btn-primary" href="expert_registerExpert" target="right">专家注册</a>
                    <div class="passwordOrAccountWrong">
                    	<h3 id="information" class="text text-danger col-md-offset-2" ></h3>
                    </div>
        	</div>
        </div>
    </div>
    
</form>
<div id="footer">
    	<p>版权所有&emsp;&emsp;河南科技学院&emsp;&emsp;河南省新乡市华兰大道东段&emsp;453003</p>
    </div>
</body>

</html>