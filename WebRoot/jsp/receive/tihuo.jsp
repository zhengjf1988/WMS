<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 待提货页面 -->
<form action="" class="form-horizontal" method="post">
	<div class="row" style="padding-top: 10px">
		<div class="col-lg-2">
			<button type="button" class="btn btn-primary" data-toggle="modal" onclick="linkPage(0,1)">添加</button>
			<button type="button" class="btn btn-primary" data-toggle="modal" onclick="linkPage(0)">导入</button>
		</div>
		<div class="col-lg-4">
			<div class="input-group">
				<input type="text" maxlength="30" style="width: 380px;" class="form-control" placeholder="请输入关键字..." id="seachKeyWord1" value="${item.username}">
			</div>
			<!-- /input-group -->
		</div>
		<div class="col-lg-2">
			<div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
				<input class="form-control" size="16" type="text" readonly id="seachStartDate1" placeholder="开始时间...">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-remove"></span>
				</span>
			</div>
		</div>
		<div class="col-lg-2">
			<div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
				<input class="form-control" size="16" type="text" readonly id="seachEndDate1" placeholder="结束时间...">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-remove"></span>
				</span>
			</div>
		</div>
		<div class="col-lg-2">
			<div class="input-group">
				<input type="button" value="查询" class="btn" onclick="loadReceiveInfo(1)">
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
		<tbody id="table1">
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

<form action="receive/tihuo.do" method="post" id="thId">
	<input name="recId" id="th_PKId" type="hidden">
	<input name="thCar" id="th_Car" type="hidden">
	<input name="thMan" id="th_Man" type="hidden">
</form>

<!-- message -->
<form action="receive/delete.do" method="post">
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
