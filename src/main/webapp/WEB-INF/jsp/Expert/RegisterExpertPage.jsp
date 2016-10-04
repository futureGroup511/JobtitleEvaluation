<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/liwen13.css">
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

	<div class="dangqian">
	   <div class="row">
	        <div class="col-lg-1 col-lg-offset-1 col-md-2  col-xs-2 col-xs-offset-1">
	            <a><p>添加信息</p></a>
	        </div>
	        <div class="col-lg-3 col-lg-offset-5 col-md-5 col-md-offset-2 col-xs-6">
	            <p>当前位置：学生服务>>报名</p>
	        </div>
	        <div class="col-lg-2 col-md-3 col-xs-3">
	            <p>欢迎登录本系统</p>
	        </div>
	    </div>
	</div>

<s:form action="expert_registerExpertToDB"  method="post">
		<%-- 专家姓名*：<input class="exp_name" name="exp_name"><br/>
		<span class="exp_nameSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		账号*：<input class="exp_accountNum" name="exp_accountNum" onblur="queryCompeName(this)"><br/>
		<span class="exp_accountNumSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		密码*：<input class="exp_password" name="exp_password"><br/>
		<span class="exp_passwordSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		确认密码*：<input class="reExp_password" name="reExp_password"><br/>
		<span class="canotNull" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		<span class="reExp_passwordSpan" style="display:none;color:red;font-size:20px;">确认密码和密码不一致！请重输</span><br/>
		专业*：<s:select class="form-control" list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="exp_specialty.spec_id"></s:select><br/>
		<span class="speSpan" style="display:none;color:red;font-size:20px;">请选择此项，不可不选</span><br/>
		职称*：<s:select class="form-control" list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id"  name="exp_jobTitle.jobTi_id"></s:select><br/>
		<span class="jobSpan" style="display:none;color:red;font-size:20px;">请选择此项，不可不选</span><br/>
		学历*：<input class="exp_educationLevel" name="exp_educationLevel"><br/>
		<span class="exp_educationLevelSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		所在单位*：<s:select class="form-control" list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="exp_unit.uni_id"></s:select><br/>
		<span class="unitSapn" style="display:none;color:red;font-size:20px;">请选择此项，不可不选</span><br/>
		<s:submit class="btnSub" value="提交"></s:submit>
		 --%>
		
		<div class="row">
        	<div class="col-lg-1 col-lg-offset-2 col-md-2 col-md-offset-3 col-xs-2 col-xs-offset-2"><p>专家名称*：</p></div>
            <div class="col-lg-2 col-md-2 col-xs-3">
            	<!-- <input class="exp_name" name="exp_name"> -->
            	<input name="exp_name" type="text" class="form-control exp_name" >
            	<span class="exp_nameSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
             </div>
            <div class="col-lg-1 col-lg-offset-1 col-md-2 col-md-offset-1 col-xs-2 col-xs-offset-1"><p>账号*：</p></div>
            <div class="col-lg-2 col-md-2 col-xs-3">
            	<!-- <input type="text" class="form-control" placeholder="123456" style="background:#FDF0A1;">  -->
            	<input  class="exp_accountNum form-control" name="exp_accountNum" onblur="queryCompeName(this)">
            	<span class="exp_accountNumSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
            </div>
     </div>
     <div class="row">
        	<div class="col-lg-1 col-lg-offset-2 col-md-2 col-md-offset-3 col-xs-2 col-xs-offset-2"><p>密码*：</p></div>
            <div class="col-lg-2 col-md-2 col-xs-3">
            <input class="exp_password form-control" name="exp_password">
            <span class="exp_passwordSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
            </div>
             <div class="col-lg-1 col-lg-offset-1 col-md-2 col-md-offset-1 col-xs-2 col-xs-offset-1"><p>所在单位*：</p></div>
            <div class="col-lg-2 col-md-2 col-xs-3">
            <s:select class="form-control" list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="exp_unit.uni_id"></s:select>
            </div>
     </div>
     <div class="row">
        	<div class="col-lg-1 col-lg-offset-2 col-md-2 col-md-offset-3 col-xs-2 col-xs-offset-2"><p>确认密码*：</p></div>
            <div class="col-lg-2 col-md-2 col-xs-3">
           <!--  <input type="text" class="form-control"> -->
            <input class="reExp_password form-control" name="reExp_password">
            <span class="canotNull" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span>
		<span class="reExp_passwordSpan" style="display:none;color:red;font-size:20px;">确认密码和密码不一致！请重输</span><br/>
             </div>
            <div class="col-lg-1 col-lg-offset-1 col-md-2 col-md-offset-1 col-xs-2 col-xs-offset-1"><p>专业*：</p></div>
            <div class="col-lg-2 col-md-2 col-xs-3">
            <s:select class="form-control" list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="exp_specialty.spec_id"></s:select>
            	<%-- <select class="form-control">
                  <option>信息工程</option>
                  <option>计算机科学</option>
                  <option>应用化学</option>
                  <option>服装设计</option>
                </select> --%>
            </div>
     </div>
     <div class="row">
            <div class="col-lg-1 col-lg-offset-2 col-md-2 col-md-offset-1 col-xs-2 col-xs-offset-1"><p>职称*：</p></div>
            <div class="col-lg-2 col-md-2 col-xs-3">
            <s:select class="form-control" list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id"  name="exp_jobTitle.jobTi_id"></s:select>
            	<%-- <select class="form-control">
                  <option>教授</option>
                  <option>讲师</option>
                </select> --%>
            </div>
        	<div class="col-lg-1 col-lg-offset-1 col-md-2 col-md-offset-3 col-xs-2 col-xs-offset-2"><p>学历*：</p></div>
            <div class="col-lg-2 col-md-2 col-xs-3">
            <!-- <input type="text" class="form-control" placeholder="硕士">  -->
            <input class="exp_educationLevel form-control" name="exp_educationLevel">
            <span class="exp_educationLevelSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span>
            </div>

     </div>
     <%-- <div class="row">
            <div class="col-lg-1 col-lg-offset-2 col-md-2 col-md-offset-1 col-xs-2 col-xs-offset-1"><p>所在单位*：</p></div>
            <div class="col-lg-2 col-md-2 col-xs-3">
            <s:select class="form-control" list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="exp_unit.uni_id"></s:select>
            	<select class="form-control">
                  <option>信息工程</option>
                  <option>计算机科学</option>
                  <option>应用化学</option>
                  <option>服装设计</option>
                </select>
            </div>
     </div> --%>
     
     
      <div class="col-lg-2 col-lg-offset-3 col-md-2 col-md-offset-3  col-xs-2 col-xs-offset-3 ">
      <div class="last">
     	<!-- <button type="button" class="btn btn-primary">确定</button> -->
		<%-- <s:submit class="btnSub btn btn-primary" value="确定"></s:submit> --%>
     	<s:submit class="btnSub btn btn-primary" value="提交"></s:submit>
     </div>
    </div>
	</s:form>
</body>
</html>