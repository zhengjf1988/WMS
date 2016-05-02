//打开页面的时候查询
$(function() {
	loadSelfPlan();
});

function loadSelfPlan() {
	// 使用ajax查询数据
	$.ajax({
		type : "post",
		async : true,
		url : "self/list.do",
		datatype : "json", // 请求页面返回的数据类型
		data : {
			"id" : 0
		},
		async : false,
		success : function(data) {
			var jsonObj = JSON.parse(data);
			var str = "";
			$.each(jsonObj, function(i, item) {
				str += "<tr><td>" + (i + 1) + "</td><td>" + item.khName
						+ "</td><td>" + item.ljname + "</td><td>" + item.count
						+ "</td><td>" + item.xqDate
						+ "</td><td><a onclick='linkPage(" + item.id
						+ ")'>编辑</a> || <a onClick='openMassageModal("
						+ item.id + ")'>删除</a> || <a onclick='fenpei("
						+ item.id + ")'>分配</a></td></tr>";
			});
			$("#table1").html(str);
		}

	});
}

// 打开弹出框
function openSPModal() {
	$('#selfPlanModal').modal({
		backdrop : 'static'
	});
}

var ljList = new Array();// 零件信息集合

// 跳转到添加或者编辑页面的方法
function linkPage(id) {
	$("#pk_id").val(id);

	// 使用ajax查询数据
	$.ajax({
		type : "post",
		async : true,
		url : "self/linkPage.do",
		datatype : "json", // 请求页面返回的数据类型
		data : {
			"id" : id
		},
		async : false,
		success : function(data) {
			var jsonObj = JSON.parse(data);
			var selfItem = jsonObj.item;

			// ---------------客户下拉框--------------------
			var khList = jsonObj.khList;
			var khOptions = "<option value='0'>---请选择---</option>";
			$.each(khList, function(i, item) {
				var value = item.id;
				var text = item.consumerName;
				khOptions += "<option value='" + value + "'";
				if (selfItem.fk_khId == item.id) {
					khOptions += " selected='selected'>" + text + "</option>";
				} else {
					khOptions += ">" + text + "</option>";
				}
			});
			$("#fk_khId").html(khOptions);

			ljList = jsonObj.ljList;

			if (id > 0) {// 编辑的时候走这里(设置零件系信息的下拉框)
				var ljOptions = "<option value='0'>---请选择---</option>";
				$.each(ljList, function(i, item) {
					var value = item.ljid;
					var text = item.ljname;
					if (selfItem.fk_khId == item.fk_khId) {
						ljOptions += "<option value='" + value + "'";
						if (selfItem.fk_ljId == item.ljid) {
							ljOptions += " selected='selected'>" + text
									+ "</option>";
						} else {
							ljOptions += ">" + text + "</option>";
						}
					}
				});

				$("#count").val(selfItem.count);
				$("#xqDate").val(selfItem.xqDate);
				$("#fk_ljId").html(ljOptions);
			} else {
				$("#count").val("");
				$("#xqDate").val("");
				$("#fk_ljId").html("");
			}
		}
	});

	openSPModal();
}

// 很据选择的客户信息设置零件信息的下拉框
function setLjXX() {// 这里是新增的时候走的
	var khId = $("#fk_khId").val();
	var ljOptions = "<option value='0'>---请选择---</option>";
	$.each(ljList, function(i, item) {
		var value = item.ljid;
		var text = item.ljname;
		if (khId == item.fk_khId) {
			ljOptions += "<option value='" + value + "'>" + text + "</option>";
		};
	});
	$("#fk_ljId").html(ljOptions);
}

// 保存信息
function saveInfo() {
	$("#selfSaveForm").submit();
};

// 分配内部计划
function fenpei(id) {
	$("#tbDiv1").show();
	linkPage(id);
	var randomNum = Math.random() * 5;
	randomNum += "";
	randomNum = randomNum.replace(".", "").substring(0, 6);
	randomNum = "GDBH" + randomNum;
	$("#gd_Id").text("工单编号：" + randomNum);
}

// 点击加号动态添加工单分配信息
function addGDDiv() {

	var str = "<tr><td><select name='sel' class='form-control'><option>1111111111111111</option><option>2</option><option>3</option></select></td><td><input type='text' class='form-control' name='name' value='1'></td><td><div class='input-group date form_date' data-date='' data-date-format='dd MM yyyy' data-link-field='dtp_input2' data-link-format='yyyy-mm-dd'><input class='form-control' size='16' type='text' readonly placeholder='需求时间...' name='xqDate' id='xqDate'><span class='input-group-addon'><span class='glyphicon glyphicon-remove'></span></span></div></td></tr>";
	$("#table_gd").append(str);
}