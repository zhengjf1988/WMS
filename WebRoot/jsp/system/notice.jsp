<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<div class="container-fluid">
	<div class="row"><jsp:include page="../top.jsp" /></div>
	<div class="row" style="padding-left: 0">
		<div class="col-md-2" style="padding-left: 10"><jsp:include
				page="../left.jsp" /></div>
		<div class="col-md-10" style="overflow:auto;">

			<h2>系统公告</h2>
			<hr>

			<form action="" class="form-horizontal" role="form">
				<div class="row">

					<div class="col-lg-2">
						<!-- <input type="button" value="发布公告" class="btn btn-primar	y"> -->
						<!-- /input-group -->

						<!-- 方法一 -->
						<!-- <button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#gridSystemModal">发布公告</button> -->

						<!-- 方法二 -->
						<button type="button" class="btn btn-primary" data-toggle="modal"
							onclick="openModal()">发布公告</button>
					</div>


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
						<div class="input-group date form_date" data-date=""
							data-date-format="dd MM yyyy" data-link-field="dtp_input2"
							data-link-format="yyyy-mm-dd">
							<input class="form-control" size="16" type="text" value=""
								readonly id="dateFrom" placeholder="开始时间..."> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-remove"></span> </span>
							<!-- <span class="input-group-addon">
										<span class="glyphicon glyphicon-calendar"></span>
									</span> -->
						</div>
						<!-- /input-group -->
					</div>
					<div class="col-lg-2">
						<div class="input-group date form_date" data-date=""
							data-date-format="dd MM yyyy" data-link-field="dtp_input2"
							data-link-format="yyyy-mm-dd">
							<input class="form-control" size="16" type="text" value=""
								readonly id="dateTo" placeholder="结束时间..."> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-remove"></span> </span>
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

			<div class="table-responsive" style="overflow:scroll;height: 380px;">
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
						<c:forEach items="${list}" var="item" varStatus="staturs">
							<tr>
								<td>${staturs.index+1}</td>
								<td><c:out value="${item.title}" /></td>
								<td><c:out value="${item.content}" /></td>
								<td><c:out value="${item.dateTime}" /></td>
								<td><c:out value="${item.owner}" /></td>
								<td><a onClick="">编辑</a> || <a onClick="">删除</a></td>
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
<form action="note/add.do" class="form-horizontal" role="form"
	method="post">
	<div class="modal fade" role="dialog"
		aria-labelledby="gridSystemModalLabel" id="gridSystemModal"
		tabindex="-1" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="gridSystemModalLabel">公告信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label"> 标题
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputTitle"
								name="title">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label"> 内容
						</label>
						<div class="col-sm-10">
							<!-- 	<input type="texta" class="form-control" id="inputTitle"
									name="username"> -->

							<textarea rows="8" class="form-control" name="content"></textarea>
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
</script>
<%@ include file="/include.foot.jsp"%>
