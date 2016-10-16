<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<link  rel="Shortcut Icon" href="images/zx1.ico">
<link rel="icon" href="images/zx1.ico" type="image/x-icon" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
</head>
<body>
	
	<a href="expert_allEvaluaTeacher">教职工评教</a>
	<a href="super_deleteInformation">删除参评人员数据和记录</a>
	<a href="super_lookInformation">管理员查看个人信息页面</a>
	<a href="expert_lookInformation">专家查看个人信息页面</a>
	<ol>
		<li><a href="super_generateRequestCode">生成邀请码</a></li>
		<li><a href="super_showRequestCode">查看当前邀请码</a></li>
	</ol>
	<ol>
		<li><a href="participated_manageParticipatedPerson">管理参评人员信息</a></li>
		<li><a href="jobTitleStandard_manageJobTitleStandard">管理职称申报标准信息</a></li>
		<li><a href="statistic_statisticAll">统计所有</a></li>
		<li><a href="evaluatedrecord_statisticByExpert">按指定专家统计</a></li>
		<li><a href="expert_manageExpertInfoList">专家信息管理</a></li>
		<li><a href="expert_registerExpert">专家注册</a></li>
	</ol>
	
</body>
</html>