$(function() {
	loadReceiveInfo(1);
});
function loadReceiveInfo(status) {
	// 使用ajax查询数据
	$.ajax({
		type : "post",
		async : true,
		url : "receive/receive.do",
		datatype : "json",// 请求页面返回的数据类型
		data : {
			"status" : status,
			"seachKeyWord" : $("#seachKeyWord").val(),
			"seachStartDate" : $("#seachStartDate").val(),
			"seachEndDate" : $("#seachEndDate").val()
		},
		async : false,
		success : function(data) {
			// 对象先转字符串
			var resJSON = eval('(' + data + ')');

			var item = resJSON.item;
			var list = resJSON.list;

			var tableBodyId = "table" + status;
			$("#" + tableBodyId).html("");
			var str = "";
			$.each(list, function(i, item) {// 生成table数据
				str += "<tr>" + "<td>" + (i + 1) + "</td>" + "<td>"
						+ item.consumerName + "</td>" + "<td>" + item.ljname
						+ "</td>" + "<td>" + item.count + "</td>" + "<td>"
						+ item.packName + "</td>" + "<td>" + item.thDate
						+ "</td>" + "<td><a onClick='linkPage(" + item.id
						+ ")'>编辑</a> || <a onClick='openMassageModal("
						+ item.id + ")'>删除</a> || <a onClick='openPage("
						+ item.id + ")'>提货</a></td></tr>";
			});
			// console.log(str);
			$("#" + tableBodyId).html(str);
			// $("#"+tableBodyId).append(html);
		}
	});
};

// 跳转到修改或者添加页面
function linkPage(id) {
	// 设置编辑的数据ID到弹出框中
	$("#recId").val(id);

	// 把编辑保存功能的按钮显示出啦
	$("#sav1").show();
	$("#thDiv1").show();
	$("#sav2").hide();
	$("#thDiv2").hide();

	$.ajax({
		type : "post",
		async : true,
		url : "receive/linkPage.do",
		datatype : "json",// 请求页面返回的数据类型
		data : {
			"id" : id
		},
		async : false,
		success : function(data) {
			// 对象先转字符串
			var resJSON = eval('(' + data + ')');

			var item = resJSON.item;
			var ljxxList = resJSON.ljxxList;// 零件
			var packList = resJSON.packList;// 包装

			if (id > 0) {
				$("#count").val(item.count);
				$("#thDate").val(item.thDate);
			} else {
				$("#count").val("");
				$("#thDate").val("");
			}

			/* ---------------零件名称下拉框--------------------- */
			RemoveOption('ljName');
			var ljSelect = $("#ljName");

			ljSelect.append("<option value='0'>--请选择--</option>");// 方法1：添加默认节点
			$.each(ljxxList, function(i, tmpItem) {
				var proid = tmpItem.ljid;
				var proname = tmpItem.ljname;
				if (item.fk_ljID == proid) {
					AppendOption('ljName', proid, proname, true);// 调用自定义方法
				} else {
					AppendOption('ljName', proid, proname, false);// 调用自定义方法
				}

			});

			/* ---------------包装类型下拉框--------------------- */
			RemoveOption('bzType');
			var bzSelect = $("#bzType");

			bzSelect.append("<option value='0'>--请选择--</option>");// 方法1：添加默认节点
			$.each(packList, function(i, tmpItem) {
				var proid = tmpItem.id;
				var proname = tmpItem.packName;
				if (item.fk_bzID == proid) {
					AppendOption('bzType', proid, proname, true);// 调用自定义方法
				} else {
					AppendOption('bzType', proid, proname, false);// 调用自定义方法
				}

			});
		}
	});

	openModal();// 打开添加或者窗口
}

// 添加或者修改信息保存
function saveInfo() {
	$("#saveForm").submit();
}

// 提货信息页面打开
function openPage(id) {
	linkPage(id);
	$("#sav1").hide();
	$("#thDiv1").hide();
	$("#sav2").show();
	$("#thDiv2").show();
}

// 提货信息页面，点击保存
function tihuo() {
	var th_PKId = $("#recId").val();
	$("#th_PKId").val(th_PKId);
	var th_Car = $("#thCar").val();
	$("#th_Car").val(th_Car);
	var th_Man = $("#thMan").val();
	$("#th_Man").val(th_Man);

	$("#thId").submit();
}

function RemoveOption(selId) {// 删除节点
	var obj = document.getElementById(selId);
	obj.options.length = 0;
}

function AppendOption(selId, value, text, selected) {// 添加下拉框信息
	var sel;
	if (selected) {
		sel = ' selected="selected"';
	}
	$("#" + selId).append(
			"<option value='" + value + "'" + sel + ">" + text + "</option>");
}