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
<title>管理专家信息</title>
</head>
<body>
<table>
      <tr>  
         <th>专家姓名</th>
         <th>专家账号</th>
         <th>专家所属专业</th>
         <th>专家职称</th>
         <th>所属单位</th>
         <th>专家学历</th>
         <th>查看/修改</th>
       </tr>
       <s:if test="#request.pageBean.recordlist != null && #request.pageBean.recordlist.size() > 0">
	       <s:iterator value="#request.pageBean.recordlist" var="expert">
			<tr>
				<td>${expert.exp_name}</td>
				<td>${expert.exp_accountNum}</td>
				<td>${expert.exp_specialty.spec_name}</td>
				<td>${expert.exp_jobTitle.jobTi_name}</td>
				<td>${expert.exp_unit.uni_name}</td>
				<td>${expert.exp_educationLevel}</td>
				<td>
					<a href="expert_updateExpertInfoPage?exp_id=${expert.exp_id }&currentPage=${currentPage}">查看/修改</a>
				</td>
			</tr>
			</s:iterator>
       </s:if>
	   <s:else>
	   	<tr>
	   		<td>暂无专家信息，请添加</td>
	   	</tr>
	   </s:else>
    </table>
</body>
</html>