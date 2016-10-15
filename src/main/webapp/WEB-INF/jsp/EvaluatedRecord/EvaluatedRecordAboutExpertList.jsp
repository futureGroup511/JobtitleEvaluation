<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
	//得到url的根路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path +"/";
	%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/liwen12.css">
<!-- 去掉这3行，则点击直接显示原图，如果移动至下面则IE浏览器报错 begin -->
<script type='text/javascript' src='${pageContext.request.contextPath }/ly/js/jquery.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath }/ly/js/jquery.scripts.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath }/ly/js/jquery.custom.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看评估记录</title>
</head>
<body>

<div class="dangqian">
   <div class="row">
        <div class="col-lg-3 col-lg-offset-5 col-md-5 col-md-offset-2 col-xs-6">
            <p><strong>当前位置：管理员>>按指定专家统计</strong></p>
        </div>
        <div class="col-lg-2 col-md-3 col-xs-3">
            <p><strong>欢迎  <s:property value="#session.role.helloName()"/>  登录本系统</strong></p>
        </div>
    </div>
</div>
<form action="evaluatedrecord_FindByExpertUnitOrSpecialty" method="post" id="form">
 <input type="hidden" value="${expert.exp_id}" name="expert.exp_id" >
 <input type="hidden" value="1" name="currentPage" id="currentPage">
 <div class="container">
        <table class="table table-striped table-bordered table-hover">
        	<tr>
           	<th>
           		<c:choose>
           			<c:when test="${choose eq 'specialty'}">
           			同单位参评人员:<input   type="checkbox" name="expert.exp_unit.uni_id" value="${expert.exp_unit.uni_id }" class="from-control ">
           			同专业参评人员:<input   checked="checked" type="checkbox" name="expert.exp_specialty.spec_id" value="${expert.exp_specialty.spec_id }" class="from-control">
           		</c:when>
           		<c:when test="${choose eq 'unit'}">
           			同单位参评人员:<input  checked="checked" type="checkbox" name="expert.exp_unit.uni_id" value="${expert.exp_unit.uni_id }" class="from-control ">
           			同专业参评人员:<input   type="checkbox" name="expert.exp_specialty.spec_id" value="${expert.exp_specialty.spec_id }" class="from-control">
           		</c:when>
           		<c:when test="${choose eq 'all'}">
           			同单位参评人员:<input  checked="checked" type="checkbox" name="expert.exp_unit.uni_id" value="${expert.exp_unit.uni_id }" class="from-control ">
           			同专业参评人员:<input  checked="checked" type="checkbox" name="expert.exp_specialty.spec_id" value="${expert.exp_specialty.spec_id }" class="from-control">
           		</c:when>
           		<c:otherwise>
           			同单位参评人员:<input  type="checkbox" name="expert.exp_unit.uni_id" value="${expert.exp_unit.uni_id }" class="from-control ">
           			同专业参评人员:<input  type="checkbox" name="expert.exp_specialty.spec_id" value="${expert.exp_specialty.spec_id }" class="from-control">
           		</c:otherwise>
           		</c:choose>
           		总评得分:<select name="evalRecor_allAssessment" class="from-control">
								<c:choose>
									<c:when test="${allAssessment eq '30' }">
										<option >请选择</option>
										<option value="优" selected="selected">A、优</option>
										<option value="良">B、良</option>
										<option value="中">C、中</option>
										<option value="差">D、差</option>
									</c:when>
									<c:when test="${allAssessment eq '20' }">
										<option >请选择</option>
										<option value="优">A、优</option>
										<option value="良" selected="selected">B、良</option>
										<option value="中">C、中</option>
										<option value="差">D、差</option>
									</c:when>
									<c:when test="${allAssessment eq '10' }">
										<option >请选择</option>
										<option value="优">A、优</option>
										<option value="良">B、良</option>
										<option value="中" selected="selected">C、中</option>
										<option value="差">D、差</option>
									</c:when>
									<c:when test="${allAssessment eq '0' }">
										<option >请选择</option>
										<option value="优">A、优</option>
										<option value="良">B、良</option>
										<option value="中">C、中</option>
										<option value="差" selected="selected">D、差</option>
									</c:when>
									<c:otherwise>
										<option selected="selected">请选择</option>
										<option value="优">A、优</option>
										<option value="良">B、良</option>
										<option value="中">C、中</option>
										<option value="差">D、差</option>
									</c:otherwise>
								</c:choose>
									
						</select>
           		<button class="btn btn-primary btn-lg">确定</button>
	        </th>
	        <th><a href="evaluatedrecord_findAllRecord" class="btn btn-info btn-lg">返回</a></th>
	        </tr>
        </table>
 </div>
</form>
<div class="container">
        <table class="table table-striped table-bordered table-hover">
            <thead>
       		<tr>
       			<td></td>
       			<td>熟悉平均分值:${statistics.sta_AScored }</td>
       			<td>比较熟悉平均分值:${statistics.sta_BScored }</td>
       			<td>不太熟悉平均分值:${statistics.sta_CScored }</td>
       			<c:forEach items="${typeNumbers}" var="typeNumber">
       				<td>评价参评人员为${typeNumber.assessmentType}的人数:${typeNumber.count}</td>
       			</c:forEach>
       			<td></td>
       		</tr>
	      <tr>  
	      <s:if test="#session.role.findSelfName =='superManager'">
	      	<th>专家姓名</th>
	      </s:if>
	         <th>参评人姓名</th>
	         <th>参评人申报专业</th>
	         <th>参评人申报职称</th>
	         <th>参评人推荐单位</th>
	         <th>教学评议得分</th>
	         <th>科研评议得分</th>
	         <th>师德评议得分</th>
	         <th>总评得分</th>
	         <!-- <th>专家单位</th>
	         <th>专家专业</th> -->
	       </tr>
       </thead>
       <tbody>
       <s:if test="#request.pageBean.recordlist != null && #request.pageBean.recordlist.size() > 0">
	       <s:iterator value="#request.pageBean.recordlist" var="evaluatedRecord">
			<tr>
				<s:if test="#session.role.findSelfName =='superManager'">
					<td>${evaluatedRecord.evalRecor_expart.exp_name}</td>
				</s:if>
				<td>${evaluatedRecord.evalRecor_participatedPerson.parti_name}</td>
				<td>${evaluatedRecord.evalRecor_participatedPerson.parti_specialty.spec_name}</td>
				<td>${evaluatedRecord.evalRecor_participatedPerson.parti_jobTitle.jobTi_name}</td>
				<td>${evaluatedRecord.evalRecor_participatedPerson.parti_recommendUnit.uni_name}</td>
				<td>${evaluatedRecord.evalRecor_teaching}</td>
				<td>${evaluatedRecord.evalRecor_research}</td>
				<td>${evaluatedRecord.evalRecor_ethics}</td>
				<td>${evaluatedRecord.evalRecor_allAssessment}</td>
				<%-- <td><a href="evaluatedrecord_FindByExpertUnitOrSpecialty?expert.exp_unit.uni_id=${evaluatedRecord.evalRecor_expart.exp_unit.uni_id }&expert.exp_id=${evaluatedRecord.evalRecor_expart.exp_id}">同单位</a></td>
				<td><a href="evaluatedrecord_FindByExpertUnitOrSpecialty?expert.exp_specialty.spec_id=${evaluatedRecord.evalRecor_expart.exp_specialty.spec_id }&expert.exp_id=${evaluatedRecord.evalRecor_expart.exp_id}">同专业</a></td> --%>
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
		            <c:choose>
		            	<c:when test="${requestScope.pageBean.pageCount le 0}">
		            		<li><a href="#">${requestScope.pageBean.currentPage }/1</a></li>
		            	</c:when>
		            	<c:otherwise>
		            		<li><a href="#">${requestScope.pageBean.currentPage }/${requestScope.pageBean.pageCount }</a></li>
		            	</c:otherwise>
		            </c:choose>
		            
		            
		            
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
		var inputcurrent=document.getElementById("currentPage");
		inputcurrent.value=pageNum;
		var form=document.getElementById("form");
		form.submit();
	}
	
	
</script>
</html>