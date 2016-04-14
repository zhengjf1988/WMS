var flag = false;
function saveInfo() {
	var username = $("#username").val();
	if (username == "") {
		$("#msgDiv").show();
		$("#msg").text("用户名不能为空！");
		return;
	} else {
		$("#msgDiv").hide();
		$("#msg").text("");
	}
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

	var realName = $("#realName").val();
	if (realName == "") {
		$("#msgDiv").show();
		$("#msg").text("真实姓名不能为空！");
		return;
	} else {
		$("#msgDiv").hide();
		$("#msg").text("");
	}
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