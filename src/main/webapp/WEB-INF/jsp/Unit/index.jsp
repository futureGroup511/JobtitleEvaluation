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
<link rel="stylesheet" href="css/unit.css">

</head>
<body>
	<%-- <center>
	
	<form method="post" action="unit_add">
		单位名字:<input name="unit.uni_name" size="50">
		<input type="submit" value="增加">
	</form>
	<hr>
	<h2>查看、管理(修改)单位</h2>
		<form action="unit_findByName" method="post">
			请输入要管理的单位的名字:<input type="text" name="unit.uni_name" size="50">
			<input type="submit" value="查找">
		</form>
	<hr>
	<h2><a href="unit_page_s?page_s.currentPage=1">查看所有单位</a></h2>
	</center> --%>
	<div class="dangqian">
	  <div class="row">
	    <div class="col-lg-1 col-lg-offset-1 col-md-2  col-xs-2 col-xs-offset-1">
	            <a><p>单位管理</p></a>
	        </div>
	        <div class="col-lg-2 col-lg-offset-6 col-md-3 col-md-offset-3 col-xs-5  col-xs-offset-1">
	            <p>当前位置：****>>单位管理</p>
	        </div>
	        <div class="col-lg-2 col-md-3 col-xs-3">
	            <p>欢迎登录本系统</p>
	        </div>
	  </div>
	</div>
	
	<div id="do_">
		<center>
		<h1 class="remind">${remind }</h1>
		</center>
		<s:set name="remind" value=" " scope="session"></s:set>
		
		<div id="view">
			<hr>
			<h3 class="do_title">查看单位</h3>
			<center>
			<a class="view_a" href="unit_page_s?page_s.currentPage=1"><h4>点击这里查看所有单位</h4></a>
			</center>
		</div>
		
		<div id="add">
			<hr>
			<h3 class="do_title">增加单位</h3>
			<form class="form-horizontal" role="form" method="post" action="unit_add">
		    <div class="form-group">
		       <label for="inputEmail3" class="col-lg-2 col-lg-offset-4 col-md-2 col-md-offset-4 col-xs-3 col-xs-offset-4 control-label">要增加的单位名字：</label>
		       <div class="col-lg-2 col-md-2 col-xs-3">
		          <input type="text" class="form-control" id="inputEmail3" placeholder="单位名称" name="unit.uni_name">
		       </div>
		       <div class="col-lg-2  col-md-2  col-xs-3 ">
		           <button class="btn btn-primary" type="submit" >增加</button>
		       </div>
		    </div>
			</form>
		</div>
		
		<div id="manage">
			<hr>
			<h3 class="do_title">修改单位</h3>
			<form class="form-horizontal" role="form">
			    <div class="form-group">
			       <label for="inputEmail3" class="col-lg-2 col-lg-offset-4 col-md-2 col-md-offset-4 col-xs-3 col-xs-offset-4 control-label">要修改的单位名字：</label>
			       <div class="col-lg-2 col-md-2 col-xs-3">
			          <input type="text" class="form-control" id="inputEmail3" placeholder="输入名字进行搜索" name="unit.uni_name">
			       </div>
			       <div class="col-lg-2  col-md-2  col-xs-3 ">
			           <button class="btn btn-primary" type="submit" >搜索</button>
			       </div>
			    </div>
			</form>
		</div>
		
		
	
	</div>
	
	
	
	<hr>
</body>
</html>