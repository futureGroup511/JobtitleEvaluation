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
<title>查看评估记录</title>
</head>
<body>

<div class="dangqian">
   <div class="row">
        <div class="col-lg-3 col-lg-offset-5 col-md-5 col-md-offset-2 col-xs-6">
            <p>当前位置：管理员>>按指定专家统计</p>
        </div>
        <div class="col-lg-2 col-md-3 col-xs-3">
            <p>欢迎<s:property value="#session.role.findSelfName()"/>登录本系统</p>
        </div>
    </div>
</div>


<div class="container">
        <table class="table table-striped table-bordered table-hover">
            <thead>
      <tr>  
         <th>评议人姓名</th>
         <th>评议人申报专业</th>
         <th>评议人申报职称</th>
         <th>评议人推荐单位</th>
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
				<td>${evaluatedRecord.evalRecor_participatedPerson.parti_name}</td>
				<td>${evaluatedRecord.evalRecor_participatedPerson.parti_specialty.spec_name}</td>
				<td>${evaluatedRecord.evalRecor_participatedPerson.parti_jobTitle.jobTi_name}</td>
				<td>${evaluatedRecord.evalRecor_participatedPerson.parti_recommendUnit.uni_name}</td>
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
		window.location.href="evaluatedrecord_statisticByExpert?currentPage="+pageNum;
	}		
</script>
</html>