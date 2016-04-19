<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<script type="text/javascript" src="<%=basePath%>js/userInfo.js"></script>
<div class="container-fluid">
	<div class="row">
		<%@ include file="../top.jsp"%>
	</div>
	<div class="row" style="padding-left: 0">
		<div class="col-md-2" style="padding-left: 10">
			<%@ include file="../left.jsp"%>
		</div>
		<div class="col-md-10">

			<h2>用户管理</h2>
			<hr>
			<form action="user/seach.do" class="form-horizontal" method="post">
				<div class="row">
					<div class="col-lg-2">
						<button type="button" class="btn btn-primary" data-toggle="modal" onclick="linkPage(0)">添加用户</button>
					</div>

					<div class="col-lg-2">
						<div class="input-group">
							<input type="text" maxlength="30" class="form-control" placeholder="用户名..." name="seachUserName" value="${item.username}">
						</div>
						<!-- /input-group -->
					</div>
					<div class="col-lg-2">
						<div class="input-group">
							<input type="text" maxlength="30" class="form-control" placeholder="真实姓名..." name="seachRealName" value="${item.realName}">
						</div>
						<!-- /input-group -->
					</div>
					<div class="col-lg-2">
						<div class="input-group">
							<select class="form-control" id="seachDeptart" name="seachDeptart">
							</select>
						</div>
					</div>
					<div class="col-lg-2">
						<div class="input-group">
							<select class="form-control" id="seachRoleName" name="seachRoleName">
							</select>
						</div>
					</div>
					<div class="col-lg-2">
						<div class="input-group">
							<input type="submit" value="查询" class="btn">
						</div>
					</div>
				</div>
			</form>


			<div class="table-responsive " style="overflow:scroll;height: 380px;">
				<table class="table table-bordered table-hover">
					<thead>
						<tr class="success">
							<td class="text-center">序号</td>
							<td class="text-center">登录名</td>
							<td class="text-center">真实姓名</td>
							<td class="text-center">角色</td>
							<td class="text-center">部门</td>
							<td class="text-center">备注</td>
							<td class="text-center">创建时间</td>
							<td class="text-center">创建人</td>
							<td class="text-center">操作</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="item" varStatus="staturs">
							<tr>
								<td>${staturs.index+1}</td>
								<td><c:out value="${item.username}" /></td>
								<td><c:out value="${item.realName}" /></td>
								<td><c:out value="${item.roleName}" /></td>
								<td><c:out value="${item.departmentName}" /></td>
								<td style="word-break:break-all;width: 400px;"><c:out value="${item.comments}" /></td>
								<td><c:out value="${item.creatDate}" /></td>
								<td><c:out value="${item.owner}" /></td>
								<td><a onClick="linkPage('${item.id}')">编辑</a> || <a onClick="openMassageModal('${item.id}')">删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<ul class="pagination">
				<li><a href="#">上一页</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">下一页</a></li>
			</ul>
		</div>
	</div>
</div>
<form action="user/save.do" class="form-horizontal" role="form" method="post" id="saveForm">
	<div class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel" id="gridSystemModal" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="gridSystemModalLabel">用户信息</h4>
				</div>
				<div class="modal-body" style="padding-bottom: 0">
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">登录名称</label>
						<div class="col-sm-10">
							<input type="text" maxlength="30" class="form-control" id="username" name="username" onblur="checkUserName()">
							<input type="hidden" class="form-control" id="userId" name="userId">

						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">真实姓名</label>
						<div class="col-sm-10">
							<input type="text" maxlength="30" class="form-control" id="realName" name="realName">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">登录密码</label>
						<div class="col-sm-10">
							<input maxlength="30" type="password" class="form-control" id="psw" name="psw">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-10">
							<input maxlength="30" type="password" class="form-control" id="surePsw">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">角色</label>
						<div class="col-sm-10">
							<select class="form-control" id="fk_roleId" name="fk_roleId">
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">部门</label>
						<div class="col-sm-10">
							<select class="form-control" id="fk_departmentId" name="fk_departmentId">
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label"> 备注信息 </label>
						<div class="col-sm-10">
							<!-- 	<input type="texta" class="form-control" id="inputTitle"
									name="username"> -->

							<textarea rows="4" class="form-control" id="comments" name="comments"></textarea>
						</div>
					</div>
					<div class="alert alert-danger sm" id="msgDiv" style="display: none;padding-bottom: 0;padding-top: 0;padding-left: 40px;">
						<label id="msg"></label>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="saveInfo()">保存</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</form>

<!-- message -->
<form action="user/delete.do" method="post">
	<div class="modal fade" role="dialog" aria-labelledby="messageModalLabel" id="messageModal" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="messageModalLabel">消息</h3>
				</div>
				<div class="modal-body" style="padding-bottom: 0px">
					<div class="alert alert-warning" role="alert" style="padding-top: 0px">
						<h3>
							<input type="hidden" id="deleteId" name="deleteId">
							<span class="glyphicon glyphicon-question-sign" aria-hidden="true" />
							是否确定删除选择的数据？
						</h3>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="submit" class="btn btn-primary">确定</button>
				</div>
			</div>
		</div>
	</div>
</form>
<!-- message -->
<%@ include file="/include.foot.jsp"%>