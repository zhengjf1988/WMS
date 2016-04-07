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

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/style.css" rel="stylesheet">
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/scripts.js"></script>

</head>
<body>
	<div class="container-fluid">
		<div class="row"><jsp:include page="top.jsp" /></div>
		<div class="row" style="padding-left: 0">
			<div class="col-md-2" style="padding-left: 0"><jsp:include
					page="left.jsp" /></div>
			<div class="col-md-10">

				<h2>系统公告</h2>
				<hr>

				<form>
					<div class="row">
						<div class="col-lg-2">
							<div class="input-group">
								<input type="text" class="form-control" placeholder="标题...">
							</div>
							<!-- /input-group -->
						</div>
						<div class="col-lg-2">
							<div class="input-group">
								<span class="input-group-btn"> <input type="text"
									class="form-control" placeholder="内容...">
							</div>
							<!-- /input-group -->
						</div>
						<div class="col-lg-2">
							<div class="input-group">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">Go!</button> </span> <input
									type="text" class="form-control" placeholder="Search for...">
							</div>
							<!-- /input-group -->
						</div>
						<div class="col-lg-2">
							<div class="input-group">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">Go!</button> </span> <input
									type="text" class="form-control" placeholder="Search for...">
							</div>
							<!-- /input-group -->
						</div>
						<div class="col-lg-2">
							<div class="input-group">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">Go!</button> </span> <input
									type="text" class="form-control" placeholder="Search for...">
							</div>
							<!-- /input-group -->
						</div>
						<div class="col-lg-2">
							<div class="input-group">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">Go!</button> </span> <input
									type="text" class="form-control" placeholder="Search for...">
							</div>
							<!-- /input-group -->
						</div>
						<!-- /.col-lg-6 -->
					</div>
					<!-- /.row -->
				</form>


				<div class="table-responsive ">
					<table class="table table-bordered">
						<thead>
							<tr class="success">
								<td class="text-center">序号</td>
								<td class="text-center">标题</td>
								<td class="text-center">内容</td>
								<td class="text-center">时间</td>
								<td class="text-center">发布人</td>
								<td class="text-center">操作</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="">序号</td>
								<td class="">标题</td>
								<td class="">内容</td>
								<td class="">时间</td>
								<td class="">时间</td>
								<td class=""><a>详情</a>
								</td>
							</tr>
							<tr>
								<td class="">序号</td>
								<td class="">标题</td>
								<td class="">内容</td>
								<td class="">时间</td>
								<td class="">时间</td>
								<td class="">详情</td>
							</tr>
							<tr>
								<td class="">序号</td>
								<td class="">标题</td>
								<td class="">内容</td>
								<td class="">时间</td>
								<td class="">时间</td>
								<td class="">详情</td>
							</tr>
						</tbody>
					</table>
				</div>
				<ul class="pagination">
					<li><a href="#">上一页</a>
					</li>
					<li><a href="#">1</a>
					</li>
					<li><a href="#">2</a>
					</li>
					<li><a href="#">3</a>
					</li>
					<li><a href="#">4</a>
					</li>
					<li><a href="#">5</a>
					</li>
					<li><a href="#">下一页</a>
					</li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>
