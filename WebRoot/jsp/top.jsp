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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/style.css" rel="stylesheet">

</head>
<body>
	<div class="container-fluid">
		<div class="row" style="background-color: #1F619C;height: 7.7%">
			<div class="col-md-10"
				style="padding-left: 40px;color: white;height: 100%">
				<label style="font-size: 30px;padding-top: 3">WMS 云仓库管理系统</label>
			</div>
			<div class="col-md-2" style="padding-left: 40px;color: white;">
				<ul class="nav navbar-nav "
					style="background-color: white;height: 100%">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">设置<strong class="caret"></strong> </a>
						<ul class="dropdown-menu">
							<li><a href="#">修改密码</a>
							</li>
							<li><a href="#">Another action</a>
							</li>
							<li><a href="#">Something else here</a>
							</li>
							<li class="divider"></li>
							<li><a href="#">退出</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<script src="bootstrap/js/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/scripts.js"></script>
</body>
</html>
