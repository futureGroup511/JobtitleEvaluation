<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/liwen14.css">
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".btnSub").click(function(){
			$(".parti_nameSpan").css("display", "none");
			var parti_nameSpan = $(".parti_name").val();
			if(parti_nameSpan == null || parti_nameSpan.trim() == ""){
				$(".parti_nameSpan").css("display", "inline");
				return false;
			}
			return true;
		});
	});
			
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加参评人员信息</title>
</head>
<body>
	<div class="dangqian">
   <div class="row">
        <div class="col-lg-3 col-lg-offset-5 col-md-5 col-md-offset-2 col-xs-6">
            <p><strong>当前位置：>>更新参与人信息</strong></p>
        </div>
        <div class="col-lg-2 col-md-2 col-xs-2">
            <p><strong>欢迎  <s:property value="#session.role.helloName()"/>登录本系统</strong></p>
        </div>
    </div>
	</div>

	<s:form action="participated_updateParticipatedPersonSuccess" method="post">
		<s:hidden name="currentPage" value="%{#request.currentPage}"></s:hidden>
		<s:hidden name="parti_id" value="%{#request.participatedPerson.parti_id}"></s:hidden>
		<s:hidden name="parti_pathurl" value="%{#request.participatedPerson.parti_pathurl}"></s:hidden>
		<%-- 申请人姓名：<input class="parti_name" type="text" name="parti_name" value="${requestScope.participatedPerson.parti_name }"><br/>
		<span class="parti_nameSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		所评职称：<s:select list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id" name="parti_jobTitle.jobTi_id" value="#request.participatedPerson.parti_jobTitle.jobTi_id"></s:select><br/> --%>
		<div class="row">
        	<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-xs-2 col-xs-offset-2"><p>申请人:</p></div>
            <div class="col-lg-2 col-md-2 col-xs-3" style="margin-left:-9%;">
            	<input maxlength="50" class="parti_name form-control" type="text" name="parti_name" value="${requestScope.participatedPerson.parti_name }">
            	<span class="parti_nameSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
            </div>
            <div class="col-lg-1 col-lg-offset-1 col-md-2 col-md-offset-1 col-xs-2 col-xs-offset-1"><p>所评职称*：</p></div>
            <div class="col-lg-2 col-md-2 col-xs-3" style="margin-left:-9%;">
           		 <s:select class="form-control" list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id" name="parti_jobTitle.jobTi_id" value="#request.participatedPerson.parti_jobTitle.jobTi_id"></s:select>
            	<%-- <select class="form-control">
                  <option>教授</option>
                  <option>讲师</option>
                </select> --%>
            </div>
    	 </div>
	<%-- 	申报专业：<s:select list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="parti_specialty.spec_id" value="#request.participatedPerson.parti_specialty.spec_id"></s:select><br/>
		推荐单位：<s:select list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="parti_recommendUnit.uni_id" value="#request.participatedPerson.parti_recommendUnit.uni_id"></s:select><br/>
		 --%>
		   <div class="row">
            <div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-xs-2 col-xs-offset-2"><p>申报专业：</p></div>
            <div class="col-lg-2 col-md-2 col-xs-3" style="margin-left:-9%;">
            	<s:select class="form-control" list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="parti_specialty.spec_id" value="#request.participatedPerson.parti_specialty.spec_id"></s:select>
            	<%-- <select class="form-control">
                  <option>信息工程</option>
                  <option>计算机科学</option>
                  <option>应用化学</option>
                  <option>服装设计</option>
                </select> --%>
            </div>
            <div class="col-lg-1 col-lg-offset-1 col-md-2 col-md-offset-1 col-xs-2 col-xs-offset-1"><p>推荐单位*：</p></div>
            <div class="col-lg-2 col-md-2 col-xs-3" style="margin-left:-9%;">
            	<s:select class="form-control" list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="parti_recommendUnit.uni_id" value="#request.participatedPerson.parti_recommendUnit.uni_id"></s:select>
            	<%-- <select class="form-control">
                  <option>信息工程</option>
                  <option>计算机科学</option>
                  <option>应用化学</option>
                  <option>服装设计</option>
                </select> --%>
            </div>
     </div>
     <div class="col-lg-2 col-lg-offset-7 col-md-2 col-md-offset-7  col-xs-2 col-xs-offset-7 ">
      <div class="last">
     	<!-- <button type="button" class="btn btn-primary">确定</button> -->
		<s:submit class="btnSub btn btn-primary" value="确定"></s:submit>
     </div>
    </div>
	</s:form>
	
</body>
</html>