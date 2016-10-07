<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>第${page_s.currentPage }页查看所有单位</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/unit_page_s.css">
</head>
<body>

<div class="dangqian">
  <div class="row">
        <div class="col-lg-3 col-lg-offset-5 col-md-5 col-md-offset-2 col-xs-6">
            <p><strong>当前位置：管理员>>查看单位</strong></p>
        </div>
        <div class="col-lg-2 col-md-3 col-xs-3">
            <p><strong>欢迎  <s:property value="#session.role.helloName()"/>  登录本系统</strong></p>
        </div>
  </div>
</div>
<center>
	<h1 class="remind">${remind }</h1>
	<s:set name="remind" value=" " scope="session"></s:set>
	<h3>第${page_s.currentPage } / ${page_s.pageCount }页--所有单位信息</h3>
</center>
 <table class="table table-bordered table-hover">
            <tbody>
                <tr>
                    
                    <td>单位名字</td>
                    <td>修改</td>
                </tr>
                <c:forEach var="jt" items="${page_s.recordlist }">
					<tr>
					<td>${jt.uni_name }</td>
					<td><a href="unit_changePage?unit.uni_id=${jt.uni_id }&page_s.currentPage=${page_s.currentPage }">修改</a></td>
					</tr>
				</c:forEach>
            </tbody>
  </table>
  <div class="container">
      <div class="row">
           <div class="col-lg-3 col-lg-offset-3 col-md-5 col-md-offset-3 col-xs-5 col-xs-offset-3">
               <nav>
                   <ul class="pagination">
                       <li><a href="unit_page_s?page_s.currentPage=1">首页</a></li>
                       <li><a id="prePage" href="#">上一页</a></li>
                       
                       <li><a href="unit_page_s?page_s.currentPage=${page_s.currentPage }">${page_s.currentPage } / ${page_s.pageCount }</a></li>
                    
                       <li><a id="nextPage" href="#">下一页</a></li>
                       <li><a href="unit_page_s?page_s.currentPage=${page_s.pageCount }">尾页</a></li>
                   </ul>
               </nav>
            </div>
     </div>
</div>
<script type="text/javascript">
		var one=${page_s.currentPage};
		var two=${page_s.pageCount }
		if(one > 1){
			document.getElementById("prePage").setAttribute("href", "unit_page_s?page_s.currentPage="+(one-1));
		}
		if(one < two){
			document.getElementById("nextPage").setAttribute("href", "unit_page_s?page_s.currentPage="+(one+1));
		}
</script>
</body>

</html>