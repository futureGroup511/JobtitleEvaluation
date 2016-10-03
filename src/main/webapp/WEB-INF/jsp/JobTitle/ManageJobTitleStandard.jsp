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
<title>管理职称对应的申报标准</title>
</head>
<body>
<table>
      <tr>  
         <th>职称对应名称</th>
         <th>修改其申报标准</th>
       </tr>
       <s:if test="#request.jobTitleList != null && #request.jobTitleList.size() > 0">
	       <s:iterator value="#request.jobTitleList" var="jobTitle">
			<tr>
				<td>${jobTitle.jobTi_name}</td>
				<td><a href="">修改其申报标准</a></td>
			</tr>
			</s:iterator>
       </s:if>
	   <s:else>
	   	<tr>
	   		<td>暂无职称信息，请添加</td>
	   	</tr>
	   </s:else>
    </table>

</body>
</html>