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
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/liwen9.css">
</head>
<body>
<div class="dangqian">
   <div class="row">
        <div class="col-lg-3 col-lg-offset-5 col-md-5 col-md-offset-2 col-xs-6">
            <p>当前位置：管理员>>管理职称申报标准信息</p>
        </div>
        <div class="col-lg-2 col-md-3 col-xs-3">
            <p>欢迎<s:property value="#session.role.helloName()"/>登录本系统</p>
        </div>
    </div>
</div>

<div class="container">
        <table class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th>职称对应名称</th>
                    <th>修改其申报标准</th>
                </tr>
            </thead>
		
            <tbody>
         <s:if test="#request.jobTitleList != null && #request.jobTitleList.size() > 0">
	       <s:iterator value="#request.jobTitleList" var="jobTitle">
			<tr>
				<td>${jobTitle.jobTi_name}</td>
				<td><a href="jobTitleStandard_passToJobTitleStandardPage?jobTi_id=${jobTitle.jobTi_id }">修改其申报标准</a></td>
			</tr>
			</s:iterator>
       </s:if>
	   <s:else>
	   	<tr>
	   		<td>暂无职称信息，请添加</td>
	   	</tr>
	   </s:else>
     </tbody>
        </table>
</div>


<%-- <table>
      <tr>  
         <th>职称对应名称</th>
         <th>修改其申报标准</th>
       </tr>
       <s:if test="#request.jobTitleList != null && #request.jobTitleList.size() > 0">
	       <s:iterator value="#request.jobTitleList" var="jobTitle">
			<tr>
				<td>${jobTitle.jobTi_name}</td>
				<td><a href="jobTitleStandard_passToJobTitleStandardPage?jobTi_id=${jobTitle.jobTi_id }">修改其申报标准</a></td>
			</tr>
			</s:iterator>
       </s:if>
	   <s:else>
	   	<tr>
	   		<td>暂无职称信息，请添加</td>
	   	</tr>
	   </s:else>
    </table> --%>

</body>
</html>