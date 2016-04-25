$(function() {
	loadReceiveInfo(1);
});

function loadReceiveInfo(status) {
	// 使用ajax查询数据
	$.ajax({
		type : "post",
		async : true,
		url : "receive/receive.do",
		datatype : "json", // 请求页面返回的数据类型
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
			$.each(list, function(i, item) { // 生成table数据
				if (status == 1)
					str += "<tr>" + "<td>" + (i + 1) + "</td>" + "<td>" + item.consumerName + "</td>" + "<td>" + item.ljname + "</td>" + "<td>" + item.count + "</td>" + "<td>" + item.packName
							+ "</td>" + "<td>" + item.thDate + "</td>" + "<td><a onClick='linkPage(" + item.id + ",1)'>编辑</a> || <a onClick='openMassageModal(" + item.id
							+ ")'>删除</a> || <a onClick='openPage(" + item.id + ")'>提货</a></td></tr>";
				else if (status == 2)
					str += "<tr>" + "<td>" + (i + 1) + "</td>" + "<td>" + item.consumerName + "</td>" + "<td>" + item.ljname + "</td>" + "<td>" + item.count + "</td>" + "<td>" + item.packName
							+ "</td>" + "<td>" + item.thDate + "</td>" + "<td><a onClick='linkPage(" + item.id + ",2)'>详情</a> || <a onClick='openYHPage(" + item.id + ")'>验货</a></td></tr>";
			});
			// console.log(str);
			$("#" + tableBodyId).html(str);
			// $("#"+tableBodyId).append(html);
		}
	});
};

// 跳转到修改或者添加页面
function linkPage(id, status) {
	// 设置编辑的数据ID到弹出框中
	$("#recId").val(id);
	if (status == 1) {
		// 把编辑保存功能的按钮显示出啦
		$("#sav1").show();
		$("#thDiv1").show();
		$("#sav2").hide();
		$("#thDiv2").hide();
	} else if (status == 2) {
		$("#sav1").hide();
		$("#thDiv1").show();
		$("#sav2").hide();
		$("#thDiv2").show();
	}

	$.ajax({
		type : "post",
		async : true,
		url : "receive/linkPage.do",
		datatype : "json", // 请求页面返回的数据类型
		data : {
			"id" : id,
			"status" : status
		},
		async : false,
		success : function(data) {
			// 对象先转字符串
			var resJSON = eval('(' + data + ')');

			var item = resJSON.item;
			var ljxxList = resJSON.ljxxList; // 零件
			var packList = resJSON.packList; // 包装

			if (id > 0) {
				$("#count").val(item.count);
				$("#thDate").val(item.thDate);

				$("#thMan").val(item.thMan);
				$("#thCar").val(item.thCar);
			} else {
				$("#count").val("");
				$("#thDate").val("");

				$("#thMan").val("");
				$("#thCar").val("");
			}

			/* ---------------零件名称下拉框--------------------- */
			RemoveOption('ljName');
			var ljSelect = $("#ljName");

			ljSelect.append("<option value='0'>--请选择--</option>"); // 方法1：添加默认节点
			$.each(ljxxList, function(i, tmpItem) {
				var proid = tmpItem.ljid;
				var proname = tmpItem.ljname;
				if (item.fk_ljID == proid) {
					AppendOption('ljName', proid, proname, true); // 调用自定义方法
				} else {
					AppendOption('ljName', proid, proname, false); // 调用自定义方法
				}

			});

			/* ---------------包装类型下拉框--------------------- */
			RemoveOption('bzType');
			var bzSelect = $("#bzType");

			bzSelect.append("<option value='0'>--请选择--</option>"); // 方法1：添加默认节点
			$.each(packList, function(i, tmpItem) {
				var proid = tmpItem.id;
				var proname = tmpItem.packName;
				if (item.fk_bzID == proid) {
					AppendOption('bzType', proid, proname, true); // 调用自定义方法
				} else {
					AppendOption('bzType', proid, proname, false); // 调用自定义方法
				}

			});
		}
	});

	openModal(); // 打开添加或者窗口
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

function RemoveOption(selId) { // 删除节点
	var obj = document.getElementById(selId);
	obj.options.length = 0;
}

function AppendOption(selId, value, text, selected) { // 添加下拉框信息
	var sel;
	if (selected) {
		sel = ' selected="selected"';
	}
	$("#" + selId).append("<option value='" + value + "'" + sel + ">" + text + "</option>");
}
// 打开验货输入页面
function openYHPage(id) {
	openYHModal();
	$("#recId").val(id);
	$.ajax({
		type : "post",
		url : "receive/loadTxm.do",
		async : true,
		data : {
			"recId" : id,
		},
		success : function(data) {
			var list = eval(data);
			// $("#txmDiv").html("");
			var str = "";
			$.each(list, function(i, item) {
				str += "<intput type='hidden' value='" + item.id + "' id='txmId'><label for='inputTitle' class='col-sm-2 control-label'>条形码" + "</label><div class='col-sm-5'>	"
						+ "<input type='text' maxlength='30' class='form-control' id='count' name='count' value='" + item.txm + "'></div>"
						+ "<label for='inputTitle' class='col-sm-2 control-label'>零件数量</label><div class='col-sm-3'>"
						+ "<input type='text' maxlength='30' class='form-control' id='count' name='count' value='" + item.realCount + "'></div>";
			});
			$("#txmDiv").html(str);
		}
	});

}

function addTxmDiv() {
	var randomNum = Math.random() * 5;
	randomNum += "";
	randomNum = randomNum.replace(".", "").substring(0, 12);

	var str = '<div id="addDiv"><intput type="hidden" id="txmId" value="0"><label for="inputTitle" class="col-sm-2 control-label">条形码</label><div class="col-sm-5">	<input type="text" maxlength="30" class="form-control" name="txm" value='
			+ randomNum
			+ '></div>'
			+ '<label for="inputTitle" class="col-sm-2 control-label">零件数量</label>	<div class="col-sm-3">		<input type="text" maxlength="30" class="form-control" name="count"></div></div>';
	$("#txmDiv").append(str);
}

function savexm() {
	var doc = $("#addDiv");
	var recId = $("#recId").val();
	// var txm=doc.children(".col-sm-5").children(".form-control").val();
	// var count=doc.children(".col-sm-5").children(".form-control").value
	var elementTxmArr = document.getElementsByName("txm");
	var elementCountArr = document.getElementsByName("count");
	var elementIdArr = document.getElementsByName("txmId");
	var list = new Array();
	$.each(elementTxmArr, function(i, item) {
		list.push("{id:" + elementIdArr[i].value + ",txm:" + item.value + ",realCount:" + elementCountArr[i].value + "}");
	});
	var obj = JSON.stringify(list);
	console.log(obj);
	$.ajax({
		type : "post",
		url : "receive/insertTxm.do",
		async : true,
		data : {
			"data" : obj,
			"recId" : recId
		},
		success : function(data) {

		}
	});
}