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
					<div class="panel-body">公告管理</div>
					<div class="panel-body">部门管理</div>
					<div class="panel-body">角色管理</div>
					<div class="panel-body">员工管理</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
