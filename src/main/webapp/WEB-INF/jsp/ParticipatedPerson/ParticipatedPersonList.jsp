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
<link rel="stylesheet" href="css/liwen2.css">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>参评人员信息管理</title>
</head>
<body>
	<div class="container">
	  <div class="row">
	        <div class="col-lg-3 col-lg-offset-5 col-md-5 col-md-offset-2 col-xs-6">
	            <p><strong>当前位置：管理员>>参评人员信息管理</strong></p>
	        </div>
	        <div class="col-lg-4 col-md-4 col-xs-4">
	            <p><strong>欢迎  <s:property value="#session.role.helloName()"/>登录本系统</strong></p>
	        </div>
	  </div>
	</div>
	
	
	<div class="table-responsive">
    <table class="table table-bordered table-hover table-striped">
    <thead>
      <tr class="one">
         <th>参评人员姓名</th>
         <th>参评人员申报专业</th>
         <th>参评人员申报职称</th>
         <th>推荐单位</th>
         <th>预览资料</th>
         <th>修改</th>
       </tr>
      </thead>
      <tbody>
       <s:if test="#request.pageBean.recordlist != null && #request.pageBean.recordlist.size() > 0">
	       <s:iterator value="#request.pageBean.recordlist" var="participatedPerson">
			<tr>
				<td>${participatedPerson.parti_name}</td>
				<td>${participatedPerson.parti_specialty.spec_name}</td>
				<td>${participatedPerson.parti_jobTitle.jobTi_name}</td>
				<td>${participatedPerson.parti_recommendUnit.uni_name}</td>
				<td>
					<a class="image-icon" rel="gallery[modal]" href="<%=basePath %>${participatedPerson.parti_pathurl }">
					<img class="image-icon" height="20" width="100" src="<%=basePath %>${participatedPerson.parti_pathurl }"></a></td>
				<td><a href="<%=basePath %>participated_updateParticipatedPerson?parti_id=${participatedPerson.parti_id}&currentPage=${requestScope.pageBean.currentPage}">修改</a></td>
			</tr>
			</s:iterator>
       </s:if>
	   <s:else>
	   	<tr>
	   		<td>暂无参评人员信息，请添加</td>
	   	</tr>
	   </s:else>
       </tbody>
      </table>
</div>
	
	<!-- 分页相关 -->
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
	<%-- <a href="participated_incrementParticipatedPerson">添加参评人员信息</a>
    <table>
      <tr>  
         <th>参评人员姓名</th>
         <th>参评人员申报专业</th>
         <th>参评人员申报职称</th>
         <th>推荐单位</th>
         <th>预览资料</th>
         <th>修改</th>
       </tr>
       <s:if test="#request.pageBean.recordlist != null && #request.pageBean.recordlist.size() > 0">
	       <s:iterator value="#request.pageBean.recordlist" var="participatedPerson">
			<tr>
				<td>${participatedPerson.parti_name}</td>
				<td>${participatedPerson.parti_specialty.spec_name}</td>
				<td>${participatedPerson.parti_jobTitle.jobTi_name}</td>
				<td>${participatedPerson.parti_recommendUnit.uni_name}</td>
				<td>
					<a class="image-icon" rel="gallery[modal]" href="<%=basePath %>${participatedPerson.parti_pathurl }">
					<img height="20" width="100" src="<%=basePath %>${participatedPerson.parti_pathurl }"></a></td>
				<td><a href="<%=basePath %>participated_updateParticipatedPerson?parti_id=${participatedPerson.parti_id}&currentPage=${requestScope.pageBean.currentPage}">修改</a></td>
			</tr>
			</s:iterator>
       </s:if>
	   <s:else>
	   	<tr>
	   		<td>暂无参评人员信息，请添加</td>
	   	</tr>
	   </s:else>
    </table> --%>
</body>
<script type="text/javascript">
	function gotoPage(pageNum){
		if(pageNum > "${requestScope.pageBean.pageCount}"){
			pageNum = "${requestScope.pageBean.pageCount}"
		}
		if(pageNum < 1){
			pageNum = 1;
		}	
		window.location.href="participated_manageParticipatedPerson?currentPage=" + pageNum;
	}		
</script>
<!-- 去掉这3行，则点击直接显示原图，如果移动至下面则IE浏览器报错 begin -->
<script type='text/javascript' src='ly/js/jquery.js'></script>
<script type='text/javascript' src='ly/js/jquery.scripts.js'></script>
<script type='text/javascript' src='ly/js/jquery.custom.js'></script>
<!-- 去掉这3行，则点击直接显示原图，如果移动至下面则IE浏览器报错 end -->
<link rel="stylesheet" type="text/css" media="all" href="ly/css/style.min.css" />
</html>
<!-- 去掉这3行，则点击直接显示原图，如果移动至下面则IE浏览器报错 begin -->