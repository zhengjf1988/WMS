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
<link href="<%=basePath%>bootstrap/css/zTreeStyle/metro.css"
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
<script type="text/javascript"
	src="<%=basePath%>bootstrap/js/jquery.ztree.all-3.5.min.js"
	charset="UTF-8"></script>
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
</body>
</html>
