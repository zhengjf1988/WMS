<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<script type="text/javascript" src="js/selfPlan.js"></script>
<!-- 内部生产计划管理页面 -->
<div class="container-fluid">
	<div class="row">
		<%@ include file="../top.jsp"%>
	</div>
	<div class="row" style="padding-left: 0">
		<div class="col-md-2" style="padding-left: 10">
			<%@ include file="../left.jsp"%>
		</div>
		<div class="col-md-10">
			<h2>内部生产计划</h2>
			<hr>
			<div class="row">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active">
						<a href="#tihuo" onclick="" data-toggle="tab">生产分配</a>
					</li>
					<li>
						<a href="#yanhuo" onclick="" data-toggle="tab">工单领取</a>
					</li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="tihuo">
						<%@ include file="./scfp.jsp"%>
					</div>
					<div class="tab-pane fade" id="yanhuo">
						<%@ include file="./gdlq.jsp"%>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<form action="self/save.do" method="post" class="form-horizontal" role="form" id="selfSaveForm">
	<div class="modal fade" role="dialog" aria-labelledby="selfPlanModalLabel" id="selfPlanModal" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog" role="document" style="width: 700px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="selfPlanModalLabel">内部生产计划</h3>
				</div>
				<div class="modal-body" style="padding-bottom: 0px">
					<input type="hidden" id="pk_id" name="id">
					<div class="form-group">
						<label for="inputTitle" class="col-md-2 control-label">客户名称</label>
						<div class="col-md-4">
							<select class="form-control" id="fk_khId" name="fk_khId" onchange="setLjXX()">
							</select>
						</div>
						<label for="inputTitle" class="col-md-2 control-label">零件数量</label>
						<div class="col-md-4">
							<input type="text" maxlength="30" class="form-control" id="count" name="count">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-md-2 control-label">零件名称</label>
						<div class="col-md-4">
							<select class="form-control" id="fk_ljId" name="fk_ljId">
							</select>
						</div>
						<label for="inputTitle" class="col-md-2 control-label">需求时间</label>
						<div class="col-md-4">
							<div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
								<input class="form-control" size="16" type="text" readonly placeholder="需求时间..." name="xqDate" id="xqDate">
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-remove"></span>
								</span>
							</div>
						</div>
					</div>

					<div class="form-group" id="tbDiv1" style="display: none">
						<div class="table-responsive" style="overflow:scroll;">
							<div class="form-group">
								<label class="col-md-6" id="gd_Id"></label>
								<div class=" class="col-md-6"">
									<button type="button" class="btn btn-default" onclick="addGDDiv()">
										<span class="glyphicon glyphicon-plus" aria-hidden="true" />
									</button>
								</div>
							</div>
							<table class="table table-bordered table-hover">
								<thead>
									<tr class="success">
										<td class="text-center col-md-4">生产班组</td>
										<td class="text-center col-md-4">生产数量</td>
										<td class="text-center col-md-4">生产日期</td>
									</tr>
								</thead>
								<tbody id="table_gd">
									
								</tbody>
							</table>
						</div>

					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" onclick="saveInfo()">确定</button>
				</div>
			</div>
		</div>
	</div>
</form>
<%@ include file="/include.foot.jsp"%>