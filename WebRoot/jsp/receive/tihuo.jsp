<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 待提货页面 -->
<div class="row">
	<form action="" class="form-horizontal" method="post">
		<div class="row" style="padding-top: 10px">
			<div class="col-lg-2">
				<button type="button" class="btn btn-primary" data-toggle="modal" onclick="linkPage(0)">添加</button>
				<button type="button" class="btn btn-primary" data-toggle="modal" onclick="linkPage(0)">导入</button>
			</div>
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
			<tbody id="table1">
<!-- 				<tr>
					<td>1</td>
					<td>东风</td>
					<td>螺丝101号</td>
					<td>2000</td>
					<td>大包装</td>
					<td>2016-4-21 21:08:13</td>
					<td><a onClick='linkPage(1)'>编辑</a> <a onClick='openMassageModal(1)'>||删除</a> <a onClick='linkPage(1)'>||提货</a></td>
				</tr> -->
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

<form action="user/save.do" class="form-horizontal" role="form" method="post" id="saveForm">
	<div class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel" id="gridSystemModal" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="gridSystemModalLabel">提货信息</h4>
				</div>
				<div class="modal-body" style="padding-bottom: 0">
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">零件名称</label>
						<div class="col-sm-10">
							<select class="form-control" id="fk_roleId2" name="fk_roleId">
							</select>
							<input type="hidden" class="form-control" id="userId" name="userId">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">零件数量</label>
						<div class="col-sm-10">
							<input type="text" maxlength="30" class="form-control" id="realName" name="realName">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">包装类型</label>
						<div class="col-sm-10">
							<select class="form-control" id="fk_roleId1" name="fk_roleId">
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label">提货时间</label>
						<div class="col-sm-10">
							<div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
								<input class="form-control" size="16" type="text" readonly id="dateFrom" name="dateFrom" placeholder="开始时间...">
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-remove"></span>
								</span>
							</div>
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
