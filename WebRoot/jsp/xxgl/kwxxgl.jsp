<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<div class="container-fluid">
	<div class="row"><jsp:include page="../top.jsp" /></div>
	<div class="row" style="padding-left: 0">
		<div class="col-md-2" style="padding-left: 10"><jsp:include
				page="../left.jsp" /></div>
		<div class="col-md-10" style="overflow:auto;">

			<h2>库位信息管理</h2>
			<hr>

			<form action="Kwxxgl.view" class="form-horizontal" method="post">
				<div class="row">

					<div class="col-lg-2">
						
						<button type="button" class="btn btn-primary" data-toggle="modal"
							onclick="openModal()">添加库位信息.</button>
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
				<table class="table table-bordered" id="tab">
					<thead>
						<tr class="success">
							<td class="text-center">序号</td>
								<td class="text-center">库位名称</td>
								<td class="text-center">库位类型</td>
								<td class="text-center">存储类型</td>
								<td class="text-center">库位容量(m³)</td>
								<td class="text-center">库位编码</td>
								<td class="text-center">操作</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${kwxxglBeans}" var="kwxx" varStatus="staturs">
							<tr>
								<td>${staturs.index+1}</td>
								<td><c:out value="${kwxx.kwname}" /></td>
								<td><c:out value="${kwlxgkMap.get(kwxx.kwtype).kwname}" /></td>
								<td><c:out value="${kwxx.cctype}" /></td>
								<td><c:out value="${kwxx.kwrl}" /></td>
								<td><c:out value="${kwxx.kwbm}" /></td>
								<td><a onClick="openModal('1')">编辑</a> || <a href="Kwxxgl.dele?kwid=${kwxx.kwid}">删除</a>||<a onClick="openModal('2')">详情</a> </td>
								<td hidden="true">${kwxx.kwaddress}</td>
								<td hidden="true">${kwxx.kwid}</td>
								<td hidden="true">${kwxx.kwtype}</td>
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
<form action="Kwxxgl.add" class="form-horizontal" role="form"
	method="post">
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
					<input type="hidden" name="kwid" id="kwid">
					<h4 class="modal-title" id="gridSystemModalLabel">库位信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="inputKwname" class="col-md-4 control-label"> 库位名称
						</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="kwname"
								name="kwname">
						</div>
					</div>
					<div class="form-group">
						<label for="inputKwtype" class="col-md-4 control-label"> 库位类型
						</label>
						<div class="col-md-8">
						<select class="form-control" id="kwtype" name="kwtype">
						 <option value=""></option>
						<c:forEach items="${kwlxglBeanstotrue}" var="kwlx">
						<option value="${kwlx.kwid}">${kwlx.kwname}</option>
						</c:forEach>
						</select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputCctype" class="col-md-4 control-label"> 存储类型
						</label>
						<div class="col-md-8">
						<select class="form-control" id="cctype" name="cctype">
						<option value=""></option>
						<option value="1">hah</option>
						<option value="2">ww</option>
						<option value="3">3333</option>
						</select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputKwaddress" class="col-md-4 control-label"> 库位地址
						</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="kwaddress"
								name="kwaddress">
						</div>
					</div>
                    <div class="form-group">
						<label for="inputKwrl" class="col-md-4 control-label"> 库位容量
						</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="kwrl"
								name="kwrl">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button id="btns" type="submit" class="btn btn-primary">保存</button>
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

	function openModal(flag) {
		if(flag=='1'||flag=='2'){
			 $(document).on("click","#tab tr:gt(0)",function(){
				  var rows = $(this).parent().find("tr");
					for(i=0;i<rows.length;i++){
						var currentRow = $(rows[i]);
						currentRow.removeClass("warning");
					}
					$(this).addClass("warning");
					$("#kwname").val($(this).find("td:eq(1)").text());
					$("#kwtype").val($(this).find("td:eq(9)").text());
					$("#cctype").val($(this).find("td:eq(3)").text());
					$("#kwaddress").val($(this).find("td:eq(7)").text());
					$("#kwrl").val($(this).find("td:eq(4)").text());
					
					$("#kwid").val($(this).find("td:eq(8)").text());
					
			  });
		}else{
			$("#kwname").val('');
			$("#kwtype").val('');
			$("#cctype").val('');
			$("#kwaddress").val('');
			$("#kwrl").val('');
			$("#kwid").val('');
			
		}
		if(flag=='2'){
			$("#btns").hide();
		}else{
			$("#btns").show();
		}
		
		$('#gridSystemModal').modal({
			backdrop : 'static'
		});
	}
   
</script>
<%@ include file="/include.foot.jsp"%>
