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

function checkMaxLen(obj,maxlength){
	 if(obj.value.length > maxlength){
		 obj.value = obj.value.slice(0,maxlength);
		 alert("描述字数最多不能超过"+maxlength+"字符");
	 }
}

$(function() {
	$(".btnSub").click(function(){
		$(".teachTextAreaSpan").css("display", "none");
		$(".scienceTextAreaSpan").css("display", "none");
		$(".moralTextAreaSpan").css("display", "none");
		var teachTextArea = $(".teachTextArea").val();
		var scienceTextArea = $(".scienceTextArea").val();
		var moralTextArea = $(".moralTextArea").val();
		if(teachTextArea == null || teachTextArea.trim() == ""){
			$(".teachTextAreaSpan").css("display", "inline");
			return false;
		}
		if(scienceTextArea == null || scienceTextArea.trim() == ""){
			$(".scienceTextAreaSpan").css("display", "inline");
			return false;
		}
		if(moralTextArea == null || moralTextArea.trim() == ""){
			$(".moralTextAreaSpan").css("display", "inline");
			return false;
		}
		return true;
	});
});
		
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改职称对应评估标准</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/liwen10.css">
</head>
<body>
	<div class="dangqian">
  <div class="row">
    
        <div class="col-lg-3 col-lg-offset-5 col-md-5 col-md-offset-2 col-xs-6">
            <p>当前位置：管理员>>管理职称申报标准</p>
        </div>
        <div class="col-lg-2 col-md-3 col-xs-3">
            <p>欢迎<s:property value="#session.role.findSelfName()"/>登录本系统</p>
        </div>
  </div>
</div>



	<s:form action="evaluatedStandard_UpdateJobTitleStandard" method="post">
		<s:hidden name="evalStan_id" value="%{#request.evaluatedStandard.evalStan_id}"></s:hidden>
		<s:hidden name="evalStan_jobtile.jobTi_id" value="%{#request.evaluatedStandard.evalStan_jobtile.jobTi_id}"></s:hidden>
		
		<div class="row">
		  <div style="font-size:20px" class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-xs-2 col-xs-offset-2">
		            <p>教学评价标准：</p>
		        </div>
		　 <div class="col-lg-6  col-md-6  col-xs-6 ">
		   <!--   <textarea rows="6">
		       师德评价标准 教授FF
		     </textarea> -->
		     <s:textarea class="teachTextArea" rows="6" onkeydown="checkMaxLen(this,250)" name="evalStan_teachStandard" value="%{#request.evaluatedStandard.evalStan_teachStandard}"></s:textarea>
		     <span class="teachTextAreaSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		   </div>
		   <div class="col-lg-1">
		   </div>
		</div>
		
		<div class="row">
		  <div style="font-size:20px" class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-xs-2 col-xs-offset-2">
		            <p>科研评价标准：</p>
		        </div>
		　 <div class="col-lg-6  col-md-6  col-xs-6 ">
		    <!--  <textarea rows="6">
		       科研评价标准 教授HH
		     </textarea> -->
		     <s:textarea  class="scienceTextArea"  rows="6" onkeydown="checkMaxLen(this,250)" name="evalStan_scientifiStandard" value="%{#request.evaluatedStandard.evalStan_scientifiStandard}"></s:textarea>
		     <span class="scienceTextAreaSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		   </div>
		   <div class="col-lg-1">
		   </div>
		</div>
		
		<div class="row">
		  <div style="font-size:20px" class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-xs-2 col-xs-offset-2">
		            <p>师德评价标准：</p>
		        </div>
		　 <div class="col-lg-6  col-md-6  col-xs-6 ">
		    <!--  <textarea rows="6">
		       教学评价标准 教授FF
		     </textarea> -->
		     <s:textarea class="moralTextArea" rows="6" onkeydown="checkMaxLen(this,250)" name="evalStan_moralityStandard" value="%{#request.evaluatedStandard.evalStan_moralityStandard}"></s:textarea>
		     <span class="moralTextAreaSpan" style="display:none;color:red;font-size:20px;">请填写此内容，不可留空</span><br/>
		   </div>
		   <div class="col-lg-1">
		   </div>
		</div>
		<%-- 
		教学评价指标：<s:textarea onkeydown="checkMaxLen(this,250)" name="evalStan_teachStandard" value="%{#request.evaluatedStandard.evalStan_teachStandard}"></s:textarea><br/>
		科研评价指标：<s:textarea onkeydown="checkMaxLen(this,250)" name="evalStan_scientifiStandard" value="%{#request.evaluatedStandard.evalStan_scientifiStandard}"></s:textarea><br/>
		师德评价指标：<s:textarea onkeydown="checkMaxLen(this,250)" name="evalStan_moralityStandard" value="%{#request.evaluatedStandard.evalStan_moralityStandard}"></s:textarea><br/> --%>
		<div class="col-lg-2 col-lg-offset-9 col-md-2 col-md-offset-9 col-xs-2 col-xs-offset-9">
				<s:submit  class="btnSub btn btn-primary" style="width:34%; margin:10px 0 35px 0"  value="确定"></s:submit>
		</div>
	</s:form>
</body>
</html>