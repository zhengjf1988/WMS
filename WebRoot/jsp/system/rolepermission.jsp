<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href=" <%=basePath%>">
<meta charset="UTF-8">
<title>WMS仓库管理系统</title>
<meta name="description" content="">
<meta name="author" content="dx&will">
<!-- 让360双核浏览器用webkit内核渲染页面 !!! 注意，这行最好放在前面，防止浏览器开始解析的时候采用其它内置的渲染方案
	================================================== -->
<meta name="renderer" content="webkit">
<!-- 让IE浏览器用最高级内核渲染页面 还有用 Chrome 框架的页面用webkit 内核
	================================================== -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!-- IOS6全屏 Chrome高版本全屏
	================================================== -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="mobile-web-app-capable" content="yes">
<!-- Mobile Specific Metas
	================================================== -->
<!-- !!!注意 minimal-ui 是IOS7.1的新属性，最小化浏览器UI，但是在iOS8.1突然被取消 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- 指定苹果设备添加到主屏的标题 -->
<meta name="apple-mobile-web-app-title" content="title2">
<!-- Favicons
	================================================== -->

<link href="<%=basePath%>bootstrap/css/bootstrap.min.css"
	rel="stylesheet" media="all">
<link href="<%=basePath%>bootstrap/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" media="all">

<script type="text/javascript"
	src="<%=basePath%>jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript"
	src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>bootstrap/js/bootstrap-datetimepicker.js"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="<%=basePath%>bootstrap/js/bootstrap-datetimepicker.zh-CN.js"
	charset="UTF-8"></script>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		var addStr = "<span class='button remove' id='removeBtn_"
				+ treeNode.tId
				+ "' title='add node' onfocus='this.blur();'></span>";

		addStr += "<span class='button add' id='addBtn_" + treeNode.tId + "'></span>";
		addStr += "<span class='button edit' id='editBtn_" + treeNode.tId + "'></span>";
		sObj.after(addStr);
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
		id : 1,
		pId : 0,
		name : "[core] 基本功能 演示",
		open : true
	}, {
		id : 101,
		pId : 1,
		name : "最简单的树 --  标准 JSON 数据",
		file : "core/standardData"
	}, {
		id : 102,
		pId : 1,
		name : "最简单的树 --  简单 JSON 数据",
		file : "core/simpleData"
	}, {
		id : 103,
		pId : 1,
		name : "不显示 连接线",
		file : "core/noline"
	}, {
		id : 104,
		pId : 1,
		name : "不显示 节点 图标",
		file : "core/noicon"
	}, {
		id : 105,
		pId : 1,
		name : "自定义图标 --  icon 属性",
		file : "core/custom_icon"
	}, {
		id : 106,
		pId : 1,
		name : "自定义图标 --  iconSkin 属性",
		file : "core/custom_iconSkin"
	}, {
		id : 107,
		pId : 1,
		name : "自定义字体",
		file : "core/custom_font"
	}, {
		id : 115,
		pId : 1,
		name : "超链接演示",
		file : "core/url"
	}, {
		id : 108,
		pId : 1,
		name : "异步加载 节点数据",
		file : "core/async"
	}, {
		id : 109,
		pId : 1,
		name : "用 zTree 方法 异步加载 节点数据",
		file : "core/async_fun"
	}, {
		id : 110,
		pId : 1,
		name : "用 zTree 方法 更新 节点数据",
		file : "core/update_fun"
	}, {
		id : 111,
		pId : 1,
		name : "单击 节点 控制",
		file : "core/click"
	}, {
		id : 112,
		pId : 1,
		name : "展开 / 折叠 父节点 控制",
		file : "core/expand"
	}, {
		id : 113,
		pId : 1,
		name : "根据 参数 查找 节点",
		file : "core/searchNodes"
	}, {
		id : 114,
		pId : 1,
		name : "其他 鼠标 事件监听",
		file : "core/otherMouse"
	},

	{
		id : 2,
		pId : 0,
		name : "[excheck] 复/单选框功能 演示",
		open : false
	}, {
		id : 201,
		pId : 2,
		name : "Checkbox 勾选操作",
		file : "excheck/checkbox"
	}, {
		id : 206,
		pId : 2,
		name : "Checkbox nocheck 演示",
		file : "excheck/checkbox_nocheck"
	}, {
		id : 207,
		pId : 2,
		name : "Checkbox chkDisabled 演示",
		file : "excheck/checkbox_chkDisabled"
	}, {
		id : 208,
		pId : 2,
		name : "Checkbox halfCheck 演示",
		file : "excheck/checkbox_halfCheck"
	}, {
		id : 202,
		pId : 2,
		name : "Checkbox 勾选统计",
		file : "excheck/checkbox_count"
	}, {
		id : 203,
		pId : 2,
		name : "用 zTree 方法 勾选 Checkbox",
		file : "excheck/checkbox_fun"
	}, {
		id : 204,
		pId : 2,
		name : "Radio 勾选操作",
		file : "excheck/radio"
	}, {
		id : 209,
		pId : 2,
		name : "Radio nocheck 演示",
		file : "excheck/radio_nocheck"
	}, {
		id : 210,
		pId : 2,
		name : "Radio chkDisabled 演示",
		file : "excheck/radio_chkDisabled"
	}, {
		id : 211,
		pId : 2,
		name : "Radio halfCheck 演示",
		file : "excheck/radio_halfCheck"
	}, {
		id : 205,
		pId : 2,
		name : "用 zTree 方法 勾选 Radio",
		file : "excheck/radio_fun"
	},

	{
		id : 3,
		pId : 0,
		name : "[exedit] 编辑功能 演示",
		open : false
	}, {
		id : 301,
		pId : 3,
		name : "拖拽 节点 基本控制",
		file : "exedit/drag"
	}, {
		id : 302,
		pId : 3,
		name : "拖拽 节点 高级控制",
		file : "exedit/drag_super"
	}, {
		id : 303,
		pId : 3,
		name : "用 zTree 方法 移动 / 复制 节点",
		file : "exedit/drag_fun"
	}, {
		id : 304,
		pId : 3,
		name : "基本 增 / 删 / 改 节点",
		file : "exedit/edit"
	}, {
		id : 305,
		pId : 3,
		name : "高级 增 / 删 / 改 节点",
		file : "exedit/edit_super"
	}, {
		id : 306,
		pId : 3,
		name : "用 zTree 方法 增 / 删 / 改 节点",
		file : "exedit/edit_fun"
	}, {
		id : 307,
		pId : 3,
		name : "异步加载 & 编辑功能 共存",
		file : "exedit/async_edit"
	}, {
		id : 308,
		pId : 3,
		name : "多棵树之间 的 数据交互",
		file : "exedit/multiTree"
	},

	{
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
</head>
<body>
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
								<td class="text-center">部门名称</td>
								<td class="text-center">所属上级</td>
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
					<li><a href="#">上一页</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">下一页</a></li>
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
</body>
</html>