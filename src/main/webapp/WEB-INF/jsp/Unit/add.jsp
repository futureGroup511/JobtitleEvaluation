<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单位管理</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/unit_index.css">

</head>
<body>
	<center>
	<h1 class="remind">${remind }</h1>
	<s:set name="remind" value=" " scope="session"></s:set>
	</center>
	<div class="dangqian">
	  <div class="row">

	        <div class="col-lg-3 col-lg-offset-5 col-md-5 col-md-offset-2 col-xs-6">
	            <p><strong>当前位置：管理员>>单位管理</strong></p>
	        </div>
	        <div class="col-lg-2 col-md-3 col-xs-3">
	            <p><strong>欢迎<s:property value="#session.role.helloName()"/> 登录本系统</strong></p>
	        </div>
	  </div>
	</div>
	
	<div id="do_">
		<div id="add">
			<hr>
			<h3 class="do_title">增加单位</h3>
			<form class="form-horizontal" role="form" method="post" action="unit_add">
		    <div class="form-group">
		       <label for="inputEmail3" class="col-lg-2 col-lg-offset-4 col-md-2 col-md-offset-4 col-xs-3 col-xs-offset-4 control-label">要增加的单位名字：</label>
		       <div class="col-lg-2 col-md-2 col-xs-3">
		          <input type="text" class="form-control" id="inputEmail3" maxlength="50" placeholder="单位名称" name="unit.uni_name">
		       </div>
		       <div class="col-lg-2  col-md-2  col-xs-3 ">
		           <button class="btn btn-primary" type="submit" >增加</button>
		       </div>
		    </div>
			</form>
		</div>
	</div>
</body>
</html>