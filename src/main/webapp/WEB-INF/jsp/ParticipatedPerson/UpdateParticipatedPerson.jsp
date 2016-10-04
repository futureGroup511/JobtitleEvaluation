<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	<s:form action="participated_updateParticipatedPersonSuccess" method="post">
		<s:hidden name="currentPage" value="%{#request.currentPage}"></s:hidden>
		<s:hidden name="parti_id" value="%{#request.participatedPerson.parti_id}"></s:hidden>
		申请人姓名：<input class="parti_name" type="text" name="parti_name" value="${requestScope.participatedPerson.parti_name }"><br/>
		<span class="parti_nameSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		所评职称：<s:select list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id" name="parti_jobTitle.jobTi_id" value="#request.participatedPerson.parti_jobTitle.jobTi_id"></s:select><br/>
		申报专业：<s:select list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="parti_specialty.spec_id" value="#request.participatedPerson.parti_specialty.spec_id"></s:select><br/>
		推荐单位：<s:select list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="parti_recommendUnit.uni_id" value="#request.participatedPerson.parti_recommendUnit.uni_id"></s:select><br/>
		<s:submit class="btnSub" value="确定"></s:submit>
	</s:form>
</body>
</html>