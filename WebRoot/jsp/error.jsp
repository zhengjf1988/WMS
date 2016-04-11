<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<meta name="description"
	content="Source code generated using layoutit.com">
<meta name="author" content="LayoutIt!">

<base href="<%=basePath%>">

<title>WMS</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
	<div class="container-fluid"
		style="background-color: #1F619C;height: 100%;background: -webkit-gradient(linear,0 0,0 100%,from(#ffffff),to(#1F619C));">
		<div class="row">
			<div class="col-md-12" style="padding-left: 80px;padding-top: 30px;">
				<!-- <div class="alert alert-danger" role="alert">程序出错了，请联系管理员！</div> -->

				<div class="alert alert-danger center-block" role="alert"
					style="width: 50%">
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span> <span class="sr-only">Error:</span> <strong>程序出错了，请联系管理员！</strong><br />
					<br /> <br /> <br /> <a href="#">点此重新登录！</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
