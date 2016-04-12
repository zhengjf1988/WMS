<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/../include.inc.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Bootstrap 3, from LayoutIt!</title>

<meta name="description"
	content="Source code generated using layoutit.com">
<meta name="author" content="LayoutIt!">

<base href="<%=basePath%>">

<title>纺织行业WMS产品样品管理子系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="js/jquery-ui"></script>
<link href="css/bootstrap-combined.min.css" rel="stylesheet"
	media="screen">
<script type="text/javascript" src="js/bootstrap.min.js"></script>


<!--		<script type="text/javascript" src="js/common.js">-->
<!--</script>-->
<script type="text/javascript">
	$(function() {
		$("#login_BT").click(function() {
			$("#login_form").submit();
		});
	});
</script>

</head>

<body>

	<div class="container-fluid" style="background-color: #1F619C;">
		<div class="row-fluid" style="height: 30%;">
			<div class="span12"
				style="padding-left: 80px;padding-top: 60px;color: white;">
				<h1>联众包装设计（上海）有限公司</h1>
			</div>
		</div>
		<div class="row-fluid" style="height: 40%; background-color:white ;">
			<div class="span3" style="padding-top: 50;padding-left: 40">
				<img alt="140x140" src="img/bg.png" />
			</div>
			<div class="span3" style="padding-top: 70">
				<h3>WMS仓库管理系统</h3>
			</div>
			<div class="span4" style="padding-top: 40">
				<form class="form-horizontal">
					<div class="control-group">
						<label class="control-label" for="inputEmail">Email</label>
						<div class="controls">
							<input id="inputEmail" type="text" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword">密码</label>
						<div class="controls">
							<input id="inputPassword" type="password" />
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<label class="checkbox"><input type="checkbox" /> 记住我</label>
							<button class="btn" type="submit">登陆</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row-fluid" style="height: 30%; ">
			<div class="span12">
				<address style="padding-top: 50;padding-left:400;">
					<strong>Twitter, Inc.</strong> 795 Folsom Ave, Suite 600 San
					Francisco, CA 94107<br /> <abbr title="Phone">P:</abbr> (123)
					456-7890
				</address>
			</div>
		</div>
	</div>
</body>
</html>
