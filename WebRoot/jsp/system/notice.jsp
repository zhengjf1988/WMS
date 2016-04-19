<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<script>
	function linkPage(id) {
		//添加或者编辑的时候设置一下ID
		$("#noteId").val(id);
		$.ajax({
			type : "post",
			async : true,
			url : "note/linkPage.do",
			datatype : "json",//请求页面返回的数据类型     
			data : {
				"id" : id
			},
			async : false,
			error : function(request) {
				window.location.href("../error.jsp");
			},
			success : function(data) {
				/* //对象先转字符串*/
				var tmp = eval('(' + data + ')');
				if (parseInt(id) > 0) {
					$("#title").val(tmp.title);
					$("#content").val(tmp.content);
				} else {
					$("#title").val("");
					$("#content").val("");
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
		<div class="col-md-10" style="overflow:auto;">

			<h2>系统公告</h2>
			<hr>

			<form action="note/seach.do" class="form-horizontal" role="form" method="post">
				<div class="row">

					<div class="col-lg-2">
						<!-- <input type="button" value="发布公告" class="btn btn-primar	y"> -->
						<!-- /input-group -->

						<!-- 方法一 -->
						<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#messageModal">测试</button> -->

						<!-- 方法二 -->
						<button type="button" class="btn btn-primary" data-toggle="modal" onclick="linkPage(0)">发布公告</button>
					</div>

					<div class="col-lg-2">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="标题..." id="seachTitle" name="seachTitle" value="${item.title}">
						</div>
						<!-- /input-group -->
					</div>
					<div class="col-lg-2">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="内容..." id="seachContent" name="seachContent" value="${item.content }">
						</div>
						<!-- /input-group -->
					</div>
					<div class="col-lg-2">
						<div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
							<input class="form-control" size="16" type="text" value="${item.creatTime }" readonly id="dateFrom" name="dateFrom" placeholder="开始时间...">
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
							<input class="form-control" size="16" type="text" value="${item.owner }" readonly id="dateTo" name="dateTo" placeholder="结束时间...">
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
							<input type="submit" value="查询" class="btn">
						</div>
						<!-- /input-group -->
					</div>
					<!-- /.col-lg-6 -->
				</div>
				<!-- /.row -->
			</form>

			<div class="table-responsive" style="overflow:scroll;height: 380px;">
				<table class="table table-bordered table-hover">
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
						<c:forEach items="${list}" var="item" varStatus="staturs">
							<tr>
								<td>${staturs.index+1}</td>
								<td><c:out value="${item.title}" />
								</td>
								<td><c:out value="${item.content}" />
								</td>
								<td><c:out value="${item.creatTime}" />
								</td>
								<td><c:out value="${item.owner}" />
								</td>
								<td><a onClick="linkPage('${item.id}')">编辑</a> || <a onclick="openMassageModal('${item.id}')">删除</a>
								</td>
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
<form action="note/save.do" class="form-horizontal" role="form" method="post">
	<div class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel" id="gridSystemModal" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="gridSystemModalLabel">公告信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label"> 标题 </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="title" name="title">
							<input type="hidden" class="form-control" id="noteId" name="noteId">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label"> 内容 </label>
						<div class="col-sm-10">
							<!-- 	<input type="texta" class="form-control" id="inputTitle"
									name="username"> -->

							<textarea rows="8" class="form-control" name="content" id="content"></textarea>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary">保存</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</form>


<!-- message -->
<form action="note/delete.do" method="post">
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
