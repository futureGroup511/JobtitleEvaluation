<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看邀请码</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/pingzhicheng.css">
</head>
<body>

	<%-- 邀请码是：
	${requestScope.requestCode }
	请告知需要注册的专家，使用此注册码进行注册 --%>
	<div id="banous">
     <div class="one">
       <img src="images/LittlePerson.png"/>
     </div>
     <div class="two">
       <p class="three">邀请码是：${requestScope.requestCode }</p>
       <p class="four">请告知需要注册的专家，使用此注册码进行注册</p>
     </div>
</div>
</body>
</html>