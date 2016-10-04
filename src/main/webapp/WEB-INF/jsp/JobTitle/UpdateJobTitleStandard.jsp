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
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改职称对应评估标准</title>
</head>
<body>
	<s:form action="evaluatedStandard_UpdateJobTitleStandard" method="post">
		<s:hidden name="evalStan_id" value="%{#request.evaluatedStandard.evalStan_id}"></s:hidden>
		<s:hidden name="evalStan_jobtile.jobTi_id" value="%{#request.evaluatedStandard.evalStan_jobtile.jobTi_id}"></s:hidden>
		教学评价指标：<s:textarea onkeydown="checkMaxLen(this,250)" name="evalStan_teachStandard" value="%{#request.evaluatedStandard.evalStan_teachStandard}"></s:textarea><br/>
		科研评价指标：<s:textarea onkeydown="checkMaxLen(this,250)" name="evalStan_scientifiStandard" value="%{#request.evaluatedStandard.evalStan_scientifiStandard}"></s:textarea><br/>
		师德评价指标：<s:textarea onkeydown="checkMaxLen(this,250)" name="evalStan_moralityStandard" value="%{#request.evaluatedStandard.evalStan_moralityStandard}"></s:textarea><br/>
		<s:submit value="确定"></s:submit>
	</s:form>
</body>
</html>