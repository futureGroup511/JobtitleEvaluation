<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查找结果</title>
</head>
<body>
<center>
	<%-- <h1>查找结果</h1>
	<table>
		<tbody>
			<tr>
				<td>单位ID</td>
				<td>单位名字</td>
				<td>修改</td>
			</tr>
			<c:forEach var="jt" items="${findResults }">
				<tr>
				<td>${jt.uni_id }</td>
				<td>${jt.uni_name }</td>
				<td><a href="unit_changePage?unit.uni_id=${jt.uni_id }">修改</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table> --%>
	
	<div class="dangqian">
  <div class="row">
    <div class="col-lg-1 col-lg-offset-1 col-md-2  col-xs-2 col-xs-offset-1">
            <a><p>添加信息</p></a>
        </div>
        <div class="col-lg-2 col-lg-offset-6 col-md-3 col-md-offset-3 col-xs-5  col-xs-offset-1">
            <p>当前位置：学生服务>>报名</p>
        </div>
        <div class="col-lg-2 col-md-3 col-xs-3">
            <p>欢迎登录本系统</p>
        </div>
  </div>
</div>
  <table class="table table-bordered table-hover">
            <tbody>
                <tr>
                    <td>单位ID</td>
                    <td>单位名字</td>
                    <td><a href="#">修改</a></td>
                </tr>
            </tbody>
  </table>
  <div class="container">
      <div class="row">
           <div class="col-lg-3 col-lg-offset-3 col-md-5 col-md-offset-3 col-xs-5 col-xs-offset-3">
               <nav>
                   <ul class="pagination">
                       <li><a href="#">首页</a></li>
                       <li><a href="#">上一页</a></li>
                       <li><a href="#">3</a></li>
                       <li><a href="#">下一页</a></li>
                       <li><a href="#">尾页</a></li>
                   </ul>
               </nav>
            </div>
           <form>
	            <label class="col-lg-1 col-md-1 col-xs-1 control-label">跳到第</label>
                <div class="col-lg-2 col-md-2 col-xs-2">
	              <select class="form-control" style="width:50%;">
 	 	              <option>1</option>
 		              <option>2</option>
  		              <option>3</option>
 		              <option>4</option>
  		              <option>5</option>
	              </select>
                <label class="col-lg-1 col-md-1 col-xs-1 control-label" style="margin-top:-28px; margin-left:65%;">页</label>
                </div>
                <button type="submit" class="btn btn-primary">跳转</button>
             </form>
     </div>
</div>
</center>
</body>
</html>