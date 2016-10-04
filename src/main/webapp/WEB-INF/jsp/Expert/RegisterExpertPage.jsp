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
				$(".exp_nameSpan").css("display", "none");
				$(".exp_accountNumSpan").css("display", "none");
				$(".exp_passwordSpan").css("display", "none");
				$(".reExp_passwordSpan").css("display", "none");
				$(".exp_educationLevelSpan").css("display", "none");
				$(".canotNull").css("display", "none");
				var exp_nameSpan = $(".exp_name").val();
				var exp_accountNumSpan = $(".exp_accountNum").val();
				var exp_passwordSpan = $(".exp_password").val();
				var reExp_passwordSpan = $(".reExp_password").val();
				var exp_educationLevelSpan = $(".exp_educationLevel").val();
				if(exp_nameSpan == null || exp_nameSpan.trim() == ""){
					$(".exp_nameSpan").css("display", "inline");
					return false;
				}
				if(exp_accountNumSpan==null || exp_accountNumSpan ==""){
					$(".exp_accountNumSpan").css("display", "inline");
					return false;
				}
				if(exp_passwordSpan == null || exp_passwordSpan.trim() == ""){
					$(".exp_passwordSpan").css("display", "inline");
					return false;
				}
				if(reExp_passwordSpan == null || reExp_passwordSpan .trim() == ""){
					$(".canotNull").css("display", "inline");
					return false;
				}
				if(exp_educationLevelSpan == null || exp_educationLevelSpan.trim() == ""){
					$(".exp_educationLevelSpan").css("display", "inline");
					return false;
				}
				if(reExp_passwordSpan != exp_passwordSpan){
					$(".reExp_passwordSpan").css("display", "inline");
					return false;
				}
				return true;
			});
		});
		
		function queryCompeName(obj){
			var accountNum = obj.value;
			if(accountNum==null || accountNum.trim()==""){
				return;
			}
			var userParam = {"accountNum":accountNum};
			$.ajax({
				url:'expert_querySpecialAccountNum',
				type:'post',
				data:userParam,
				dataType:'json',
				success:function(data){
					if(data){//已经存在了改竞赛名称
						alert("此账号已被其他人注册，请更换");
						$(".exp_accountNum").val("");
					}
				}
			});
		}
		
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专家注册页面</title>
</head>
<body>
<s:form action="expert_registerExpertToDB"  method="post">
		专家姓名*：<input class="exp_name" name="exp_name"><br/>
		<span class="exp_nameSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		账号*：<input class="exp_accountNum" name="exp_accountNum" onblur="queryCompeName(this)"><br/>
		<span class="exp_accountNumSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		密码*：<input class="exp_password" name="exp_password"><br/>
		<span class="exp_passwordSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		确认密码*：<input class="reExp_password" name="reExp_password"><br/>
		<span class="canotNull" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		<span class="reExp_passwordSpan" style="display:none;color:red;font-size:20px;">确认密码和密码不一致！请重输</span><br/>
		专业*：<s:select list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="exp_specialty.spec_id"></s:select><br/>
		<span class="speSpan" style="display:none;color:red;font-size:20px;">请选择此项，不可不选</span><br/>
		职称*：<s:select list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id"  name="exp_jobTitle.jobTi_id"></s:select><br/>
		<span class="jobSpan" style="display:none;color:red;font-size:20px;">请选择此项，不可不选</span><br/>
		学历*：<input class="exp_educationLevel" name="exp_educationLevel"><br/>
		<span class="exp_educationLevelSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		所在单位*：<s:select list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="exp_unit.uni_id"></s:select><br/>
		<span class="unitSapn" style="display:none;color:red;font-size:20px;">请选择此项，不可不选</span><br/>
		<s:submit class="btnSub" value="提交"></s:submit>
	</s:form>
</body>
</html>