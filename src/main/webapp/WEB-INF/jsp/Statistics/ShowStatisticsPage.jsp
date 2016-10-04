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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看统计信息</title>
</head>
<body>
   <table>
      <tr>  
         <th>申报人姓名</th>
         <th>申报人申报专业</th>
         <th>申报人申报职称</th>
         <th>申报人推荐单位</th>
         <th>A类专家评论得分</th>
         <th>B类专家评论得分</th>
         <th>C类专家评论得分</th>
         <th>合计总得分</th>
       </tr>
       <s:if test="#request.pageBean.recordlist != null && #request.pageBean.recordlist.size() > 0">
	       <s:iterator value="#request.pageBean.recordlist" var="statistics">
			<tr>
				<td>${statistics.sta_participatedPerson.parti_name}</td>
				<td>${statistics.sta_participatedPerson.parti_specialty.spec_name}</td>
				<td>${statistics.sta_participatedPerson.parti_jobTitle.jobTi_name}</td>
				<td>${statistics.sta_participatedPerson.parti_recommendUnit.uni_name}</td>
				<td>${statistics.sta_AScored}</td>
				<td>${statistics.sta_BScored}</td>
				<td>${statistics.sta_CScored}</td>
				<td>${statistics.sta_AllScored}</td>
			</tr>
			</s:iterator>
       </s:if>
	   <s:else>
	   	<tr>
	   		<td>暂无评论信息，请添加</td>
	   	</tr>
	   </s:else>
    </table>
</body>
</html>