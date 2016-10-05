<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/caidan.css">
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript">
	function juge(){
	 var juge=confirm("确定删除数据么?");
	 if(juge){
		return true; 
	 }
	 return false;
	}
	
	
</script>
</head>
<body id="bg">
	<div class="container">
    <div class="leftsidebar_box">
        <div class="line"></div>
        	
        	<s:if test="	#session.expert != null">
        	
        	<dl class="channel">
        		<dt>评教<img src="images/select_xl01.png"></dt>
        		<dd><a href="expert_allEvaluaTeacher" target="right">教职工评教</a></dd>
        	</dl>
        	<dl>
        		<dt>查看个人信息<img src="images/select_xl01.png"></dt>
        		<dd><a href="expert_lookInformation" target="right">个人信息</a></dd>
        	</dl>
        
        	</s:if>
        
        
        	<c:if test="${ sessionScope.superManager != null}">
        		<dl class="channel">
           		<dt>专家管理<img src="images/select_xl01.png"></dt>
           		<dd><a href="expert_manageExpertInfoList" target="right">专家信息管理</a></dd>
	           	</dl>
	           	 <dl class="channel">
	           	 	<dt>参评人员信息管理<img src="images/select_xl01.png"></dt>
	           	 	<dd><a href="super_deleteInformation" target="right" onclick="return juge();">删除参评人员数据和记录</a></dd>
	           	 	<dd><a href="participated_manageParticipatedPerson" target="right">管理参评人员信息</a></dd>
	           	 </dl>
	           	 <dl class="channel">
	           	 	<dt>邀请码管理<img src="images/select_xl01.png"></dt>
	           	 	<dd><a href="super_generateRequestCode" target="right">生成邀请码</a></dd>
	          		<dd><a href="super_showRequestCode" target="right">查看当前邀请码</a></dd>
	           	 </dl>
	           	 <dl class="channel">
	           	 	<dt>职称管理<img src="images/select_xl01.png"></dt>
	           	 	<dd><a href="jobTitleStandard_manageJobTitleStandard" target="right">管理职称申报标准信息</a></dd>
	           	 	<dd><a href="jobTitle" target="right">查看、管理职称</a></dd>
	           	 	
	           	 </dl>
	             <dl>
	             	<dt>统计<img src="images/select_xl01.png"></dt>
	             	<dd><a href="statistic_statisticAll" target="right">统计所有</a></dd>
	            	<dd><a href="evaluatedrecord_statisticByExpert" target="right">按指定专家统计</a></dd>
	             </dl>
	            <dl>
	            	<dd><a href="super_lookInformation" target="right">管理员查看个人信息页面</a></dd>
	            </dl>
	            <dl class="channel">
	            	<dt>单位管理<img src="images/select_xl01.png" ></dt>
	            	<dd><a href="unit" target="right">查看、管理职称</a></dd>
	            </dl>
	            <dl class="channel">
	            	<dt>专业管理<img src="images/select_xl01.png"></dt>
	            	<dd><a href="specialty" target="right">查看、管理职称</a></dd>
	            </dl>
        	</c:if>
            
            <dl class="channel">
	            	<dt>退出登陆<img src="images/select_xl01.png" ></dt>
	            	<dd><a href="loginAction_loginOut" target="_top">退出登陆</a></dd>
	           </dl>
            	
            	
            	
           		
           		
    </div>

</div>
<script type="text/javascript">

$(".leftsidebar_box dt").css({"background-color":"#1E68B5"});
$(".leftsidebar_box dt img").attr("src","images/select_xl01.png");
$(function(){
    $(".leftsidebar_box dd").hide();
    $(".leftsidebar_box dt").click(function(){
        $(".leftsidebar_box dt").css({"background-color":"#1E68B5"})
        $(this).css({"background-color": "#238AE3"});
        $(this).parent().find('dd').removeClass(("menu_chioce"),6000);
        $(".leftsidebar_box dt img").attr("src","images/select_xl01.png");
        $(this).parent().find('img').attr("src","images/select_xl01.png");
        $(".menu_chioce").slideUp();
        $(this).parent().find('dd').slideToggle();
    $(this).parent().find('dd').addClass("menu_chioce");
})
})
</script>
</body>

</html>