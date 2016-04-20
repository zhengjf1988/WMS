<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<script>
	$(function() {
		$("#li1").css("active");
	});
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
			<h2>收货管理</h2>
			<hr>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="tabbable" id="tabs-288562">
						<ul class="nav nav-tabs">
							<li id="li1"><a href="#panel-854194" data-toggle="tab">待提货</a></li>
							<li><a href="#panel-854195" data-toggle="tab">待验货</a></li>
							<li><a href="#panel-854196" data-toggle="tab">待入库</a></li>
							<li><a href="#panel-854197" data-toggle="tab">历史记录</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane" id="panel-854194">
								<p>I'm in Section 1.</p>
							</div>
							<div class="tab-pane active" id="panel-854195">
								<p>Howdy, I'm in Section 2.</p>
							</div>
							<div class="tab-pane active" id="panel-854196">
								<p>Howdy, I'm in Section 3.</p>
							</div>
							<div class="tab-pane active" id="panel-854197">
								<p>Howdy, I'm in Section 4.</p>
							</div>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>
</div>
<!-- message -->
<%@ include file="/include.foot.jsp"%>