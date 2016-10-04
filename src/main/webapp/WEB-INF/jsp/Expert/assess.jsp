<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>参评表</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/liwen3.css">

</head>
<body>
	<div class="container">
	  <div class="row">
	    <div class="col-lg-1 col-lg-offset-1 col-md-1 col-lg-offset-1  col-xs-1 col-xs-offset-1">
	        </div>
	        <div class="col-lg-3 col-lg-offset-5 col-md-3 scol-md-offset-5 col-xs-3  col-xs-offset-5">
	            <p>当前位置：审评人员服务>>审评</p>
	        </div>
	        <div class="col-lg-2 col-md-2 col-xs-2">
	            <p>欢迎${expert.exp_name}登录本系统</p>
	        </div>
	  </div>
	</div>
	
	<c:choose>
		<c:when test="${(fn:endsWith( person.parti_pathurl,'.jpg') or fn:endsWith( person.parti_pathurl,'.png'))}">
			<a href="#" onclick="return go('${pageContext.request.contextPath}/participated_lookPicture?parti_pathurl=${person.parti_pathurl}')">显示图片</a>
		</c:when>
		<c:when test="${empty person.parti_pathurl}">
			<p class="text text-danger">资料不存在</p>
		</c:when>
		<c:otherwise>
			<p class="text text-danger">无法显示请下载文件</p>
		</c:otherwise>
	</c:choose>
	<form action="evaluatedrecord_finishAssess" method="post">
		<input type="hidden" name="expert_id" value="1">
		<input type="hidden" name="person_id" value="${person.parti_id }">
		<div class="table-responsive">
   			 <table class="table table-bordered table-hover table-striped">
   			 	<thead>
				<tr class="one">
					<td>标题</td>
					<td>内容</td>
					<td>选项</td>
				</tr>
			</thead>
			<tbody>
					<tr>
						<td>您对参评人从事专业</td>
						<td></td>
						<td>
							<input type="radio" name="evalRecor_spciaFamiliar" value="A">A.熟悉
							<input type="radio" name="evalRecor_spciaFamiliar" value="B" checked="checked">B.比较熟悉
							<input type="radio" name="evalRecor_spciaFamiliar" value="C">C.不太熟悉
						</td>
					</tr>
					<tr>
						<td>教学</td>
						<td>${evaluatedStandard.evalStan_teachStandard }</td>
						<td>
							<input type="radio" name="evalRecor_teaching" value="A">A.优
							<input type="radio" name="evalRecor_teaching" value="B" checked="checked">B.良
							<input type="radio" name="evalRecor_teaching" value="C">C.中
							<input type="radio" name="evalRecor_teaching" value="D">D.差
						</td>
					</tr>
					<tr>
						<td>科研</td>
						<td>${evaluatedStandard.evalStan_scientifiStandard }</td>
						<td>
							<input type="radio" name="evalRecor_research" value="A">A.优
							<input type="radio" name="evalRecor_research" value="B" checked="checked">B.良
							<input type="radio" name="evalRecor_research" value="C">C.中
							<input type="radio" name="evalRecor_research" value="D">D.差
						</td>
					</tr>
					<tr>
						<td>师德</td>
						<td>${evaluatedStandard.evalStan_moralityStandard }</td>
						<td>
							<input type="radio" name="evalRecor_ethics" value="A">A.优
							<input type="radio" name="evalRecor_ethics" value="B" checked="checked">B.良
							<input type="radio" name="evalRecor_ethics" value="C">C.中
							<input type="radio" name="evalRecor_ethics" value="D">D.差
						</td>
					</tr>
					<tr>
						<td>综合评价</td>
						<td></td>
						<td>
							<input type="radio" name="evalRecor_allAssessment" value="优">A.优
							<input type="radio" name="evalRecor_allAssessment" value="良" checked="checked">B.良
							<input type="radio" name="evalRecor_allAssessment" value="中">C.中
							<input type="radio" name="evalRecor_allAssessment" value="差">D.差
						</td>
					</tr>
			</tbody>
			 </table>
		</div>
		<br>
		<div class="col-lg-1 col-lg-offset-9 col-md-1 col-md-offset-9 col-xs-1 col-xs-offset-9">
			<input type="submit" class="btn btn-primary" value="提交">
    	</div>
	</form>
	<c:if test="${!empty person.parti_pathurl }">
		<a href="#" onclick="return popWinGD('${pageContext.request.contextPath}/participated_lookResource?parti_pathurl=${person.parti_pathurl}')">下载文件</a>
	</c:if>
	
</body>

<script language="JavaScript">
		
		function popWinGD(theURL){
			
			 window.location.href=theURL;
			return false;
		}
		
		function go(url){
			var pop,w=670,h=450; //window.navigate(theURL);
			pop=window.open(theURL,"winGD","width="+w+",height="+h+",resizable=yes,menubar=no,toolbar=no,location=no,scrollbars=no,status=no")
 			pop.moveTo((screen.width-w)/2,(screen.height-h)/2);
			 
		}
		
</script>

</html>