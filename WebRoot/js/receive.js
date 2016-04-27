$(function() {
	loadReceiveInfo(1);
});

function loadReceiveInfo(status) {

	var seachKeyWord = "seachKeyWord" + status;
	var seachStartDate = "seachStartDate" + status;
	var seachEndDate = "seachEndDate" + status;
	// 使用ajax查询数据
	$.ajax({
		type : "post",
		async : true,
		url : "receive/receive.do",
		datatype : "json", // 请求页面返回的数据类型
		data : {
			"status" : status,
			"seachKeyWord" : $("#" + seachKeyWord).val(),
			"seachStartDate" : $("#" + seachStartDate).val(),
			"seachEndDate" : $("#" + seachEndDate).val()
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
				else if (status == 3) {
					str += "<tr>" + "<td>" + (i + 1) + "</td>" + "<td>" + item.consumerName + "</td>" + "<td>" + item.ljname + "</td>" + "<td>" + item.thDate + "</td>" + "<td>" + item.count + "</td>"
							+ "<td>" + item.realCount + "</td>" + "<td><a onClick='linkPage(" + item.id + ",3)'>详情</a> || ";
					if (item.realCount > item.count) {
						if (item.bd_flag) {
							str += "<a onClick='fenku(" + item.id + ")'>分库</a></td></tr>";
						} else {
							str += "<a onClick='budan(" + item.id + ")'>补单</a></td></tr>";
						}
					} else {
						str += "<a onClick='fenku(" + item.id + ")'>分库</a></td></tr>";
					}
				} else {
					str += "<tr>" + "<td>" + (i + 1) + "</td>" + "<td>" + item.consumerName + "</td>" + "<td>" + item.ljname + "</td>" + "<td>" + item.thDate + "</td>" + "<td>" + item.count + "</td>"
							+ "<td>" + item.realCount + "</td>";
					if (item.over_flag) {
						str += "<td>已完成</td>";
					} else {
						str += "<td style='color: red'>未确认 </td>";
					}
					str += "<td><a onClick='linkPage(" + item.id + ",4)'>详情</a> </td></tr>";
				}
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
		$("#thDiv3").hide();
		$("#thDiv4").hide();
	} else if (status == 2) {
		$("#sav1").hide();
		$("#thDiv1").show();
		$("#sav2").hide();
		$("#thDiv2").show();
		$("#thDiv3").hide();
		$("#thDiv4").hide();
	} else if (status == 3) {
		$("#sav1").hide();
		$("#sav2").hide();
		$("#thDiv1").show();
		$("#thDiv2").show();
		$("#thDiv3").show();
	} else if (status == 4) {
		$("#sav1").hide();
		$("#sav2").hide();
		$("#thDiv1").show();
		$("#thDiv2").show();
		$("#thDiv3").hide();
		$("#thDiv5").show();
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
			var txmList = resJSON.txmList;// 条形码
			var bdItem = resJSON.bdItem;// 补单信息
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

			/* --------------------------(在分库点击详请时)条形码显示 ----------------- */
			var str = "";
			$("#thDiv3").html("");
			if (txmList != undefined && txmList.length > 0) {
				if (status == 3)
					str = "<hr>";
				$.each(txmList, function(i, item) {
					if (status == 3) {// 分库的时候查看
						str += "<input type='hidden' value='" + item.fk_receId + "' name='fk_receId'><input type='hidden' value='" + item.id
								+ "' name='txm_Id'><label for='inputTitle' class='col-sm-2 control-label'>条形码" + "</label><div class='col-sm-5'>	"
								+ "<input type='text' maxlength='30' class='form-control' name='txm_name' value='" + item.txm + "'></div>"
								+ "<label for='inputTitle' class='col-sm-2 control-label'>零件数量</label><div class='col-sm-3'>"
								+ "<input type='text' maxlength='30' class='form-control' name='txm_count' value='" + item.realCount + "'></div>";
					}
					if (status == 4) {// 入库确认的时候查看
						str += "<tr><td>" + item.txm + "</td><td>" + item.realCount + "</td><td>" + item.kwType + "</td><td>" + item.kwName + "</td></tr>";
					}

				});
			}
			if (status == 3) {// 分库的时候查看
				$("#thDiv3").html(str);
			}
			if (status == 4) {// 分库的时候查看
				$("#table_txm").html(str);
			}
			// ----------------补单信息设置
			if (bdItem.id > 0) {// 如果查出补单信息，进行设置
				$("#thDiv4").show();
				$("#bd_name").val(bdItem.ljname);
				$("#bd_count").val(bdItem.count);
				$("#bd_bzType").val(bdItem.packName);
				$("#bd_date").val(bdItem.bd_date);
			} else {
				$("#thDiv4").hide();
			}

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

	linkPage(id, 1);

	$("#sav1").hide();
	$("#thDiv1").hide();
	$("#sav2").show();
	$("#thDiv2").show();
	$("#thDiv3").hide();
	$("#thDiv4").hide();
	$("#thDiv5").hide();
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
	$("#yh_recId").val(id);
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
				str += "<input type='hidden' value='" + item.fk_receId + "' name='fk_receId'><input type='hidden' value='" + item.id
						+ "' name='txm_Id'><label for='inputTitle' class='col-sm-2 control-label'>条形码" + "</label><div class='col-sm-5'>	"
						+ "<input type='text' maxlength='30' class='form-control' name='txm_name' value='" + item.txm + "'></div>"
						+ "<label for='inputTitle' class='col-sm-2 control-label'>零件数量</label><div class='col-sm-3'>"
						+ "<input type='text' maxlength='30' class='form-control' name='txm_count' value='" + item.realCount + "'></div>";
			});
			$("#txmDiv").html(str);
		}
	});
}

function addTxmDiv() {
	var recId = $("#recId").val();// 取得提货信息的ID
	var randomNum = Math.random() * 5;
	randomNum += "";
	randomNum = randomNum.replace(".", "").substring(0, 12);

	var str = '<div id="addDiv"><input type="hidden" name="fk_receId" value='
			+ recId
			+ '><input type="hidden" name="txm_Id" value="0"><label for="inputTitle" class="col-sm-2 control-label">条形码</label><div class="col-sm-5">	<input type="text" maxlength="30" class="form-control" name="txm_name" value='
			+ randomNum + '></div>'
			+ '<label for="inputTitle" class="col-sm-2 control-label">零件数量</label>	<div class="col-sm-3">		<input type="text" maxlength="30" class="form-control" name="txm_count"></div></div>';
	$("#txmDiv").append(str);
}

// 添加或者修改
function savexm() {
	// var doc = $("#addDiv");
	// var txm=doc.children(".col-sm-5").children(".form-control").val();
	// var count=doc.children(".col-sm-5").children(".form-control").value

	var elementTxmArr = document.getElementsByName("txm_name");
	var elementCountArr = document.getElementsByName("txm_count");
	var elementIdArr = document.getElementsByName("txm_Id");
	var elementFk_receIdArr = document.getElementsByName("fk_receId");
	var list = new Array();
	$.each(elementTxmArr, function(i, item) {
		list.push("{id:" + elementIdArr[i].value + ",txm:" + item.value + ",realCount:" + elementCountArr[i].value + ",fk_receId:" + elementFk_receIdArr[i].value + "}");
	});
	var obj = JSON.stringify(list);
	// console.log(obj);
	$.ajax({
		type : "post",
		url : "receive/saveTxm.do",
		async : true,
		data : {
			"data" : obj,
		},
		success : function(data) {
		}
	});
	$('#yanhuoModal').modal('hide');// 关闭弹出框
}
// 点击验货按钮修改数据状态
function yanhuo() {

	var recId = $("#yh_recId").val();// 取得提货信息的ID
	$.ajax({
		type : "post",
		url : "receive/yanhuo.do",
		async : true,
		data : {
			"recId" : recId,
		},
		success : function(data) {
			loadReceiveInfo(2);
		}
	});
	$('#yanhuoModal').modal('hide');// 关闭弹出框
}

// 补单
function budan(id) {
	$("#link_id").val(id);
	linkPage(0, 1);
}

var kwInfoList = new Array;// 库位信息的全局变量

// 分库
function fenku(id) {
	// id 代表提货的主键ID
	openFKModal();

	$("#fenku_recId").val(id);

	$.ajax({
		type : "post",
		url : "receive/fenkuList.do",
		async : false,
		data : {
			"recId" : id,
		},
		success : function(data) {
			var jsonObj = eval("(" + data + ")");
			var txmList = jsonObj.txmList;
			var kwTypeList = jsonObj.kwTypeList;
			kwInfoList = jsonObj.kwInfoList;

			var str = "";
			$.each(txmList, function(i, item) {
				// 库位类型下拉框内容
				var options = setSelectInfo(item.fk_kwTypeId, kwTypeList);
				str += "<div class='form-group'>" + "<input type='hidden' name='txm_Id' value='" + item.id + "'>"
						+ "<label for='inputTitle' class='col-sm-2 control-label' style='width: 80px'>条形码</label>" + "<div class='col-sm-3'>"
						+ "<input type='text' class='form-control' name='txm_name' value='" + item.txm + "'>" + "</div>"
						+ "<label for='inputTitle' class='col-sm-2 control-label' style='width: 80px'>库位号</label>" + "<div class='col-sm-3'>"
						+ "<select class='form-control' name='kuweiType' id='kwTy_" + i + "' onchange='kuweiSelect(" + i + "," + item.fk_kwID + ")'>" + options + "</select>" + "</div>"
						+ "<div class='col-sm-2'>" + "<select class='form-control' name='kuwei' id='kwInfo_" + i + "' style='width: 140px'></select>" + "</div>" + "</div>";
			});
			$("#fkDiv").html(str);
		}
	});
}

// 循环设置库位类型下拉框
function setSelectInfo(kwTypeId, kwTypeList) {
	var str = "<option value='0'>--库位类型--</option>";
	$.each(kwTypeList, function(i, item) {
		var value = item.kwid;
		var text = item.kwname;
		if (item.kwid == kwTypeId) {
			str += "<option value='" + value + "' selected='selected'>" + text + "</option>"; // 调用自定义方法
		} else {
			str += "<option value='" + value + "' >" + text + "</option>"; // 调用自定义方法
		}
	});
	return str;
}

// 设置库位下拉框
function kuweiSelect(index, fk_kwID) {
	var kwTyId = $("#kwTy_" + index).val();

	var str = "<option value='0'>--库位--</option>";
	$.each(kwInfoList, function(i, item) {
		var value = item.kwid;
		var text = item.kwname;
		if (item.kwtype == kwTyId) {// 根据库位类型进行筛选
			if (fk_kwID == value) {
				str += "<option value='" + value + "' selected='selected'>" + text + "</option>"; // 调用自定义方法
			} else {
				str += "<option value='" + value + "' >" + text + "</option>"; // 调用自定义方法
			}
		}
	});

	$("#kwInfo_" + index).html(str);
}
// 分库信息确认
function fenkuSave() {
	var elementTxmArr = document.getElementsByName("txm_Id");
	var elementKwTyArr = document.getElementsByName("kuweiType");
	var elementKwArr = document.getElementsByName("kuwei");

	var list = new Array();
	$.each(elementTxmArr, function(i, item) {
		list.push("{id:" + item.value + ",fk_kwTypeId:" + elementKwTyArr[i].value + ",fk_kwID:" + elementKwArr[i].value + "}");
	});
	var obj = JSON.stringify(list);
	// console.log(obj);
	$.ajax({
		type : "post",
		url : "receive/saveTxm.do",
		async : true,
		data : {
			"data" : obj,
		},
		success : function(data) {
		}
	});
	fkUpdate();
}
// 修改备份库的提货信息
function fkUpdate() {
	var recId = $("#fenku_recId").val();
	$.ajax({
		type : "post",
		url : "receive/fenku.do",
		async : true,
		data : {
			"recId" : recId,
		},
		success : function(data) {
		}
	});
	loadReceiveInfo(3);
	$('#fenkuModal').modal('hide');// 关闭弹出框
}
