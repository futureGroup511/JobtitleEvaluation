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
        	
        	<s:if test="#session.role.findSelfName() == 'expert'">
	        	<dl class="channel">
	        		<dt><a style="color:white" href="expert_allEvaluaTeacher" target="right">在线评审<img src="images/select_xl01.png"></a></dt>
	        		<!-- <dd><a href="expert_allEvaluaTeacher" target="right">教职工评审</a></dd> -->
	        	</dl>
	        	<dl>
	        		<dt><a style="color:white" href="expert_lookInformation" target="right">查看个人信息<img src="images/select_xl01.png"></a></dt>
	        		<!-- <dd><a href="expert_lookInformation" target="right">个人信息</a></dd> -->
	        	</dl>
	        	<dl>
	        		<dt><a style="color:white" href="evaluatedrecord_statisticByExpert" target="right">查看已评审参评信息<img src="images/select_xl01.png"></a></dt>
	        		<!-- <dd><a href="evaluatedrecord_statisticByExpert" target="right">按指定专家统计</a></dd> -->
	        	</dl>
	        	<dl>
        			
	            	<dd><a style="color:white;" href="expert_modifyInformationView" target="right">修改个人密码</a></dd>
	            </dl>
        
        	</s:if>
        	<%-- <c:if test="${ sessionScope.superManager != null}">
        		 <dl>
	            	<dd><a href="super_lookInformation" target="right">管理员查看个人信息页面</a></dd>
	            </dl>
        		<dl class="channel">
           		<dt>专家管理<img src="images/select_xl01.png"></dt>
           			<dd><a href="expert_manageExpertInfoList" target="right">专家信息管理</a></dd>
            		<!-- <dd><a href="expert_registerExpert" target="right">专家注册</a></dd> -->
	           	</dl>
	           	 <dl class="channel">
	           	 	<dt>参评人员管理<img src="images/select_xl01.png"></dt>
	           	 	<dd><a href="super_deleteInformation">删除参评人员数据和记录</a></dd> --%>
	           	 	
	           	 	
        	<s:if test="#session.role.findSelfName() == 'superManager'">
        		<dl class="channel">
	           		<dt><a href="expert_manageExpertInfoList" target="right" style="color:white;">专家管理<img src="images/select_xl01.png"></a></dt>
	           		<!-- <dd><a href="expert_manageExpertInfoList" target="right">专家信息管理</a></dd> -->
	           	</dl>
	           	 <dl class="channel">
	           	 	<dt>参评人员信息管理<img src="images/select_xl01.png"></dt>
	           	 	<dd><a href="participated_manageParticipatedPerson" target="right">管理参评人员信息</a></dd>
	           	 	<dd><a href="participated_incrementParticipatedPerson" target="right">添加参评人员信息</a></dd>
	           	 </dl>
	           	<!--  <dl class="channel">
	           	 	<dt>邀请码管理<img src="images/select_xl01.png"></dt>
	           	 	<dd><a href="super_generateRequestCode" target="right">生成邀请码</a></dd>
	          		<dd><a href="super_showRequestCode" target="right">查看当前邀请码</a></dd>
	           	 </dl> -->
	           	 <dl class="channel">
	           	 	<dt>职称管理<img src="images/select_xl01.png"></dt>
	           	 	<dd><a href="jobTitleStandard_manageJobTitleStandard" target="right">管理职称申报标准信息</a></dd>
	           	 	<dd><a href="jobTitle_page_s?page_s.currentPage=1" target="right">查看/管理职称</a></dd>
	           	 	<dd><a href="jobTitle_add" target="right">增加职称</a></dd>
	           	 </dl>
	            <dl class="channel">
	            	<dt>单位管理<img src="images/select_xl01.png" ></dt>
	            	<dd><a href="unit_page_s?page_s.currentPage=1" target="right">查看/管理单位</a></dd>
	           	 	<dd><a href="unit_add" target="right">增加单位</a></dd>
	            </dl>
	            <dl class="channel">
	            	<dt>专业管理<img src="images/select_xl01.png"></dt>
	            	<dd><a href="specialty_page_s?page_s.currentPage=1" target="right">查看/管理专业</a></dd>
	           	 	<dd><a href="specialty_add" target="right">增加专业</a></dd>
	            </dl>
	           	 <dl class="channel">
	           	 	<dt><a style="color:white;" href="super_deleteInformation" onclick="return juge();">清空参评人相关信息<img src="images/select_xl01.png"></a></dt>
	           	 	<!-- <dd><a href="super_deleteInformation" onclick="return juge();">清空参评人员有关信息</a></dd> -->
	           	 </dl>
	           	 <dl>
	             	<dt><a style="color:white;" href="statistic_statisticAll" target="right">专家审评统计<img src="images/select_xl01.png"></a></dt>
	             	<!-- <dd><a style="color:white;" href="statistic_statisticAll" target="right">统计所有</a></dd> -->
	             </dl>
        		<dl>
	            	<dt><a style="color:white;" href="super_lookInformation" target="right">查看个人信息</a></dt>
	            </dl>
        		<dl>
        			
	            	<dd><a  style="color:white;"href="super_modifyInformationView" target="right">修改个人密码</a></dd>
	            </dl>
        	</s:if>
            
           <!--  <dl class="channel">
	            	<dt>退出登陆<img src="images/select_xl01.png" ></dt>
	            	<dd><a href="loginAction_loginOut" target="_top">退出登陆</a></dd>
	           </dl> -->
	            
	           <!-- 
	            </dl>
	            <dl class="channel">
		           	 	<dt>清空<img src="images/select_xl01.png"></dt>
		           	 	<dd><a href="super_deleteInformation" onclick="return juge();">清空参评人员有关信息</a></dd>
           	 	</dl>
	        	<dl>
	             	<dt>统计<img src="images/select_xl01.png"></dt>
	             	<dd><a href="statistic_statisticAll" target="right">统计所有</a></dd>
	            	<dd><a href="evaluatedrecord_statisticByExpert" target="right">按指定专家统计</a></dd>
	             </dl> -->
	             
       <dl class="channel">
           	<dt><a style="color:white" href="loginAction_loginOut" target="_top">退出登陆<img src="images/select_xl01.png" ></a></dt>
           	<!-- <dd><a href="loginAction_loginOut" target="_top">退出登陆</a></dd> -->
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