<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<script type="text/javascript">
	var setting = {
		check : {
			enable : true
		},
		data : {
			simpleData : {
				enable : true,
				idKey : "id",//设置树节点id，节点参数id必须与之相匹配，即在Actiob中穿过来的值必须与之相对应
				pIdKey : "parentId"//设置pid，节点参数pid必须与之相匹配
			}
		}
	};
	var zTree;
	var treeNodes;

	function linkPage(id) {
		//添加或者编辑的时候设置一下ID
		$("#pk_id").val(id);

		$.ajax({
			type : "post",
			async : true,
			url : "role/linkPage.do",
			datatype : "json",//请求页面返回的数据类型     
			data : {
				"id" : id
			},
			async : false,
			/* error : function(request) {
				alert("编辑请求返回失败!");
			}, */
			success : function(data) {
				/* //对象先转字符串*/
				var resJSON = eval('(' + data + ')');
				treeNodes = resJSON.list;

				if (parseInt(id) > 0) {
					var tmp = resJSON.item;
					$("#roleName").val(tmp.roleName);
					$("#comments").val(tmp.comments);
				} else {
					$("#roleName").val("");
					$("#comments").val("");
				}
			}
		});
		openModal();
	}

	function saveInfo() {
		var treeObj = $.fn.zTree.getZTreeObj("tree");
		var nodes = treeObj.getCheckedNodes(true);
		var permission = "";
		$.each(nodes, function(i, v) {
			permission += ";" + v.id + ";";
		});
		$("#permission").val(permission);
		$("#saveForm").submit();
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

			<h2>角色管理</h2>
			<hr>

			<form action="" class="form-horizontal" role="form">
				<div class="row">

					<div class="col-lg-2">
						<button type="button" class="btn btn-primary" data-toggle="modal" onclick="linkPage(0)">添加角色</button>
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
							<input class="form-control" size="16" type="text" value="" readonly id="dateTo" placeholder="结束时间..." />
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
							<td class="text-center">角色名称</td>
							<td class="text-center">备注信息</td>
							<td class="text-center">创建时间</td>
							<td class="text-center">创建人</td>
							<td class="text-center">操作</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="item" varStatus="staturs">
							<tr>
								<td>${staturs.index+1}</td>
								<td><c:out value="${item.roleName}" />
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
<form class="form-horizontal" role="form" method="post" id="saveForm" action="role/save.do">
	<div class="modal fade lg" role="dialog" aria-labelledby="gridSystemModalLabel" id="gridSystemModal" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="gridSystemModalLabel">角色信息</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="inputTitle" class="col-sm-1 control-label"> 名称 </label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="roleName" name="roleName">
									<input type="hidden" class="form-control" id="pk_id" name="id">
									<input type="hidden" class="form-control" id="permission" name="permission">
								</div>
							</div>
							<div class="form-group">
								<label for="inputTitle" class="col-sm-1 control-label"> 备注信息 </label>
								<div class="col-sm-10">
									<!-- 	<input type="texta" class="form-control" id="inputTitle"
									name="username"> -->

									<textarea rows="8" class="form-control" id="comments" name="comments"></textarea>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<ul id="tree" class="ztree"></ul>
						</div>
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

		$.fn.zTree.init($("#tree"), setting, treeNodes);
	}
</script>
<%@ include file="/include.foot.jsp"%>