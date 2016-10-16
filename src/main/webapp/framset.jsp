<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评教系统</title>
<link  rel="Shortcut Icon" href="images/zx1.ico">
<link rel="icon" href="images/zx1.ico" type="image/x-icon" />
<script type="text/javascript">
	if(window!=window.parent){
		parent.location.href='framset.jsp';
	}
</script>
</head>

	<frameset rows="20%,*" cols="100%" frameborder="no" border="0" framespacing="0">
		<frame src="header.html" scrolling="no"></frame>
	<frameset cols="12%,88%" rows="100%" frameborder="yes"  framespacing="1">
		<frame src="caidan.jsp" scrolling="no"></frame>
	    <frame src="huanying.html"  frameborder="yes" framespacing="1" name="right"></frame>
	    </frameset>
	    <noframes></noframes>

</html>