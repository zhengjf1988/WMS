<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 验货页面 -->
<form action="" class="form-horizontal" method="post">
	<div class="row" style="padding-top: 10px">
		<div class="col-lg-2"></div>
		<div class="col-lg-4">
			<div class="input-group">
				<input type="text" maxlength="30" style="width: 400px;" class="form-control" placeholder="请输入关键字..." name="seachUserName" value="${item.username}">
			</div>
			<!-- /input-group -->
		</div>
		<div class="col-lg-2">
			<div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
				<input class="form-control" size="16" type="text" value="${item.owner }" readonly id="dateTo" name="dateTo" placeholder="开始时间...">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-remove"></span>
				</span>
			</div>
		</div>
		<div class="col-lg-2">
			<div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
				<input class="form-control" size="16" type="text" value="${item.owner }" readonly id="dateTo" name="dateTo" placeholder="结束时间...">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-remove"></span>
				</span>
			</div>
		</div>
		<div class="col-lg-2">
			<div class="input-group">
				<input type="submit" value="查询" class="btn">
			</div>
		</div>
	</div>
</form>
<div class="table-responsive" style="overflow:scroll;height: 300px;">
	<table class="table table-bordered table-hover">
		<thead>
			<tr class="success">
				<td class="text-center">序号</td>
				<td class="text-center">客户名称</td>
				<td class="text-center">零件名称</td>
				<td class="text-center">零件数量</td>
				<td class="text-center">包装类型</td>
				<td class="text-center">提货时间</td>
				<td class="text-center">操作</td>
			</tr>
		</thead>
		<tbody id="table2">
		</tbody>
	</table>
</div>
<ul class="pagination">
	<li>
		<a href="#">上一页</a>
	</li>
	<li>
		<a href="#">1</a>
	</li>
	<li>
		<a href="#">2</a>
	</li>
	<li>
		<a href="#">3</a>
	</li>
	<li>
		<a href="#">4</a>
	</li>
	<li>
		<a href="#">5</a>
	</li>
	<li>
		<a href="#">下一页</a>
	</li>
</ul>

<form action="receive/save.do" class="form-horizontal" role="form" method="post" id="saveForm">
	<div class="modal fade" role="dialog" aria-labelledby="yanhuoModalLabel" id="yanhuoModal" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="yanhuoModalLabel">验货信息</h4>
				</div>
				<div class="modal-body" style="padding-bottom: 0">
					<input type="hidden" id="recId">
					<div class="form-group" id="txmDiv"></div>
					<div class="form-group">
						<button type="button" class="btn btn-default" onclick="addTxmDiv()">
							<span class="glyphicon glyphicon-plus" aria-hidden="true" />
						</button>
					</div>
				</div>
				<div class="modal-footer">
					<div class="col-lg-6">
						<button type="button" class="btn btn-info ">打印条形码</button>
						<button type="button" class="btn btn-info" onclick="savexm()">保存条形码</button>
					</div>
					<div class="col-lg-6">
						<button type="button" class="btn btn-default " data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary">验货</button>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</form>
<script type="text/javascript">
	function openYHModal() {
		$('#yanhuoModal').modal({
			backdrop : 'static'
		});
	}
</script>