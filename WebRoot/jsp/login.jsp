<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="../include.inc.jsp"%>
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

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
