<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
	//菜单控制
	$(function() {
		var tmpId = sessionStorage.getItem("key");
		$("#" + tmpId).collapse('show');

		$(".panel-title").on('click', function() {
			var oldId = sessionStorage.getItem("old");
			$("#" + oldId).collapse('hide');

			var id = $(this).attr("href");
			id = id.substring(1, id.length);
			sessionStorage.setItem("key", id);
			sessionStorage.setItem("old", sessionStorage.getItem("key"));
		});
	});
</script>
<div class="col-md-12" style="padding-left: 0;width: 100%">
	<div class="panel-group" id="panel-73792">
	<div class="panel panel-default">
			<div class="panel-heading">
				<a class="panel-title" data-toggle="collapse" data-parent="#panel-73792" href="#panel-element-620068">生产管理</a>
			</div>
			<div id="panel-element-620068" class="panel-collapse collapse">
				<div class="panel-body">
					<li><a href="Khscplan/Khscplan.view">客户生产计划</a>
					</li>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-73792" href="#panel-element-595369"> 任务管理</a>
			</div>
			<div id="panel-element-595369" class="panel-collapse collapse">
				<div class="panel-body">任务111111111111111111</div>
				<div class="panel-body">任务222222222222</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<a class="panel-title" data-toggle="collapse" data-parent="#panel-73792" href="#panel-element-620094">入库管理</a>
			</div>
			<div id="panel-element-620094" class="panel-collapse collapse">
				<div class="panel-body">
					<li><a href="Sctldetail/Sctldetail.view">生产退料</a>
					</li>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<a class="panel-title" data-toggle="collapse" data-parent="#panel-73792" href="#panel-element-620035">出库管理</a>
			</div>
			<div id="panel-element-620035" class="panel-collapse collapse">
				<div class="panel-body">
					<li><a href="Kwxxgl.view">退货管理</a>
					</li>
				</div>
				<div class="panel-body">
					<li><a href="Scflgdxx/Scflgdxx.view">生产发料</a>
					</li>
				</div>
				<div class="panel-body"><li><a href="">成品出库</a></li></div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<a class="panel-title" data-toggle="collapse" data-parent="#panel-73792" href="#panel-element-620022">信息管理</a>
			</div>
			<div id="panel-element-620022" class="panel-collapse collapse">
				<div class="panel-body">
					<li><a href="Kwxxgl.view">库位信息管理</a>
					</li>
				</div>
				<div class="panel-body">
					<li><a href="consumer/list.do">客户信息管理</a>
					</li>
				</div>
				<div class="panel-body"><li><a href="Ljxxgl.view">零件信息管理</a></li></div>
				<div class="panel-body"><li><a href="Ygxxgl.view">员工信息管理</a></li></div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<a class="panel-title" data-toggle="collapse" data-parent="#panel-73792" href="#panel-element-620011">基础管理</a>
			</div>
			<div id="panel-element-620011" class="panel-collapse collapse">
				<div class="panel-body">
					<li><a href="Ljlxgl.view">零件类型管理</a>
					</li>
				</div>
				<div class="panel-body">
					<li><a href="Ljdj/Ljdjgl.view">零件等级管理</a>
					</li>
				</div>
				<div class="panel-body">
					<li><a href="Kwlx/Kwlxgl.view">库位类型管理</a>
					</li>
				</div>
				<div class="panel-body">
					<li><a href="save/list.do">存储类型管理</a>
					</li>
				</div>
				<div class="panel-body">
					<li><a href="Ccqxgl.view">存储期限管理</a>
					</li>
				</div>
				<div class="panel-body">
					<li><a href="pack/list.do">包装信息管理</a>
					</li>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<a class="panel-title" data-toggle="collapse" data-parent="#panel-73792" href="#panel-element-120094">系统管理</a>
			</div>
			<div id="panel-element-120094" class="panel-collapse collapse">
				<div class="panel-body">
					<li><a href="note/list.do">公告管理</a>
					</li>
				</div>
				<div class="panel-body">
					<li><a href="depart/list.do">部门管理</a>
					</li>
				</div>
				<div class="panel-body">
					<li><a href="role/list.do">角色管理</a>
					</li>
				</div>
				<div class="panel-body">
					<li><a href="user/list.do">用户管理</a>
					</li>
				</div>
			</div>
		</div>
	</div>
</div>
