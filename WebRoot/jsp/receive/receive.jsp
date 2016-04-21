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
						<a href="#tihuo" data-toggle="tab">提货</a>
					</li>
					<li>
						<a href="#yanhuo" data-toggle="tab">验货</a>
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
				</div>
			</div>
		</div>
	</div>
</div>
<!-- message -->
<%@ include file="/include.foot.jsp"%>