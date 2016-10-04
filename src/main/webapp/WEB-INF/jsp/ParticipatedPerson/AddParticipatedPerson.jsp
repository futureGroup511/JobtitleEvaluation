<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript">
	function queryCompeName(obj){
		var compeNameVal = obj.value;
		if(compeNameVal==null || compeNameVal.trim()==""){
			return;
		}
		var userParam = {"compeNameVal":compeNameVal};
		$.ajax({
			url:'depManager_queryCompeName',
			type:'post',
			data:userParam,
			dataType:'json',
			success:function(data){
				if(data){//已经存在了改竞赛名称
					alert("此名称已经存在了,不需要申请");
					$("#compeName").val("");
				}
			}
		});
	}
		$(function() {
			$(".btnSub").click(function(){
				$(".parti_nameSpan").css("display", "none");
				$(".fileSpan").css("display", "none");
				var parti_nameSpan = $(".parti_name").val();
				var fileSpan = $(".file").val();
				if(parti_nameSpan == null || parti_nameSpan.trim() == ""){
					$(".parti_nameSpan").css("display", "inline");
					return false;
				}
				if(fileSpan == null || fileSpan.trim() == ""){
					$(".fileSpan").css("display", "inline");
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
	<s:form action="participated_saveParticipatedPerson" enctype="multipart/form-data" method="post">
		申请人姓名：<input class="parti_name" name="parti_name"><br/>
		<span class="parti_nameSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		所评职称：<s:select list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id"  name="parti_jobTitle.jobTi_id"></s:select><br/>
		申报专业：<s:select list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="parti_specialty.spec_id"></s:select><br/>
		推荐单位：<s:select list="#request.unitList" listValue="uni_name" listKey="uni_id"   name="parti_recommendUnit.uni_id"></s:select><br/>
		个人资料上传：<input class="file" type="file" name="image">
		<span class="fileSpan" style="display:none;color:red;font-size:20px;">请务必上传您的个人信息！！！</span><br/>
		<s:submit class="btnSub" value="提交"></s:submit>
	</s:form>
</body>
</html>