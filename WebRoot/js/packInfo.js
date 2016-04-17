var flag = false;
function saveInfo() {
	var packName = $("#packName").val();
	if (packName == "") {
		$("#msgDiv").show();
		$("#msg").text("包装名称不能为空！");
		return;
	} else {
		$("#msgDiv").hide();
		$("#msg").text("");
	}

	var count = $("#count").val();
	if (count == "") {
		$("#msgDiv").show();
		$("#msg").text("数量不能为空！");
		return;
	} else {
		$("#msgDiv").hide();
		$("#msg").text("");
	}

	$("#saveForm").submit();
}