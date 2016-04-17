<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<div class="container-fluid">
	<div class="row"><jsp:include page="../top.jsp" /></div>
	<div class="row" style="padding-left: 0">
		<div class="col-md-2" style="padding-left: 10"><jsp:include
				page="../left.jsp" /></div>
		<div class="col-md-10" style="overflow:auto;">

			<h2>库位类型管理</h2>
			<hr>

				<form action="Kwlx/Kwlxgl.view" class="form-horizontal" method="post">
				<div class="row">

					<div class="col-lg-2">
						
						<button type="button" class="btn btn-primary" data-toggle="modal"
							onclick="openModal()">添加库位类型</button>
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
								class="form-control" placeholder="关键词" value="${keys}" name="keys"></span>
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
								<td class="text-center">库位类型</td>
								<td class="text-center">说明</td>
								<td class="text-center">创建日期</td>
								<td class="text-center">创建人员</td>
								<td class="text-center">操作</td>
								<td hidden="true"></td>
						</tr>
					</thead>
					<tbody>
					
								  <c:forEach items="${kwlxglBeans}" var="kwlx" varStatus="staturs">
                       <tr>
                       <td>${staturs.index+1}</td>
                       <td>${kwlx.kwname}</td>
                       <td>${kwlx.kwmeno}</td>
                       <td><fmt:formatDate value="${kwlx.creDate}" pattern="yyyy-MM-dd" /></td>
                       <td>${kwlx.inputman}</td>
                       <td><a onclick="openupdate()">编辑</a>&nbsp;&nbsp;<a href="Kwlx/Kwlxgl.dele?kwid=${kwlx.kwid }">删除</a>&nbsp;&nbsp;<a onclick="openview()">详情</a></td>                   
                          
                       <td hidden="true">${kwlx.kwid }</td>
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

<form action="Kwlx/Kwlxgl.add" class="form-horizontal" role="form"
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
					<h4 class="modal-title" id="gridSystemModalLabel">库位类型</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label"> 类型名称
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="kwname"
								name="kwname">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-2 control-label"> 类型说明
						</label>
						<div class="col-sm-10">
							<!-- 	<input type="texta" class="form-control" id="inputTitle"
									name="username"> -->

							<textarea rows="8" class="form-control" name="kwmeno" id="kwmeno"></textarea>
						</div>
					</div>


				</div>
				<div class="modal-footer">
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
		$("#kwname").val("");
		$("#kwmeno").val("");
		$("#kwid").val("");
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
				$("#kwname").val($(this).find("td:eq(1)").text());
				$("#kwmeno").val($(this).find("td:eq(2)").text());
				$("#kwid").val($(this).find("td:eq(6)").text());
				
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
				$("#kwname").val($(this).find("td:eq(1)").text());
				$("#kwmeno").val($(this).find("td:eq(2)").text());
				$("#kwid").val($(this).find("td:eq(6)").text());
				
		  });
		$("#opensave").hide();
		$('#gridSystemModal').modal({
			backdrop : 'static'
		});
		
	}
</script>
<%@ include file="/include.foot.jsp"%>
