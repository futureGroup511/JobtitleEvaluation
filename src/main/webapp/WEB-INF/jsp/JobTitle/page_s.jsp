<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>第${page_s.currentPage }页查看所有职称</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/jobTitle_page_s.css">
</head>
<body>

<div class="dangqian">
  <div class="row">
    <div class="col-lg-1 col-lg-offset-1 col-md-2  col-xs-2 col-xs-offset-1">
            <a><p>职称管理</p></a>
        </div>
        <div class="col-lg-2 col-lg-offset-6 col-md-3 col-md-offset-3 col-xs-5  col-xs-offset-1">
            <p>当前位置：管理员>>查看职称</p>
        </div>
        <div class="col-lg-2 col-md-3 col-xs-3">
            <p>欢迎登录本系统</p>
        </div>
  </div>
</div>
<center>
	<h1 class="remind">${remind }</h1>
	<s:set name="remind" value=" " scope="session"></s:set>
	<h3>第${page_s.currentPage } / ${page_s.pageCount }页--所有职称信息</h3>
</center>
 <table class="table table-bordered table-hover">
            <tbody>
                <tr>
                    
                    <td>职称名字</td>
                    <td>修改</td>
                </tr>
                <c:forEach var="jt" items="${page_s.recordlist }">
					<tr>
					<td>${jt.jobTi_name }</td>
					<td><a href="jobTitle_changePage?jobTitle.jobTi_id=${jt.jobTi_id }&page_s.currentPage=${page_s.currentPage }">修改</a></td>
					</tr>
				</c:forEach>
            </tbody>
  </table>
  <div class="container">
      <div class="row">
           <div class="col-lg-3 col-lg-offset-3 col-md-5 col-md-offset-3 col-xs-5 col-xs-offset-3">
               <nav>
                   <ul class="pagination">
                       <li><a href="jobTitle_page_s?page_s.currentPage=1">首页</a></li>
                       <li><a id="prePage" href="#">上一页</a></li>
                       <li><a href="jobTitle_page_s?page_s.currentPage=${page_s.currentPage }">${page_s.currentPage } / ${page_s.pageCount }</a></li>
                       <%-- 
                       <c:forEach var="p" begin="${page_s.beginPageIndex }" end="${page_s.currentPage - 1 }" step="1">
							<li><a href="jobTitle_page_s?page_s.currentPage=${p }">${p }</a></li>
						</c:forEach>
						<li><a style="color:red">${page_s.currentPage }</a></li>
						<c:forEach var="p" begin="${page_s.currentPage + 1 }" end="${page_s.endPageIndex }" step="1">
							<li><a href="jobTitle_page_s?page_s.currentPage=${p }">${p }</a></li>
						</c:forEach>
                        --%>
                       <li><a id="nextPage" href="#">下一页</a></li>
                       <li><a href="jobTitle_page_s?page_s.currentPage=${page_s.pageCount }">尾页</a></li>
                   </ul>
               </nav>
            </div>
          <%--   
           <form>
	            <label class="col-lg-1 col-md-1 col-xs-1 control-label">跳到第</label>
                <div class="col-lg-2 col-md-2 col-xs-2">
	              <select class="form-control" style="width:50%;" name="page_s.currentPage">
 	 	              
					<c:forEach var="p" begin="1" end="${page_s.pageCount }" step="1">
						 <option>${p }</option>
					</c:forEach>
	              </select>
                <label class="col-lg-1 col-md-1 col-xs-1 control-label" style="margin-top:-28px; margin-left:65%;">页</label>
                </div>
                <button type="submit" class="btn btn-primary" >跳转</button>
             </form>
              --%>
     </div>
</div>
<script type="text/javascript">
		var one=${page_s.currentPage};
		var two=${page_s.pageCount }
		if(one > 1){
			document.getElementById("prePage").setAttribute("href", "jobTitle_page_s?page_s.currentPage="+(one-1));
		}
		if(one < two){
			document.getElementById("nextPage").setAttribute("href", "jobTitle_page_s?page_s.currentPage="+(one+1));
		}
</script>
</body>

</html>