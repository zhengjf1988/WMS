<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="container-fluid">
	<div class="row" style="background-color: #1F619C;height: 7.7%">
		<div class="col-md-10" style="padding-left: 40px;color: white;height: 100%">
			<label style="font-size: 30px;padding-top: 3">WMS 云仓库管理系统</label>
		</div>
		<div class="col-md-2" style="padding-left: 40px;color: white;">
			<ul class="nav navbar-nav " style="background-color: white;height: 100%">
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
						设置<strong class="caret"></strong>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#">个人设置</a>
						</li>
						<li class="divider"></li>
						<li><a onclick="logout()">退出</a>
						</li>
					</ul>
				</li>
			</ul>
			<form action="logout.do" method="post" id="logoutForm"></form>
		</div>
	</div>
</div>
<script>
	function logout() {
		sessionStorage.setItem("key", null);
		$("#logoutForm").submit();
	}
</script>