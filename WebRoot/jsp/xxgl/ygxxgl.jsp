<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<div class="container-fluid">
	<div class="row"><jsp:include page="../top.jsp" /></div>
	<div class="row" style="padding-left: 0">
		<div class="col-md-2" style="padding-left: 10"><jsp:include
				page="../left.jsp" /></div>
		<div class="col-md-10" style="overflow:auto;">

			<h2>员工信息管理</h2>
			<hr>

				<form action="Ljlxgl.view" class="form-horizontal" method="post">
				<div class="row">

					<div class="col-lg-2">
						
						<button type="button" class="btn btn-primary" data-toggle="modal"
							onclick="openModal()">添加员工信息</button>
					</div>


		
				
					<div class="col-lg-2">
						<div class="input-group date form_date" data-date=""
							data-date-format="dd MM yyyy" data-link-field="dtp_input2"
							data-link-format="yyyy-mm-dd">
							<input class="form-control" size="16" type="text" value="${startDate}" name="startDate"
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
							<input class="form-control" size="16" type="text" 
								readonly id="dateTo" placeholder="结束时间..." value="${endDate}" name="endDate"> <span
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
							<span class="input-group-btn"> <input type="text"
								class="form-control" placeholder="关键词" value="${keys}" name="keys">
						</div>
						<!-- /input-group -->
					</div>
					<div class="col-lg-2">
						<div class="input-group">
							<input type="submit" value="搜索" class="btn">
						</div>
						<!-- /input-group -->
					</div>
					<!-- /.col-lg-6 -->
				</div>
				<!-- /.row -->
			</form>

			<div class="table-responsive" style="overflow:scroll;height: 380px;">
				<table class="table table-bordered" id="table">
					<thead>
						<tr class="success">
							<td class="text-center">序号</td>
								<td class="text-center">员工编号</td>
								<td class="text-center">员工姓名</td>
								<td class="text-center">职位名称</td>
								<td class="text-center">部门名称</td>
								<td class="text-center">联系方式</td>
								<td class="text-center">筛选能力</td>
								<td class="text-center">操作</td>
								<td hidden="true"></td>
						</tr>
					</thead>
					<tbody>
					
								  <c:forEach items="${YgxxglBeans}" var="ygxx" varStatus="staturs">
                       <tr>
                       <td>${staturs.index+1}</td>
                       <td>${ygxx.ygbh}</td>
                       <td>${ygxx.ygxm}</td>
                       <td>${ygxx.zwmc}</td>
                       <td>${ygxx.bmmc}</td>
                       <td>${ygxx.lxfs}</td>
                        <td>${ygxx.sxnl}</td>
                       <td><a onclick="openupdate()">编辑</a>&nbsp;&nbsp;<a href="Ygxxgl.dele?ygid=${ygxx.ygid }">删除</a>&nbsp;&nbsp;<a onclick="openview()">详情</a></td>                   
                          
                       <td hidden="true">${ygxx.ygid }</td>
                        <td hidden="true">${ygxx.photoAddr }</td>
                        </tr>
                       </c:forEach>
							
					
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

<form action="Ygxxgl.add" class="form-horizontal" role="form"
	method="post" enctype="multipart/form-data">
	<div class="modal fade" role="dialog"
		aria-labelledby="gridSystemModalLabel" id="gridSystemModal"
		tabindex="-1" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<input type="hidden" name="ygid" id="ygid">
					<h4 class="modal-title" id="gridSystemModalLabel">员工信息</h4>
				</div>
				<div class="modal-body" >
				  
				  <div class="form-group">
				
						<label for="inputTitle" class="col-sm-4 control-label"> 员工卡号
						</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="ygbh"
								name="ygbh">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-4 control-label"> 员工姓名
						</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="ygxm"
								name="ygxm">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-4 control-label"> 职位名称
						</label>
						<div class="col-sm-8">
								<input type="texta" class="form-control" id="zwmc"
									name="zwmc"> 

							
						</div>
					</div>
                         <div class="form-group">
						<label for="inputTitle" class="col-sm-4 control-label"> 部门名称
						</label>
						<div class="col-sm-8">
							 	<input type="texta" class="form-control" id="bmmc"
									name="bmmc">

							
						</div>
					</div>
                      <div class="form-group">
						<label for="inputTitle" class="col-sm-4 control-label"> 联系方式
						</label>
						<div class="col-sm-8">
								<input type="texta" class="form-control" id="lxfs"
									name="lxfs">

							
						</div>
					</div>
					 <div class="form-group">
						<label for="inputTitle" class="col-sm-4 control-label"> 筛选能力
						</label>
						<div class="col-sm-8">
								<input type="text" class="form-control" id="sxnl"
									name="sxnl">

							
						</div>
					</div>
					
					
					
				 </div>
				
		<!-- 上传图片 -->
				 <div >
				   <div class="col-sm-12 " id="preview" ></div>
				     <div class="col-sm-12 ">&nbsp;</div>
				      <div class="col-sm-12 ">&nbsp;</div>
				     <div class=" col-sm-12 ">
				      <div class="col-sm-4 col-md-4">&nbsp;</div>
				     <button type="button"  id="" name=""  onclick="uploadimg()" >上传图片</button>
				     </div>
				     
				       <div class="col-sm-12 " style="position:relative; display:none;" id="upimagediv">
							
								<span id="span1">  
									<input  name="file" type="file" style="margin-bottom:10px;" id="file" onchange="preview(this)" />
								</span>
									
									<input type="button" value="取消" onclick="upimagedivhidden()" />
							
								 
							</div> 
				  </div>
				 
				
				<div class="modal-footer col-sm-12 ">
				 <div class="col-sm-12 ">&nbsp;</div>
				  <div class="col-sm-12 ">&nbsp;</div>
				   <div class="col-sm-12 ">&nbsp;</div>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary" id="opensave">保存</button>
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
		$("#ygid").val("");
		$("#ygbh").val("");
		$("#ygxm").val("");
		$("#zwmc").val("");
		$("#bmmc").val("");
		$("#lxfs").val("");
		$("#sxnl").val("");
		var prevDiv = document.getElementById('preview');  
		prevDiv.innerHTML = "";

		$("#opensave").show();
		$('#gridSystemModal').modal({
			backdrop : 'static'
		});
	}
	
	function openupdate(){
		$(document).on("click","#table tr:gt(0)",function(){
			  var rows = $(this).parent().find("tr");
				for(i=0;i<rows.length;i++){
					var currentRow = $(rows[i]);
					currentRow.removeClass("warning");
				}
				$(this).addClass("warning");
				$("#ygbh").val($(this).find("td:eq(1)").text());
				$("#ygxm").val($(this).find("td:eq(2)").text());
				$("#zwmc").val($(this).find("td:eq(3)").text());
				$("#bmmc").val($(this).find("td:eq(4)").text());
				$("#lxfs").val($(this).find("td:eq(5)").text());
				$("#sxnl").val($(this).find("td:eq(6)").text());
				$("#ygid").val($(this).find("td:eq(8)").text());
				
				//显示图片
				var prevDiv = document.getElementById('preview');  
				prevDiv.innerHTML = "<img class='col-sm-12' src='file/user/" + $(this).find("td:eq(9)").text() + "' />";
				
		  });
		$("#opensave").show();
		$('#gridSystemModal').modal({
			backdrop : 'static'
		});
	}
	
	function openview(){
		$(document).on("click","#table tr:gt(0)",function(){
			  var rows = $(this).parent().find("tr");
				for(i=0;i<rows.length;i++){
					var currentRow = $(rows[i]);
					currentRow.removeClass("warning");
				}
				$(this).addClass("warning");
				$("#ygbh").val($(this).find("td:eq(1)").text());
				$("#ygxm").val($(this).find("td:eq(2)").text());
				$("#zwmc").val($(this).find("td:eq(3)").text());
				$("#bmmc").val($(this).find("td:eq(4)").text());
				$("#lxfs").val($(this).find("td:eq(5)").text());
				$("#sxnl").val($(this).find("td:eq(6)").text());
				$("#ygid").val($(this).find("td:eq(8)").text());
				var prevDiv = document.getElementById('preview');  
				prevDiv.innerHTML = "<img class='col-sm-12' src='file/user/" + $(this).find("td:eq(9)").text() + "' />";

		  });
		$("#opensave").hide();
		$('#gridSystemModal').modal({
			backdrop : 'static'
		});
		
	}
function uploadimg(){
	$("#upimagediv").show();

}
function upimagedivhidden() {
	document.getElementById("span1").innerHTML="<input id='fileupload' name='file' type='file' id='file'/>";
		$("#upimagediv").hide();
	}

   


</script>
<script type="text/javascript">    
 function preview(file)  
 {  
 var prevDiv = document.getElementById('preview');  
 if (file.files && file.files[0])  
 {  
 var reader = new FileReader();  
 reader.onload = function(evt){  
 prevDiv.innerHTML = "<img class='col-sm-12' src='" + evt.target.result + "' />";  
}    
 reader.readAsDataURL(file.files[0]);  
}  
 else    
 {  
 prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';  
 }  
 $("#upimagediv").hide();
 }  
 </script> 
<%@ include file="/include.foot.jsp"%>
