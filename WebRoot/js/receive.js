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
			"status" : status
		},
		async : false,
		success : function(data) {
			// 对象先转字符串
			var resJSON = eval('(' + data + ')');

			var item = resJSON.item;
			var list = resJSON.list;

			var tableBodyId = "table" + status;
			$("#"+tableBodyId).html("");
			var html="";
			$.each(list, function(i, item) {// 生成table数据
				html+=html+="<tr>" +
						"<td>" + (i + 1) + "</td>" +
						"<td>" + item.khName + "</td>" +
						"<td>" + item.ljName + "</td>" +
						"<td>" + item.count + "</td>" +
						"<td>" + item.bzType + "</td>" +
						"<td>" + item.thDate + "</td>" +
						"<td><a onClick='linkPage("+item.id+")'>编辑</a> || <a onClick='openMassageModal("+item.id+")'>删除</a> || <a onClick='linkPage("+item.id+")'>提货</a></td></tr>";
			});
			console.log(html);
			$("#"+tableBodyId).html(html);
			//$("#"+tableBodyId).append(html);
		}
	});
};

function linkPage(id) {

	openModal();// 打开添加或者窗口
}