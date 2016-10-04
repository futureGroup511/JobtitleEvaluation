<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有参评人员信息</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>#</th>
				<th>姓名</th>
				<th>申报专业</th>
				<th>申报职称</th>
				<th>推荐单位</th>
				<th>评教</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach items="${p.recordlist}" var="person" varStatus="index">
					<tr>
						<td>${index.index+1}</td>
						<td>${person.parti_name}</td>
						<td>${person.parti_specialty.spec_name}</td>
						<td>${person.parti_jobTitle.jobTi_name}</td>
						<td>${person.parti_recommendUnit.uni_name}</td>
						<td><a href="expert_assess?person.parti_id=${person.parti_id}">审评</a></td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
	<div class="center-block" style="width:500px">
	  <nav>
		  <ul class="pager">
		    <li><a href="#" onclick="return jump(${p.currentPage-1},${p.pageCount})">上一页</a></li>
		    <li><a href="#" onclick="return jump(${p.currentPage+1},${p.pageCount})">下一页</a></li>
		  </ul>
	  </nav>
	  <form action="expert_allEvaluaTeacher" method="post">
	  	跳到第：
			<select name="currentPage">
				<c:forEach begin="1"  end="${p.pageCount}" varStatus="index">
					<c:choose>
						<c:when test="${p.currentPage eq index.index}">
							<option value="${index.index}" selected="selected">${index.index}</option>
						</c:when>
						<c:otherwise>
							<option value="${index.index}" >${index.index}</option>
						</c:otherwise>
					</c:choose>
					
				</c:forEach>
			</select>
			页
			<input type="submit">
	  </form>
	</div>
</body>
<script type="text/javascript">
	function jump(value,count){
		if(value<=0){
			value=1;
		}
		if(value>=count){
			value=count;
		}
		window.location.href="expert_allEvaluaTeacher?currentPage="+value;
		return false;
	}
</script>
</html>