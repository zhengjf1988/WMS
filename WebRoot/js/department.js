$(function() {
	initDepartNameSeach();

});

// 初始化查询的上级部门下拉框
function initDepartNameSeach() {
	$.ajax({
		type : "post",
		async : true,
		url : "depart/linkPage.do",
		datatype : "json",// 请求页面返回的数据类型
		data : {
			"id" : 0
		},
		async : false,
		success : function(data) {
			// 对象先转字符串
			var resJSON = eval('(' + data + ')');
			var parentId = 0;

			var list = resJSON.list;
			RemoveOption('seachParentId');
			var ddl = $("#seachParentId");

			ddl.append("<option value='0'>--请选择上级部门--</option>");// 方法1：添加默认节点
			$.each(list, function(i, item) {
				var proid = item.id;
				var proname = item.departmentName;
				if (parentId == item.id) {
					AppendOption('seachParentId', proid, proname, true);// 调用自定义方法
				} else {
					AppendOption('seachParentId', proid, proname, false);// 调用自定义方法
				}

			});
		}
	});
}

// 添加或者修改的时候进行跳转
function linkPage(id) {
	$("#departId").val(id);
	$.ajax({
		type : "post",
		async : true,
		url : "depart/linkPage.do",
		datatype : "json",// 请求页面返回的数据类型
		data : {
			"id" : id
		},
		async : false,
		success : function(data) {
			// 对象先转字符串
			var resJSON = eval('(' + data + ')');
			console.log(resJSON.list);
			var parentId = 0;
			// 后台返回数组用这个解析
			// var resJSON = eval(data);
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

			ddl.append("<option value='0'>--所属上级--</option>");// 方法1：添加默认节点
			$.each(list, function(i, item) {
				var proid = item.id;
				var proname = item.departmentName;
				if (parentId == item.id) {
					AppendOption('parentId', proid, proname, true);// 调用自定义方法
				} else {
					AppendOption('parentId', proid, proname, false);// 调用自定义方法
				}

			});
		}
	});

	openModal();
}

function RemoveOption(selId) {// 删除节点
	var obj = document.getElementById(selId);
	obj.options.length = 0;
}

function AppendOption(selId, value, text, selected) {
	var sel;
	if (selected) {
		sel = ' selected="selected"';
	}
	$("#" + selId).append(
			"<option value='" + value + "'" + sel + ">" + text + "</option>");
}