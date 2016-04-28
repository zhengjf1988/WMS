<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<div class="container-fluid">
	<div class="row"><jsp:include page="../top.jsp" /></div>
	<div class="row" style="padding-left: 0">
		<div class="col-md-2" style="padding-left: 10"><jsp:include
				page="../left.jsp" /></div>
		<div class="col-md-10" style="overflow:auto;">

			<h2>存储期限管理</h2>
			<hr>

			<form action="Ccqxgl.view" class="form-horizontal" method="post">
				<div class="row">

					<div class="col-lg-2">
						
						<button type="button" class="btn btn-primary" data-toggle="modal"
							onclick="openModal()">添加存储期限.</button>
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
								<td class="text-center">零件存储类型</td>
								<td class="text-center">库位存储类型</td>
								<td class="text-center">是否受限</td>
								<td class="text-center">存储期限</td>
								<td class="text-center">创建日期</td>
								<td class="text-center">创建人员</td>
								<td class="text-center">操作</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ccqxglBeans}" var="ccqx" varStatus="staturs">
							<tr>
								<td>${staturs.index+1}</td>
								<td><c:out value="${ccqx.ccname}" /></td>
								<td><c:out value="${ccqx.kwmeno}" /></td>
								<td><c:if test="${ccqx.issx==0 }">否</c:if><c:if test="${ccqx.issx==1}">是</c:if></td>
								<td><c:if test="${ccqx.sxqx==null }">无限制</c:if><c:if test="${ccqx.issx==1}"><fmt:formatDate value="${ccqx.sxqx}" pattern="yyyy-MM-dd" /></c:if></td>
								<td><fmt:formatDate value="${ccqx.creDate}" pattern="yyyy-MM-dd" /></td>
								
								<td><c:out value="${ccqx.inputman}" /></td>
								<td><a onClick="openModal('1')">编辑</a> || <a href="Ccqxgl.dele?ccid=${ccqx.ccid}">删除</a>||<a onClick="openModal('2')">详情</a> </td>
								<td hidden="true">${ccqx.ccid}</td>
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
<form action="Ccqxgl.add" class="form-horizontal" role="form"
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
					<input type="hidden" name="ccid" id="ccid">
					<h4 class="modal-title" id="gridSystemModalLabel">存储期限</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="inputCcname" class="col-md-4 control-label"> 零件存储类型
						</label>
						<div class="col-md-8">
								<select class="form-control" id="inputCcname" name="ccname">
						           <option value=""></option>
						           <option value="1">hah</option>
						           <option value="2">ww</option>
						           <option value="3">3333</option>
						        </select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputKwmeno" class="col-md-4 control-label"> 库位存储类型
						</label>
						<div class="col-md-8">
								<select class="form-control" id="inputKwmeno" name="kwmeno">
						           <option value=""></option>
						           <option value="1">hah</option>
						           <option value="2">ww</option>
						           <option value="3">3333</option>
						        </select>
						</div>
					</div>
                    <div class="form-group">
						<label for="inputTitle" class="col-md-4 control-label"> 是否存储受限
						</label>
						<div class="col-md-2">
							<input id="isyes" type="radio" value="1" name="issx" onclick="shower()">是
							
						</div>
						<div class="col-md-2">
							<input id="isno" type="radio" value="0" name="issx" onclick="hiddens()">否
						</div>
					</div>
                   <div class="form-group" id="ljccqx" style="display:none">
						<label for="inputTitle" class="col-md-4 control-label"> 零件存储期限
						</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="inputSxqx"
								name="sxqx">
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
					$("#inputCcname").val($(this).find("td:eq(1)").text());
					$("#inputKwmeno").val($(this).find("td:eq(2)").text());
					var issx=$(this).find("td:eq(3)").text();
					if(issx=='是'){
						$("#isyes").attr("checked",'checked');
						shower();
						$("#inputSxqx").val($(this).find("td:eq(4)").text());
					}else{
						 hiddens();
						$("#isno").attr("checked",true);
					}
					$("#ccid").val($(this).find("td:eq(8)").text());
					
			  });
		}else{
			$("#inputCcname").val('');
			$("#inputKwmeno").val('');
			$("#isyes").attr("checked",false);
			$("#isno").attr("checked",false);
			$("#inputSxqx").val('');
			$("#ccid").val('');
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
	function shower(){
		$('#ljccqx').show();
		}
    function hiddens(){
    	$('#inputSxqx').val('');
		$('#ljccqx').hide();
		}
   
</script>
<%@ include file="/include.foot.jsp"%>
