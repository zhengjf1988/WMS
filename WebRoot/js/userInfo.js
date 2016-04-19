$(function() {
	// 在打开页面时，初始化查询下拉框
	$.ajax({
		type : "post",
		async : true,
		url : "user/linkPage.do",
		datatype : "json",// 请求页面返回的数据类型
		data : {
			"id" : 0
		},
		async : false,
		success : function(data) {
			// 对象先转字符串
			var resJSON = eval('(' + data + ')');

			var depList = resJSON.depList;

			var selectId1 = "seachDeptart";
			RemoveOption(selectId1);
			var depart = $("#seachDeptart");

			depart.append("<option value='0'>--请选择部门--</option>");// 方法1：添加默认节点
			$.each(depList, function(i, item) {
				var proid = item.id;
				var proname = item.departmentName;
				if (fk_departmentId == item.id) {
					AppendOption(selectId1, proid, proname, true);// 调用自定义方法
				} else {
					AppendOption(selectId1, proid, proname, false);// 调用自定义方法
				}
			});

			var roleList = resJSON.roleList;

			var selectId = "seachRoleName";
			RemoveOption(selectId);

			var role = $("#seachRoleName");

			role.append("<option value='0'>--请选择角色--</option>");// 方法1：添加默认节点
			$.each(roleList, function(i, item) {
				var proid = item.id;
				var proname = item.roleName;
				if (fk_roleId == item.id) {
					AppendOption(selectId, proid, proname, true);// 调用自定义方法
				} else {
					AppendOption(selectId, proid, proname, false);// 调用自定义方法
				}

			});
		}
	});
});

function linkPage(id) {// 跳转页面
	$("#userId").val(id);
	$("#msgDiv").hide();
	$.ajax({
		type : "post",
		async : true,
		url : "user/linkPage.do",
		datatype : "json",// 请求页面返回的数据类型
		data : {
			"id" : id
		},
		async : false,
		/*
		 * error : function(request) { alert("编辑请求返回失败!"); },
		 */
		success : function(data) {
			// 对象先转字符串
			var resJSON = eval('(' + data + ')');
			var fk_roleId = 0;
			var fk_departmentId = 0;
			// 后台返回数组用这个解析
			// var resJSON = eval(data);
			if (parseInt(id) > 0) {
				$("#username").attr("readonly", true);
				var tmp = resJSON.item;
				fk_roleId = tmp.fk_roleId;
				fk_departmentId = tmp.fk_departmentId;

				$("#username").val(tmp.username);
				$("#realName").val(tmp.realName);
				$("#comments").val(tmp.comments);
				$("#departmentName").val(tmp.departmentName);
			} else {
				$("#username").attr("readonly", false);
				$("#username").val("");
				$("#realName").val("");
				$("#comments").val("");
				$("#departmentName").val("");
			}

			var roleList = resJSON.roleList;

			var selectId = "fk_roleId";
			RemoveOption(selectId);

			var role = $("#fk_roleId");

			role.append("<option value='0'>--请选择--</option>");// 方法1：添加默认节点
			$.each(roleList, function(i, item) {
				var proid = item.id;
				var proname = item.roleName;
				if (fk_roleId == item.id) {
					AppendOption(selectId, proid, proname, true);// 调用自定义方法
				} else {
					AppendOption(selectId, proid, proname, false);// 调用自定义方法
				}

			});

			var depList = resJSON.depList;

			var selectId1 = "fk_departmentId";
			RemoveOption(selectId1);
			var depart = $("#fk_departmentId");

			depart.append("<option value='0'>--请选择--</option>");// 方法1：添加默认节点
			$.each(depList, function(i, item) {
				var proid = item.id;
				var proname = item.departmentName;
				if (fk_departmentId == item.id) {
					AppendOption(selectId1, proid, proname, true);// 调用自定义方法
				} else {
					AppendOption(selectId1, proid, proname, false);// 调用自定义方法
				}
			});
		}
	});
	openModal();
}

var flag = false;
function saveInfo() {
	var userId = $("#userId").val();
	var username = $("#username").val();
	if (username == "") {
		$("#msgDiv").show();
		$("#msg").text("用户名不能为空！");
		return;
	} else {
		$("#msgDiv").hide();
		$("#msg").text("");
	}

	if (userId == 0) {// 添加的时候验证用户名
		var isExist = false;
		$.ajax({
			type : "post",
			async : true,
			url : "user/checkUserName.do",
			datatype : "json", // 请求页面返回的数据类型
			data : {
				"username" : username
			},
			async : false,
			success : function(data) {
				// 对象先转字符串
				var resJSON = eval('(' + data + ')');
				if (resJSON.result) {
					isExist = true;
				}
			}
		});

		if (isExist) {
			$("#msgDiv").show();
			$("#msg").text("用户名已存在！");
			return;
		} else {
			$("#msgDiv").hide();
			$("#msg").text("");
		}
	}
	var realName = $("#realName").val();
	if (realName == "") {
		$("#msgDiv").show();
		$("#msg").text("真实姓名不能为空！");
		return;
	} else {
		$("#msgDiv").hide();
		$("#msg").text("");
	}

	if (userId == 0) {// 添加的时候验证用户名
		var psw = $("#psw").val();

		if (psw == "") {
			$("#msgDiv").show();
			$("#msg").text("密码不能为空！");
			return;
		} else if (psw.length < 6) {
			$("#msgDiv").show();
			$("#msg").text("请输入6-12位密码！");
			return;
		} else {
			$("#msgDiv").hide();
			$("#msg").text("");
		}
		var surePsw = $("#surePsw").val();
		if (surePsw == "") {
			$("#msgDiv").show();
			$("#msg").text("请输入确认密码！");
			return;
		} else if (surePsw != psw) {
			$("#msgDiv").show();
			$("#msg").text("两次输入的密码不一致！");
			return;
		} else {
			$("#msgDiv").hide();
			$("#msg").text("");
		}
	}
	var fk_roleId = $("#fk_roleId").val();
	if (fk_roleId == null || fk_roleId == 0) {
		$("#msgDiv").show();
		$("#msg").text("请选择用户角色！");
		return;
	} else {
		$("#msgDiv").hide();
		$("#msg").text("");
	}
	var fk_departmentId = $("#fk_departmentId").val();
	if (fk_departmentId == null || fk_departmentId == 0) {
		$("#msgDiv").show();
		$("#msg").text("请选择用户所属部门！");
		return;
	} else {
		$("#msgDiv").hide();
		$("#msg").text("");
	}

	$("#saveForm").submit();
}

function checkUserName() {
	var username = $("#username").val();
	var isExist = false;
	$.ajax({
		type : "post",
		async : true,
		url : "user/checkUserName.do",
		datatype : "json", // 请求页面返回的数据类型
		data : {
			"username" : username
		},
		async : false,
		success : function(data) {
			// 对象先转字符串
			var resJSON = eval('(' + data + ')');
			if (resJSON.result) {
				isExist = true;
			}
		}
	});

	if (isExist) {
		$("#msgDiv").show();
		$("#msg").text("用户名已存在！");
		return;
	} else {
		$("#msgDiv").hide();
		$("#msg").text("");
	}
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
