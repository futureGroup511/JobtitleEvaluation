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
<!-- 去掉这3行，则点击直接显示原图，如果移动至下面则IE浏览器报错 begin -->
<script type='text/javascript' src='ly/js/jquery.js'></script>
<script type='text/javascript' src='ly/js/jquery.scripts.js'></script>
<script type='text/javascript' src='ly/js/jquery.custom.js'></script>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>参评人员信息管理</title>
</head>
<body>
	<a href="participated_incrementParticipatedPerson">添加参评人员信息</a>
    <table>
      <tr>  
         <th>参评人员姓名</th>
         <th>参评人员申报专业</th>
         <th>参评人员申报职称</th>
         <th>推荐单位</th>
         <th>下载资料</th>
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
    </table>
</body>
</html>