<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>

<!-- <div class="row"
	style="background-color: #1F619C;height: 100%;width:98%;background: -webkit-gradient(linear,0 0,0 100%,from(#ffffff),to(#1F619C));">
	<div class="col-md-3" style="height: 23%"></div>
	<div class="col-md-6"></div>
	<div class="col-md-3"></div>
</div> -->
<script type="text/javascript">
	$(function() {
	});
</script>
<div class="container-fluid"
	style="overflow;background-color: #1F619C;height: 100%;width:100% ;background:-webkit-gradient(linear,0 0,0 100%,from(#ffffff),to(#1F619C));">
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

					<label for="inputEmail3" class="col-md-2 control-label">
						用户名 </label>
					<div class="col-md-10">
						<input type="text" class="form-control" id="inputEmail3"
							name="username" value="admin">
					</div>
				</div>
				<div class="form-group">

					<label for="inputPassword3" class="col-md-2 control-label">
						密码 </label>
					<div class="col-md-10">
						<input type="password" class="form-control" id="inputPassword3"
							name="psw" value="111111">
					</div>
				</div>
				<div class="col-md-offset-2 col-md-10">
					<c:if test="${user==''}">
						<div class="alert alert-danger" role="alert">用户名或密码错误！</div>
					</c:if>
				</div>
				<div class="form-group">
					<div class="col-md-offset-2 col-md-10">
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
				San Francisco, CA 94107<br> <abbr title="Phone">P:</abbr> (123)
				456-7890
			</address>
		</div>
	</div>
</div>
<%@ include file="/include.foot.jsp"%>