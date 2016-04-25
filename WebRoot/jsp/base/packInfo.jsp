<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<script type="text/javascript" src="<%=basePath%>js/packInfo.js"></script>
<script type="text/javascript">
	function linkPage(id) {
		$("#packId").val(id);
		$.ajax({
			type : "post",
			async : true,
			url : "pack/linkPage.do",
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
				var tmp = eval('(' + data + ')');
				//后台返回数组用这个解析
				//var resJSON = eval(data);
				if (parseInt(id) > 0) {

					$("#packName").val(tmp.packName);
					$("#count").val(tmp.count);
					$("#comments").val(tmp.comments);
					$("#bulk").val(tmp.bulk);
				} else {
					$("#packName").val("");
					$("#count").val("");
					$("#comments").val("");
					$("#bulk").val("");
				}
			}
		});
		openModal();
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

			<h2>包装信息管理</h2>
			<hr>
			<form action="pack/seach.do" class="form-horizontal" method="post">
				<div class="row">
					<div class="col-lg-2">
						<button type="button" class="btn btn-primary" data-toggle="modal" onclick="linkPage(0)">添加包装信息</button>
					</div>
					<div class="col-lg-2">
						<!-- <div class="input-group">
								<input type="text" class="form-control" placeholder="标题...">
							</div> -->
						<!-- /input-group -->
					</div>
					<div class="col-lg-2">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="包装名称..." name="seachPackName" value="${item.packName }">
						</div>
						<!-- /input-group -->
					</div>
					<div class="col-lg-2">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="数量..." name="seachCount" value="${item.count }">
						</div>
						<!-- /input-group -->
					</div>
					<div class="col-lg-2">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="体积..." name="seachBulk" value="${item.bulk }">
						</div>
						<!-- /input-group -->
					</div>

					<div class="col-lg-2">
						<div class="input-group">
							<input type="submit" value="查询" class="btn">
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
							<td class="text-center">包装名称</td>
							<td class="text-center">数量(件)</td>
							<td class="text-center">体积(m³)</td>
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
								<td><c:out value="${item.packName}" /></td>
								<td><c:out value="${item.count}" /></td>
								<td><c:out value="${item.bulk}" /></td>
								<td><c:out value="${item.comments}" /></td>
								<td><c:out value="${item.creatDate}" /></td>
								<td><c:out value="${item.owner}" /></td>
								<td><a onClick="linkPage('${item.id}')">编辑</a> || <a onClick="openMassageModal('${item.id}')">删除</a>
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

<form action="pack/save.do" class="form-horizontal" role="form" method="post" id="saveForm">
	<div class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel" id="gridSystemModal" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="gridSystemModalLabel">包装信息</h4>
				</div>
				<div class="modal-body" style="padding-bottom: 0">
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">包装名称</label>
						<div class="col-sm-10">
							<input type="hidden" class="form-control" id="packId" name="packId">
							<input type="text" class="form-control" id="packName" name="packName">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">数量(件)</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="count" name="count">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">体积(m³)</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="bulk" name="bulk">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label"> 备注信息 </label>
						<div class="col-sm-10">
							<!-- 	<input type="texta" class="form-control" id="inputTitle"
									name="username"> -->

							<textarea rows="8" class="form-control" id="comments" name="comments"></textarea>
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
<form action="pack/delete.do" method="post">
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