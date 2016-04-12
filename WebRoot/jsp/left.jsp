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
	<div class="col-md-12" style="padding-left: 0;width: 100%">
		<div class="panel-group" id="panel-73792">
			<div class="panel panel-default">
				<div class="panel-heading">
					<a class="panel-title collapsed" data-toggle="collapse"
						data-parent="#panel-73792" href="#panel-element-595369"> 任务管理</a>
				</div>
				<div id="panel-element-595369" class="panel-collapse collapse">
					<div class="panel-body">任务111111111111111111</div>
					<div class="panel-body">任务222222222222</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<a class="panel-title" data-toggle="collapse"
						data-parent="#panel-73792" href="#panel-element-620094">入库管理</a>
				</div>
				<div id="panel-element-620094" class="panel-collapse collapse">
					<div class="panel-body">入库111111111111</div>
					<div class="panel-body">入库22222222222222222222</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<a class="panel-title" data-toggle="collapse"
						data-parent="#panel-73792" href="#panel-element-120094">系统管理</a>
				</div>
				<div id="panel-element-120094" class="panel-collapse collapse in">
					<div class="panel-body">
						<li><a href="note/list.do">公告管理</a></li>
					</div>
					<div class="panel-body">
						<li><a href="depart/list.do">部门管理</a></li>
					</div>
					<div class="panel-body">
						<li><a href="role/list.do">角色管理</a></li>
					</div>
					<div class="panel-body">员工管理</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
