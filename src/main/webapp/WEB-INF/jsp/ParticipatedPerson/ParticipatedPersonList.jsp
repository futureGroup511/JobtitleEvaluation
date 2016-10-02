<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>参评人员信息管理</title>
</head>
<body>
	<a href="participated_incrementParticipatedPerson"/>添加参评人员信息</a>
    <table>
      <tr>
         <th>参评人员姓名</th>
         <th>参评人员申报专业</th>
         <th>参评人员申报职称</th>
         <th>推荐单位</th>
         <th>下载资料</th>
         <th>修改</th>
       </tr>
       <s:if test="#request.pageBean.recordlist != null || #request.pageBean.recordlist.size() > 0">
	       <s:iterator value="#request.pageBean.recordlist" var="participatedPerson">
			<tr>
				<td>${participatedPerson.parti_name}</td>
				<td>${participatedPerson.parti_specialty.spec_name}</td>
				<td>${participatedPerson.parti_jobTitle.jobTi_name}</td>
				<td>${participatedPerson.parti_recommendUnit.uni_name}</td>
				<td>预览资料信息</td>
				<td>修改</td>
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