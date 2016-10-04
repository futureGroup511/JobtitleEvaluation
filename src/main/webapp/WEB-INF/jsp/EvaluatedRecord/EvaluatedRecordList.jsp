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
<title>查看评估记录</title>
</head>
<body>
<table>
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
    </table>
  
</body>
</html>