<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<script type="text/javascript" src="js/receive.js"></script>
<!-- 收货管理页面 -->
<div class="container-fluid">
	<div class="row">
		<%@ include file="../top.jsp"%>
	</div>
	<div class="row" style="padding-left: 0">
		<div class="col-md-2" style="padding-left: 10">
			<%@ include file="../left.jsp"%>
		</div>
		<div class="col-md-10">
			<h2>收货管理</h2>
			<hr>
			<div class="row">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active">
						<a href="#tihuo" onclick="loadReceiveInfo(1)" data-toggle="tab">提货</a>
					</li>
					<li>
						<a href="#yanhuo" onclick="loadReceiveInfo(2)" data-toggle="tab">验货</a>
					</li>
					<li>
						<a href="#fenku" data-toggle="tab">分库</a>
					</li>
					<li>
						<a href="#rkqr" data-toggle="tab">入库确认</a>
					</li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="tihuo">
						<%@ include file="./tihuo.jsp"%>
					</div>
					<div class="tab-pane fade" id="yanhuo">
						<%@ include file="./yanhuo.jsp"%>
					</div>
					<div class="tab-pane fade" id="fenku">
						<%@ include file="./fenku.jsp"%>
					</div>
					<div class="tab-pane fade" id="rkqr">
						<%@ include file="./rkqr.jsp"%>
					</div>
					<form action="receive/save.do" class="form-horizontal" role="form" method="post" id="saveForm">
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
										<div style="display: none;" id="thDiv1">
											<div class="form-group">
												<label for="inputTitle" class="col-sm-2 control-label">零件名称</label>
												<div class="col-sm-10">
													<select class="form-control" id="ljName" name="fk_ljID">
													</select>
													<input type="hidden" class="form-control" id="recId" name="recId">
												</div>
											</div>
											<div class="form-group">
												<label for="inputTitle" class="col-sm-2 control-label">零件数量</label>
												<div class="col-sm-10">
													<input type="text" maxlength="30" class="form-control" id="count" name="count">
												</div>
											</div>
											<div class="form-group">
												<label for="inputTitle" class="col-sm-2 control-label">包装类型</label>
												<div class="col-sm-10">
													<select class="form-control" id="bzType" name="fk_bzID">
													</select>
												</div>
											</div>
											<div class="form-group">
												<label for="inputTitle" class="col-sm-2 control-label">提货时间</label>
												<div class="col-sm-10">
													<div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
														<input class="form-control" size="16" type="text" readonly id="thDate" name="thDate" placeholder="提货时间...">
														<span class="input-group-addon">
															<span class="glyphicon glyphicon-remove"></span>
														</span>
													</div>
												</div>
											</div>
										</div>

										<div style="display: none;" id="thDiv2">
											<div class="form-group">
												<label for="inputTitle" class="col-sm-2 control-label">提货人</label>
												<div class="col-sm-10">
													<input type="text" maxlength="30" class="form-control" id="thMan" placeholder="多个请用;隔开!">
												</div>
											</div>
											<div class="form-group">
												<label for="inputTitle" class="col-sm-2 control-label">提货车辆</label>
												<div class="col-sm-10">
													<input type="text" maxlength="30" class="form-control" id="thCar" placeholder="多个请用;隔开!">
												</div>
											</div>
										</div>
										<div class="alert alert-danger sm" id="msgDiv" style="display: none;padding-bottom: 0;padding-top: 0;padding-left: 40px;">
											<label id="msg"></label>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
										<button type="button" class="btn btn-primary" onclick="saveInfo(1)" id="sav1">保存</button>
										<button type="button" class="btn btn-primary" onclick="tihuo()" id="sav2" style="display: none;">保存</button>
									</div>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal-dialog -->
						</div>
						<!-- /.modal -->
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- message -->
<%@ include file="/include.foot.jsp"%>