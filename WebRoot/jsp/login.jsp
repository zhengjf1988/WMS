<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href=" <%=basePath%>">
<meta charset="UTF-8">
<title>WMS仓库管理系统</title>
<meta name="description" content="">
<meta name="author" content="dx&will">
<!-- 让360双核浏览器用webkit内核渲染页面 !!! 注意，这行最好放在前面，防止浏览器开始解析的时候采用其它内置的渲染方案
	================================================== -->
<meta name="renderer" content="webkit">
<!-- 让IE浏览器用最高级内核渲染页面 还有用 Chrome 框架的页面用webkit 内核
	================================================== -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!-- IOS6全屏 Chrome高版本全屏
	================================================== -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="mobile-web-app-capable" content="yes">
<!-- Mobile Specific Metas
	================================================== -->
<!-- !!!注意 minimal-ui 是IOS7.1的新属性，最小化浏览器UI，但是在iOS8.1突然被取消 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- 指定苹果设备添加到主屏的标题 -->
<meta name="apple-mobile-web-app-title" content="title2">
<!-- Favicons
	================================================== -->

<link href="<%=basePath%>bootstrap/css/bootstrap.min.css"
	rel="stylesheet" media="all">
<link href="<%=basePath%>bootstrap/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" media="all">

<script type="text/javascript"
	src="<%=basePath%>jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript"
	src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>bootstrap/js/bootstrap-datetimepicker.js"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="<%=basePath%>bootstrap/js/bootstrap-datetimepicker.zh-CN.js"
	charset="UTF-8"></script>
</head>
<body>
	<div class="container-fluid"
		style="background-color: #1F619C;height: 100%;background: -webkit-gradient(linear,0 0,0 100%,from(#ffffff),to(#1F619C));">
		<div class="row" style="height: 23%">
			<div class="col-md-12" style="padding-left: 80px;padding-top: 30px;">
				<h1>WMS 云仓库管理系统</h1>
			</div>
		</div>
		<div class="row" style="height: 47%;">
			<div class="col-md-6">
				<img alt="Bootstrap Image Preview" src="img/bg2.png"
					style="padding-left: 90px;">
			</div>
			<div class="col-md-6">
				<form class="form-horizontal" role="form"
					style="padding-top: 60px;padding-right: 40px" action="login.do"
					method="post">
					<div class="form-group">

						<label for="inputEmail3" class="col-sm-2 control-label">
							用户名 </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputEmail3"
								name="username" value="admin">
						</div>
					</div>
					<div class="form-group">

						<label for="inputPassword3" class="col-sm-2 control-label">
							密码 </label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="inputPassword3"
								name="psw" value="111111">
						</div>
					</div>
					<div class="col-sm-offset-2 col-sm-10">
						<c:if test="${user==''}">
							<div class="alert alert-danger" role="alert">用户名或密码错误！</div>
						</c:if>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-primary btn-block">登录</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row" style="height: 30%;padding-top: 40px;color: white;"
			align="center">
			<div class="col-md-12">
				<address>
					<strong>Twitter, Inc.</strong><br> 795 Folsom Ave, Suite 600<br>
					San Francisco, CA 94107<br> <abbr title="Phone">P:</abbr>
					(123) 456-7890
				</address>
			</div>
		</div>
	</div>
</body>
</html>
