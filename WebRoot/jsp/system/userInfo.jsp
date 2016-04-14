<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<script type="text/javascript" src="<%=basePath%>js/userInfo.js"></script>
<script type="text/javascript">
	function linkPage(id) {
		$("#msgDiv").hide();
		$.ajax({
			type : "post",
			async : true,
			url : "user/linkPage.do",
			datatype : "json",//请求页面返回的数据类型     
			data : {
				"id" : id
			},
			async : false,
			/* error : function(request) {
				alert("编辑请求返回失败!");
			}, */
			success : function(data) {
				//对象先转字符串
				var resJSON = eval('(' + data + ')');
				var fk_roleId = 0;
				var fk_departmentId = 0;
				//后台返回数组用这个解析
				//var resJSON = eval(data);
				if (parseInt(id) > 0) {
					$("#username").attr("readonly", true);
					var tmp = resJSON.item;
					fk_roleId = tmp.fk_roleId;
					fk_departmentId = tmp.fk_departmentId;

					$("#username").val(tmp.username);
					$("#realName").val(tmp.realName);
					$("#comments").val(tmp.username);
					$("#departmentName").val(tmp.departmentName);
				} else {
					$("#username").attr("readonly", false);
					$("#username").val("");
					$("#realName").val("");
					$("#comments").val("");
					$("#departmentName").val("");
				}

				var roleList = resJSON.roleList;

				var selectId = "fk_roleId";
				RemoveOption(selectId);

				var role = $("#fk_roleId");

				role.append("<option value='0'>--请选择--</option>");//方法1：添加默认节点 
				$.each(roleList, function(i, item) {
					var proid = item.id;
					var proname = item.roleName;
					if (fk_roleId == item.id) {
						AppendOption(selectId, proid, proname, true);//调用自定义方法
					} else {
						AppendOption(selectId, proid, proname, false);//调用自定义方法
					}

				});

				var depList = resJSON.depList;

				var selectId1 = "fk_departmentId";
				RemoveOption(selectId1);
				var depart = $("#fk_departmentId");

				depart.append("<option value='0'>--请选择--</option>");//方法1：添加默认节点 
				$.each(depList, function(i, item) {
					var proid = item.id;
					var proname = item.departmentName;
					if (fk_departmentId == item.id) {
						AppendOption(selectId1, proid, proname, true);//调用自定义方法
					} else {
						AppendOption(selectId1, proid, proname, false);//调用自定义方法
					}
				});
			}
		});

		openModal();
	}

	function RemoveOption(selId) {//删除节点
		var obj = document.getElementById(selId);
		obj.options.length = 0;
	}

	function AppendOption(selId, value, text, selected) {
		var sel;
		if (selected) {
			sel = ' selected="selected"';
		}
		$("#" + selId).append(
				"<option value='" + value + "'" + sel + ">" + text
						+ "</option>");
	}
</script>
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
			<form action="" class="form-horizontal" role="form">
				<div class="row">

					<div class="col-lg-2">
						<button type="button" class="btn btn-primary" data-toggle="modal" onclick="linkPage(0)">添加用户</button>
					</div>


					<div class="col-lg-2">
						<!-- <div class="input-group">
								<input type="text" class="form-control" placeholder="标题...">
							</div> -->
						<!-- /input-group -->
					</div>
					<div class="col-lg-2">
						<!-- <div class="input-group">
								<span class="input-group-btn"> <input type="text"
									class="form-control" placeholder="内容...">
							</div> -->
						<!-- /input-group -->
					</div>
					<div class="col-lg-2">
						<div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
							<input class="form-control" size="16" type="text" value="" readonly id="dateFrom" placeholder="开始时间...">
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-remove"></span>
							</span>
							<!-- <span class="input-group-addon">
										<span class="glyphicon glyphicon-calendar"></span>
									</span> -->
						</div>
						<!-- /input-group -->
					</div>
					<div class="col-lg-2">
						<div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
							<input class="form-control" size="16" type="text" value="" readonly id="dateTo" placeholder="结束时间...">
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-remove"></span>
							</span>
							<!-- <span class="input-group-addon">
										<span class="glyphicon glyphicon-calendar"></span>
									</span> -->
						</div>
						<!-- /input-group -->
					</div>

					<div class="col-lg-2">
						<div class="input-group">
							<input type="button" value="查询" class="btn">
						</div>
						<!-- /input-group -->
					</div>
					<!-- /.col-lg-6 -->
				</div>
				<!-- /.row -->
			</form>


			<div class="table-responsive ">
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
								<td><c:out value="${item.username}" />
								</td>
								<td><c:out value="${item.realName}" />
								</td>
								<td><c:out value="${item.roleName}" />
								</td>
								<td><c:out value="${item.departmentName}" />
								</td>
								<td><c:out value="${item.comments}" />
								</td>
								<td><c:out value="${item.creatDate}" />
								</td>
								<td><c:out value="${item.owner}" />
								</td>
								<td><a onClick="linkPage('${item.id}')">编辑</a> | <a onClick="">删除</a></td>
							</tr>
						</c:forEach>
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
							<input type="text" class="form-control" id="username" name="username" onblur="checkUserName()">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">真实姓名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="realName" name="realName">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">登录密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="psw" name="psw">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="surePsw">
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


<script type="text/javascript">
	$('.form_date').datetimepicker({
		language : 'zh-CN',
		format : "yyyy-mm-dd",
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0
	});

	function openModal() {
		$('#gridSystemModal').modal({
			backdrop : 'static'
		});
	}

	function check() {
		$("#msg").hide();
	}
</script>
<%@ include file="/include.foot.jsp"%>