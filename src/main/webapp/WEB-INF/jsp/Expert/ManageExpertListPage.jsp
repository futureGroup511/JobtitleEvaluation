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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理专家信息</title>
</head>
<body>
<div class="dangqian">
   <div class="row">
        <div class="col-lg-3 col-lg-offset-5 col-md-5 col-md-offset-2 col-xs-6">
            <p>当前位置：管理员>>专家信息管理</p>
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
         <th>专家姓名</th>
         <th>专家账号</th>
         <th>专家所属专业</th>
         <th>专家职称</th>
         <th>所属单位</th>
         <th>专家学历</th>
         <th>查看/修改</th>
       </tr>
       </thead>
       <tbody>
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
		window.location.href="expert_manageExpertInfoList?currentPage="+pageNum;
	}		
</script>
</html>