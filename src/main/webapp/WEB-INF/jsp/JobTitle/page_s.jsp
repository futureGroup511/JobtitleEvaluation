<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页查看</title>
</head>
<body>
<center>
	<h1>分页查看</h1>
	<hr>
	<h2>第${page_s.currentPage } / ${page_s.pageCount }页</h2>
	
		<table>
			<tbody>
				<tr>
					<td>职称ID</td>
					<td>职称名字</td>
					<td>修改</td>
				</tr>
				
				<c:forEach var="jt" items="${page_s.recordlist }">
					<tr>
					<td>${jt.jobTi_id }</td>
					<td>${jt.jobTi_name }</td>
					<td><a href="jobTitle_changePage?jobTitle.jobTi_id=${jt.jobTi_id }">修改</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	页数:
	<!-- 上一页和下一页用下面的js更改属性 -->
	<a id="prePage"  href="#">上一页</a>
	<a id="nextPage"  href="#">下一页</a>
	<a  href="jobTitle_page_s?page_s.currentPage=1">首页</a>
	
	<c:forEach var="p" begin="${page_s.beginPageIndex }" end="${page_s.endPageIndex }" step="1">
		<span><a href="jobTitle_page_s?page_s.currentPage=${p }">${p }</a></span>
	</c:forEach>
	
	<a href="jobTitle_page_s?page_s.currentPage=${page_s.endPageIndex }">尾页</a>
	  

	<form>
		跳转到指定页:<input type="text" name="page_s.currentPage">
		<input type="submit" value="跳转">
	</form>

</center>
<script type="text/javascript">
		var one=${page_s.currentPage};
		var two=${page_s.pageCount }
			if(one != 1){
				document.getElementById("prePage").setAttribute("href", "jobTitle_page_s?page_s.currentPage="+(one-1));
			}
			if(one != two){
				document.getElementById("nextPage").setAttribute("href", "jobTitle_page_s?page_s.currentPage="+(one+1));
			}
	</script>
</body>

</html>