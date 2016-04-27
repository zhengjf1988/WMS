<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 入库页面 -->
<div class="row">
	<form action="" class="form-horizontal" method="post">
		<div class="row" style="padding-top: 10px">
			<div class="col-lg-2"></div>
			<div class="col-lg-4">
			<div class="input-group">
				<input type="text" maxlength="30" style="width: 380px;" class="form-control" placeholder="请输入关键字..." id="seachKeyWord3" value="${item.username}">
			</div>
			<!-- /input-group -->
		</div>
		<div class="col-lg-2">
			<div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
				<input class="form-control" size="16" type="text" readonly id="seachStartDate3" placeholder="开始时间...">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-remove"></span>
				</span>
			</div>
		</div>
		<div class="col-lg-2">
			<div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
				<input class="form-control" size="16" type="text" readonly id="seachEndDate3" placeholder="结束时间...">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-remove"></span>
				</span>
			</div>
		</div>
			<div class="col-lg-2">
				<div class="input-group">
					<input type="button" value="查询" class="btn" onclick="loadReceiveInfo(3)">
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
					<td class="text-center">提货时间</td>
					<td class="text-center">零件数量</td>
					<td class="text-center">实际数量</td>
					<td class="text-center">操作</td>
				</tr>
			</thead>
			<tbody id="table3">
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
</div>
<form method="post" class="form-horizontal" role="form">
	<div class="modal fade" role="dialog" aria-labelledby="fenkuModalLabel" id="fenkuModal" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog" role="document" style="width: 700px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="fenkuModalLabel">分库信息</h4>
				</div>
				<div class="modal-body" style="padding-bottom: 0" id="fkDiv"></div>
				<div class="modal-footer">
					<input type="hidden" id='fenku_recId'>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" onclick="fenkuSave()">确定</button>
				</div>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript">
	function openFKModal() {
		$('#fenkuModal').modal({
			backdrop : 'static'
		});
	}
</script>