<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
	//得到url的根路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path +"/";
	%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/liwen12.css">
<!-- 去掉这3行，则点击直接显示原图，如果移动至下面则IE浏览器报错 begin -->
<script type='text/javascript' src='ly/js/jquery.js'></script>
<script type='text/javascript' src='ly/js/jquery.scripts.js'></script>
<script type='text/javascript' src='ly/js/jquery.custom.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看该参评人员的参评专家</title>
</head>
<body>

<div class="dangqian">
   <div class="row">
        <div class="col-lg-3 col-lg-offset-5 col-md-5 col-md-offset-2 col-xs-6">
            <p><strong>当前位置：管理员>>查看该参评人员的参评专家</strong></p>
        </div>
        <div class="col-lg-2 col-md-3 col-xs-3">
            <p><strong>欢迎  <s:property value="#session.role.helloName()"/>  登录本系统</strong></p>
        </div>
    </div>
</div>
<div style="margin-left:60px;">
		<s:form method="post" action="participated_fetchSpecialRecord">
			<s:hidden name="participatedId" value="%{#request.participatedId}"></s:hidden>
			<Strong>专家熟悉度：</Strong><s:select name="familiarStatus" list="#{'':'《《请选择》》', 'A':'熟悉(50%)', 'B':'比较熟悉(30%)', 'C':'不太熟悉(20%)'}" ></s:select>
			<Strong>总评得分情况：</Strong><s:select name="evalRecor_allAssessment" list="#{'':'《《请选择》》', '30':'A(30分)', '20':'B(20分)', '10':'C(10分)', '0':'D(0分)'}" ></s:select>
			<s:submit class="btn btn-primary" value="查找"></s:submit>
		</s:form>
</div>
 <div style="margin-left:60px;margin-top:40px"> 
			<Strong>专家总评为A的人数： <s:property value="#request.aScore"/></Strong>
			<Strong>专家总评为B的人数： <s:property value="#request.bScore"/></Strong>
			<Strong>专家总评为C的人数： <s:property value="#request.cScore"/></Strong>
			<Strong>专家总评为D的人数： <s:property value="#request.dScore"/></Strong>
			<Strong>平均得分情况：</Strong>
</div> 
<div class="container">
        <table class="table table-striped table-bordered table-hover">
            <thead>
      <tr>  
         <th>专家姓名</th>
         <th>专家专业</th>
         <th>专家单位</th>
         <th>专家学历</th>
         <th>专家职称</th>
         <th>评议专家熟悉度</th>
         <th>教学评议得分</th>
         <th>科研评议得分</th>
         <th>师德评议得分</th>
         <th>总评得分</th>
       </tr>
       </thead>
       <tbody>
       <s:if test="#request.pageBean.recordlist != null && #request.pageBean.recordlist.size() > 0">
	       <s:iterator value="#request.pageBean.recordlist" var="evaluatedRecord">
			<tr>
				<td>${evaluatedRecord.evalRecor_expart.exp_name}</td>
				<td>${evaluatedRecord.evalRecor_expart.exp_specialty.spec_name}</td>
				<td>${evaluatedRecord.evalRecor_expart.exp_unit.uni_name}</td>
				<td>${evaluatedRecord.evalRecor_expart.exp_educationLevel}</td>
				<td>${evaluatedRecord.evalRecor_expart.exp_jobTitle.jobTi_name}</td>
				<td>${evaluatedRecord.evalRecor_spciaFamiliar=="A"?"熟悉":evaluatedRecord.evalRecor_spciaFamiliar=="B"?"比较熟悉":"不太熟悉"}</td>
				<td>${evaluatedRecord.evalRecor_teaching}</td>
				<td>${evaluatedRecord.evalRecor_research}</td>
				<td>${evaluatedRecord.evalRecor_ethics}</td>
				<td>${evaluatedRecord.evalRecor_allAssessment}</td>
			</tr>
			</s:iterator>
       </s:if>
	   <s:else>
	   	<tr>
	   		<td>暂无评论信息，请添加</td>
	   	</tr>
	   </s:else>
	   </tbody>
    </table>
  </div>
  
  <div class="container">
      <div class="row">
           <div class="col-lg-5 col-lg-offset-2 col-md-5 col-md-offset-2 col-xs-5 col-xs-offset-2">
               <nav>
                   <ul class="pagination">
                     <li><a href="javascript:gotoPage(1)">首页</a></li>
		            <li><a href="javascript:gotoPage(${requestScope.pageBean.currentPage }-1)">上一页</a></li>
		            <li><a href="#">${requestScope.pageBean.currentPage }/${requestScope.pageBean.pageCount }</a></li>
		            <li><a href="javascript:gotoPage(${requestScope.pageBean.currentPage }+1)">下一页</a></li>
		            <li><a href="javascript:gotoPage(${requestScope.pageBean.pageCount })">尾页</a></li>
                   </ul>
               </nav>
            </div>
     </div>
</div>
</body>
<script type="text/javascript">
	function gotoPage(pageNum){
		if(pageNum > "${requestScope.pageBean.pageCount}"){
			pageNum = "${requestScope.pageBean.pageCount}"
		}
		if(pageNum < 1){
			pageNum = 1;
		}	
		window.location.href="participated_fetchSpecialRecord?currentPage="+pageNum+"&participatedId=${requestScope.participatedId }&familiarStatus=${requestScope.familiarStatus }&evalRecor_allAssessment=${requestScope.evalRecor_allAssessment }";
	}		
</script>
</html>