<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String base = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html style="overflow-x: hidden; overflow-y: hidden; ">
<head>
<base href="<%=base%>">
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
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- 指定苹果设备添加到主屏的标题 -->
<meta name="apple-mobile-web-app-title" content="title2">
<!-- Favicons
	================================================== -->

<link href="<%=base%>bootstrap/css/bootstrap.min.css" rel="stylesheet" media="all">
<link href="<%=base%>bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="all">
<link href="<%=base%>css/zTreeStyle/zTreeStyle.css" rel="stylesheet" media="all">

<script type="text/javascript" src="<%=base%>jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=base%>jquery/jquery.ztree.core.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=base%>jquery/jquery.ztree.excheck.js" charset="UTF-8"></script>

<script type="text/javascript" src="<%=base%>bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=base%>bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=base%>bootstrap/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=base%>bootstrap/js/popover.js"></script>
<script type="text/javascript">
	//打开添加或者修改框
	function openModal() {
		$('#gridSystemModal').modal({
			backdrop : 'static'
		});
	}

	//打开删除消息确认框
	function openMassageModal(id) {
		$('#messageModal').modal({
			backdrop : 'static'
		});
		$("#deleteId").val(id);
	};
</script>
</head>
<body>