<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
</head>
<script type="text/javascript">
	function juge(){
		var juge=1;
		var role=$("select[ name='role']").val();
		var num=$("input[name='num']").val();
		var password=$("input[name='password']").val();
		var datas={
				"role":role,
				"num":num,
				"password":password
		}
		$.ajax({
				url:"loginAction_login",
				type:"post",
				async:false,
				data:datas,
				success:function(data){
					if(data==="success"){
						juge=2;
						$("#information").text("");
					}else if(data==="erro"){
						juge=1;
						$("#information").text("账号密码错误");
					}
				}
		});
		
		if(juge==2){
			return true;
		}
		return false;
	}
</script>
<body>
	<s:debug></s:debug>
	<form action="loginAction_finishLogin" method="post">
		角色:<select name="role">
				<option value="1">审评人员</option>
				<option value="2">管理员</option>
			 </select>
			 <br>
		账号:<input type="text" name="num"><br>
		密码:<input type="password" name="password"><br>
			<input type="submit" onclick="return juge();">
			<p id="information" style="color: red;"></p>
	</form>
	<a href="expert_allEvaluaTeacher">教职工评教</a>
	<a href="super_deleteInformation">删除参评人员数据和记录</a>
	<a href="expert_lookInformation">管理员查看个人信息页面</a>
	<a href="super_lookInformation">专家查看个人信息页面</a>
	<ol>
		<li><a href="super_generateRequestCode">生成邀请码</a></li>
		<li><a href="super_showRequestCode">查看当前邀请码</a></li>
	</ol>
	<ol>
		<li><a href="participated_manageParticipatedPerson">管理参评人员信息</a></li>
		<li><a href="jobTitleStandard_manageJobTitleStandard">管理职称申报标准信息</a></li>
		
	</ol>
	
</body>
</html>