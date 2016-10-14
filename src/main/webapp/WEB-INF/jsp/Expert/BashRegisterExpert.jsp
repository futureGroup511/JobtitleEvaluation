<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/liwen17.css">
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript">


//弃用
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
				$(obj).val("");
			}
		}
	});
}
	//弃用
	//检查专家账号是否重复 如果有重复的则不让提交，进行修改
	function expertNumIsSame(){
		var arrNum = new Array();
		/* for(var i=0;i<8;i++){
			arrNum[i] = $(".expNum_"+i).val();
			alert(arrNum[i]);
		} */
		
		var hash = {};
		for(var i in arrNum){
			if(arrNum[i] !=null && arrNum[i].trim() != ""){
				if(hash[arrNum[i]]){
					alert("账号有重复，请核对更改之后在进行提交！！");
					$(".expNum_"+i).addClass("warnning");
					return false;
				}
				hash[arrNum[i]] = true;
			}
		}
		//alert(true);
		return true;//无重复的 可以提交
	}

	
	//弃用
	function isRepeat(arr) {
	    var hash = {};
	    for(var i in arr) {
	        if(hash[arr[i]])
	        {
	            return true;
	        }
	        // 不存在该元素，则赋值为true，可以赋任意值，相应的修改if判断条件即可
	        hash[arr[i]] = true;
	    }
	    return false;
	}

</script>
<style>
	.warnning{
		background-color:#f00;
		color:#fff;
	}
	.one{
		width:10%;
	}
	.table input{
		width:100%;
	}
	.table{
		table-layout:fixed;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批量注册专家</title>
</head>
<body>
<div class="container">
   <div class="col-lg-3 col-lg-offset-6 col-md-3 col-md-offset-6 col-xs-3 col-xs-offset-6">
        <p><a href="#">批量注册专家</a></p>
   </div>
</div>
<s:form action="expert_bashRegisterrToDb"  method="post" >
<div class="table-responsive">
    <table class="table table-bordered table-hover table-striped">
		<thead>
		 <tr class="one">
			<th >专家姓名</th>
			<!-- <th >专家账号</th> -->
			<th >所属单位<div style="width:90px;height:180%;text-align:center;"></div></th>
			<th >专家专业</th>
			<th>专家职称</th>
			<th >专家学历</th>
		</tr>
		</thead>
		<tbody>
			<tr>
				<td class="five"><input class="expName_0" name="expName_0"/></td>
				<!-- <td><input class="expNum_0" name="expNum_0" onblur="queryCompeName(this)"></td> -->
				<td><s:select class="form-control" list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="expUnit_0"></s:select></td>
				<td><s:select class="form-control" list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="expSpe_0"></s:select></td>
				<td><s:select class="form-control" list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id"  name="expJobTi_0"></s:select></td>
				<td><s:select class="form-control expEdu_1" list="#{'本科':'本科', '硕士':'硕士', '博士':'博士' }"  name="expEdu_0"></s:select></td>
				<!-- <td><input class="expEdu_0" name="expEdu_0"></td> -->
			</tr>
			
			<tr>
				<td><input class="expName_1" name="expName_1"/></td>
				<!-- <td><input class="expNum_1" name="expNum_1" onblur="queryCompeName(this)"></td> -->
				<td><s:select class="form-control" list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="expUnit_1"></s:select></td>
				<td><s:select class="form-control" list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="expSpe_1"></s:select></td>
				<td><s:select class="form-control" list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id"  name="expJobTi_1"></s:select></td>
				<td><s:select class="form-control expEdu_1" list="#{'本科':'本科', '硕士':'硕士', '博士':'博士' }"  name="expEdu_1"></s:select></td>
				<!-- <td><input class="expEdu_1" name="expEdu_00" value="0"></td> -->
			</tr>
			
			<tr>
				<td><input class="expName_2" name="expName_2"/></td>
				<!-- <td><input class="expNum_2" name="expNum_2" onblur="queryCompeName(this)"></td> -->
				<td><s:select class="form-control" list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="expUnit_2"></s:select></td>
				<td><s:select class="form-control" list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="expSpe_2"></s:select></td>
				<td><s:select class="form-control" list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id"  name="expJobTi_2"></s:select></td>
				<td><s:select class="form-control expEdu_1" list="#{'本科':'本科', '硕士':'硕士', '博士':'博士' }"  name="expEdu_2"></s:select></td>
				<!-- <td><input class="expEdu_2" name="expEdu_2"></td> -->
			</tr>
			
			<tr>
				<td><input class="expName_3" name="expName_3"/></td>
				<!-- <td><input class="expNum_3" name="expNum_" onblur="queryCompeName(this)"></td> -->
				<td><s:select class="form-control" list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="expUnit_3"></s:select></td>
				<td><s:select class="form-control" list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="expSpe_3"></s:select></td>
				<td><s:select class="form-control" list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id"  name="expJobTi_3"></s:select></td>
				<td><s:select class="form-control expEdu_1" list="#{'本科':'本科', '硕士':'硕士', '博士':'博士' }"  name="expEdu_3"></s:select></td>
				<!-- <td><input class="expEdu_3" name="expEdu_3"></td> -->
			</tr>
			
			<tr>
				<td><input class="expName_4" name="expName_4"/></td>
				<!-- <td><input class="expNum_4" name="expNum_4" onblur="queryCompeName(this)"></td> -->
				<td><s:select class="form-control" list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="expUnit_4"></s:select></td>
				<td><s:select class="form-control" list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="expSpe_4"></s:select></td>
				<td><s:select class="form-control" list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id"  name="expJobTi_4"></s:select></td>
				<td><s:select class="form-control expEdu_1" list="#{'本科':'本科', '硕士':'硕士', '博士':'博士' }"  name="expEdu_4"></s:select></td>
				<!-- <td><input class="expEdu_4" name="expEdu_4"></td> -->
			</tr>
			
			<tr>
				<td><input class="expName_5" name="expName_5"/></td>
				<!-- <td><input class="expNum_5" name="expNum_5" onblur="queryCompeName(this)"></td> -->
				<td><s:select class="form-control" list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="expUnit_5"></s:select></td>
				<td><s:select class="form-control" list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="expSpe_5"></s:select></td>
				<td><s:select class="form-control" list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id"  name="expJobTi_5"></s:select></td>
				<td><s:select class="form-control expEdu_1" list="#{'本科':'本科', '硕士':'硕士', '博士':'博士' }"  name="expEdu_5"></s:select></td>
				<!-- <td><input class="expEdu_5" name="expEdu_5"></td> -->
			</tr>
			
			<tr>
				<td><input class="expName_6" name="expName_6"/></td>
				<!-- <td><input class="expNum_6" name="expNum_6" onblur="queryCompeName(this)"></td> -->
				<td><s:select class="form-control" list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="expUnit_6"></s:select></td>
				<td><s:select class="form-control" list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="expSpe_6"></s:select></td>
				<td><s:select class="form-control" list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id"  name="expJobTi_6"></s:select></td>
				<td><s:select class="form-control expEdu_1" list="#{'本科':'本科', '硕士':'硕士', '博士':'博士' }"  name="expEdu_6"></s:select></td>
				<!-- <td><input class="expEdu_6" name="expEdu_6"></td> -->
			</tr>
			
			<tr>
				<td><input class="expName_7" name="expName_7"/></td>
				<!-- <td><input class="expNum_7" name="expNum_7" onblur="queryCompeName(this)"></td> -->
				<td><s:select class="form-control" list="#request.unitList" listValue="uni_name" listKey="uni_id"  name="expUnit_7"></s:select></td>
				<td><s:select class="form-control" list="#request.specialtyList" listValue="spec_name" listKey="spec_id"  name="expSpe_7"></s:select></td>
				<td><s:select class="form-control" list="#request.jobTitleList" listValue="jobTi_name" listKey="jobTi_id"  name="expJobTi_7"></s:select></td>
				<td><s:select class="form-control expEdu_1" list="#{'本科':'本科', '硕士':'硕士', '博士':'博士' }"  name="expEdu_7"></s:select></td>
				<!-- <td><input class="expEdu_7" name="expEdu_7"></td> -->
			</tr>
		</tbody>
	</table>
</div>
<div class="row">
      <div class="col-lg-1 col-lg-offset-11 col-md-1 col-md-offset-11 col-xs-1 col-xs-offset-11">
          <!--  <button class="btn btn-primary" type="button" >提交</button> -->
           <s:submit class="btn btn-primary" value="提交"></s:submit>
       </div>
 </div>
</s:form>
</body>
</html>