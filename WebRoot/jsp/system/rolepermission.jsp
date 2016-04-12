<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<script type="text/javascript">
	function linkPage(id) {
		$.ajax({
			type : "post",
			async : true,
			url : "depart/linkPage.do",
			datatype : "json",//请求页面返回的数据类型     
			data : {
				"id" : id
			},
			async : false,
			/* error : function(request) {
				alert("编辑请求返回失败!");
			}, */
			success : function(data) {
				//对象先转字符串
				var resJSON = eval('(' + data + ')');
				console.log(resJSON.list);
				var parentId = 0;
				//后台返回数组用这个解析
				//var resJSON = eval(data);
				if (parseInt(id) > 0) {
					var tmp = resJSON.item;
					parentId = tmp.parentId;
					$("#departmentName").val(tmp.departmentName);
					$("#comments").val(tmp.comments);
				} else {
					$("#departmentName").val("");
					$("#comments").val("");
				}

				var list = resJSON.list;
				RemoveOption('parentId');
				var ddl = $("#parentId");

				ddl.append("<option value='0'>--所属上级--</option>");//方法1：添加默认节点 
				$.each(list, function(i, item) {
					var proid = item.id;
					var proname = item.departmentName;
					if (parentId == item.id) {
						AppendOption('parentId', proid, proname, true);//调用自定义方法
					} else {
						AppendOption('parentId', proid, proname, false);//调用自定义方法
					}

				});
			}
		});

		openModal();
	}

	function RemoveOption(selId) {//删除节点
		var obj = document.getElementById(selId);
		obj.options.length = 0;
	}

	function AppendOption(selId, value, text, selected) {
		var sel;
		if (selected) {
			sel = ' selected="selected"';
		}
		$("#" + selId).append(
				"<option value='" + value + "'" + sel + ">" + text
						+ "</option>");
	}
</script>

<script type="text/javascript">
	//	弹框多选下拉
	var zTree;
	var demoIframe;

	function addHoverDom(treeId, treeNode) {
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0)
			return;
		/* 	var addStr = "<span class='button remove' id='removeBtn_"
					+ treeNode.tId
					+ "' title='add node' onfocus='this.blur();'></span>";

			addStr += "<span class='button add' id='addBtn_" + treeNode.tId + "'></span>";
			addStr += "<span class='button edit' id='editBtn_" + treeNode.tId + "'></span>";
			sObj.after(addStr); */
		var btn = $("#addBtn_" + treeNode.tId);
		if (btn)
			btn.bind("click", function() {
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.addNodes(treeNode, {
					id : (1000 + newCount),
					pId : treeNode.id,
					name : "new node" + (newCount++)
				});
				return false;
			});
	};

	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_" + treeNode.tId).unbind().remove();
		$("#removeBtn_" + treeNode.tId).unbind().remove();
		$("#editBtn_" + treeNode.tId).unbind().remove();
	};

	var setting = {
		check : {
			enable : true
		},
		view : {
			addHoverDom : addHoverDom,
			removeHoverDom : removeHoverDom,
			dblClickExpand : false,
			showLine : true,
			selectedMulti : false
		},
		data : {
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "pId",
				rootPId : ""
			}
		},
		callback : {
			beforeClick : function(treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj("tree");
				if (treeNode.isParent) {
					zTree.expandNode(treeNode);
					return false;
				} else {
					demoIframe.attr("src", treeNode.file + ".html");
					return true;
				}
			}
		}
	};

	var zNodes = [{
		id : 4,
		pId : 0,
		name : "大数据量 演示",
		open : false
	}, {
		id : 401,
		pId : 4,
		name : "一次性加载大数据量",
		file : "bigdata/common"
	}, {
		id : 402,
		pId : 4,
		name : "分批异步加载大数据量",
		file : "bigdata/diy_async"
	}, {
		id : 403,
		pId : 4,
		name : "分批异步加载大数据量",
		file : "bigdata/page"
	},

	{
		id : 5,
		pId : 0,
		name : "组合功能 演示",
		open : false
	}, {
		id : 501,
		pId : 5,
		name : "冻结根节点",
		file : "super/oneroot"
	}, {
		id : 502,
		pId : 5,
		name : "单击展开/折叠节点",
		file : "super/oneclick"
	}, {
		id : 503,
		pId : 5,
		name : "保持展开单一路径",
		file : "super/singlepath"
	}, {
		id : 504,
		pId : 5,
		name : "添加 自定义控件",
		file : "super/diydom"
	}, {
		id : 505,
		pId : 5,
		name : "checkbox / radio 共存",
		file : "super/checkbox_radio"
	}, {
		id : 506,
		pId : 5,
		name : "左侧菜单",
		file : "super/left_menu"
	}, {
		id : 513,
		pId : 5,
		name : "OutLook 样式的左侧菜单",
		file : "super/left_menuForOutLook"
	}, {
		id : 507,
		pId : 5,
		name : "下拉菜单",
		file : "super/select_menu"
	}, {
		id : 509,
		pId : 5,
		name : "带 checkbox 的多选下拉菜单",
		file : "super/select_menu_checkbox"
	}, {
		id : 510,
		pId : 5,
		name : "带 radio 的单选下拉菜单",
		file : "super/select_menu_radio"
	}, {
		id : 508,
		pId : 5,
		name : "右键菜单 的 实现",
		file : "super/rightClickMenu"
	}, {
		id : 511,
		pId : 5,
		name : "与其他 DOM 拖拽互动",
		file : "super/dragWithOther"
	}, {
		id : 512,
		pId : 5,
		name : "异步加载模式下全部展开",
		file : "super/asyncForAll"
	},

	{
		id : 6,
		pId : 0,
		name : "其他扩展功能 演示",
		open : false
	}, {
		id : 601,
		pId : 6,
		name : "隐藏普通节点",
		file : "exhide/common"
	}, {
		id : 602,
		pId : 6,
		name : "配合 checkbox 的隐藏",
		file : "exhide/checkbox"
	}, {
		id : 603,
		pId : 6,
		name : "配合 radio 的隐藏",
		file : "exhide/radio"
	}];

	$(document).ready(function() {
		var t = $("#tree");
		t = $.fn.zTree.init(t, setting, zNodes);
		demoIframe = $("#testIframe");
		demoIframe.bind("load", loadReady);
		var zTree = $.fn.zTree.getZTreeObj("tree");
		zTree.selectNode(zTree.getNodeByParam("id", 101));

	});

	function loadReady() {
		var bodyH = demoIframe.contents().find("body").get(0).scrollHeight, htmlH = demoIframe
				.contents().find("html").get(0).scrollHeight, maxH = Math.max(
				bodyH, htmlH), minH = Math.min(bodyH, htmlH), h = demoIframe
				.height() >= maxH ? minH : maxH;
		if (h < 530)
			h = 530;
		demoIframe.height(h);
	}
</script>
<div class="container-fluid">
	<div class="row"><jsp:include page="../top.jsp" /></div>
	<div class="row" style="padding-left: 0">
		<div class="col-md-2" style="padding-left: 10"><jsp:include
				page="../left.jsp" /></div>
		<div class="col-md-10">

			<h2>角色管理</h2>
			<hr>

			<form action="" class="form-horizontal" role="form">
				<div class="row">

					<div class="col-lg-2">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							onclick="openModal()">添加角色</button>
					</div>


					<div class="col-lg-2">
						<!-- <div class="input-group">
								<input type="text" class="form-control" placeholder="标题...">
							</div> -->
						<!-- /input-group -->
					</div>
					<div class="col-lg-2">
						<!-- <div class="input-group">
								<span class="input-group-btn"> <input type="text"
									class="form-control" placeholder="内容...">
							</div> -->
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


			<div class="table-responsive ">
				<table class="table table-bordered">
					<thead>
						<tr class="success">
							<td class="text-center">序号</td>
							<td class="text-center">角色名称</td>
							<td class="text-center">备注信息</td>
							<td class="text-center">创建时间</td>
							<td class="text-center">创建人</td>
							<td class="text-center">操作</td>
						</tr>
					</thead>
					<tbody>
						<!-- 							<c:forEach items="${list}" var="item" varStatus="staturs"> -->
						<!-- 								<tr> -->
						<!-- 									<td>${staturs.index+1}</td> -->
						<!-- 									<td><c:out value="${item.departmentName}" /></td> -->
						<!-- 									<td><c:out value="${item.parentName}" /></td> -->
						<!-- 									<td><c:out value="${item.creatDate}" /></td> -->
						<!-- 									<td><c:out value="${item.owner}" /></td> -->
						<!-- 									<td><a onClick="linkPage('${item.id}')">编辑</a> | <a -->
						<!-- 										onClick="">删除</a> -->
						<!-- 									</td> -->
						<!-- 								</tr> -->
						<!-- 							</c:forEach> -->
					</tbody>
				</table>
			</div>
			<ul class="pagination">
				<li><a href="#">上一页</a>
				</li>
				<li><a href="#">1</a>
				</li>
				<li><a href="#">2</a>
				</li>
				<li><a href="#">3</a>
				</li>
				<li><a href="#">4</a>
				</li>
				<li><a href="#">5</a>
				</li>
				<li><a href="#">下一页</a>
				</li>
			</ul>
		</div>
	</div>
</div>
<form action="depart/add.do" class="form-horizontal" role="form"
	method="post">
	<div class="modal fade lg" role="dialog"
		aria-labelledby="gridSystemModalLabel" id="gridSystemModal"
		tabindex="-1" aria-hidden="true">
		<div class="modal-dialog lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="gridSystemModalLabel">角色信息</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="inputTitle" class="col-sm-1 control-label">
									名称 </label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="departmentName"
										name="departmentName">
								</div>
							</div>
							<div class="form-group">
								<label for="inputTitle" class="col-sm-1 control-label">
									备注信息 </label>
								<div class="col-sm-10">
									<!-- 	<input type="texta" class="form-control" id="inputTitle"
									name="username"> -->

									<textarea rows="8" class="form-control" id="comments"
										name="comments"></textarea>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<ul id="tree" class="ztree"></ul>
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