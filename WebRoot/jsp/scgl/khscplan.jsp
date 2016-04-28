<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<div class="container-fluid">
	<div class="row"><jsp:include page="../top.jsp" /></div>
	<div class="row" style="padding-left: 0">
		<div class="col-md-2" style="padding-left: 10"><jsp:include
				page="../left.jsp" /></div>
		<div class="col-md-10" style="overflow:auto;">

			<h2>客户生产计划</h2>
			<hr>

			<form action="Khscplan/Khscplan.view" class="form-horizontal" method="post">
				<div class="row">

					<div class="col-lg-2">
						
						<button type="button" class="btn btn-primary" data-toggle="modal"
							onclick="openModal()">添加信息.</button>
							<button type="button" class="btn btn-primary" data-toggle="modal"
							onclick="">导入信息.</button>
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
								<td class="text-center">客户名称</td>
								<td class="text-center">零件名称</td>
								<td class="text-center">零件数量</td>
								<td class="text-center">需求时间 </td>
								<td class="text-center">操作</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${khscplanBeans}" var="khsc" varStatus="staturs">
							<tr>
								<td>${staturs.index+1}</td>
								<td><c:out value="${conmap.get(khsc.khid).consumerName}" /></td>
								<td><c:out value="${ljxxMap.get(khsc.ljid.toString()).ljname}" /></td>
								<td> ${khsc.ljsl}</td>
								<td><fmt:formatDate value="${khsc.xqsj}" pattern="yyyy-MM-dd" /></td>
								<td><a onClick="openModal('1')">编辑</a> || <a href="Khscplan/Khscplan.dele?khid=${khsc.khscid}">删除</a><c:if test="${khsc.ispg==0}">||<a href="Khscplan/Khscplan.pg?khid=${khsc.khscid}">派工</a></c:if></td>
								<td hidden="true">${khsc.khscid}</td>
								<td hidden="true">${khsc.khid}</td>
								<td hidden="true">${khsc.ljid}</td>
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
<form action="Khscplan/Khscplan.add" class="form-horizontal" role="form"
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
					<input type="hidden" name="khscid" id="khscid">
					<h4 class="modal-title" id="gridSystemModalLabel">生产计划</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="inputCcname" class="col-sm-4 control-label"> 客户名称
						</label>
						<div class="col-sm-8">
								<select class="form-control" id="khid" name="khid">
						           <option value=""></option>
						           <c:forEach items="${consumerInfoBeans }" var="con">
						           <option value="${con.id }">${con.consumerName }</option>
						           </c:forEach>
						        </select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputKwmeno" class="col-sm-4 control-label"> 零件名称
						</label>
						<div class="col-sm-8">
								<select class="form-control" id="ljid" name="ljid">
						           <option value=""></option>
						           <c:forEach items="${ljBeans }" var="lj">
						           <option value="${lj.ljid }">${lj.ljname }</option>
						           </c:forEach>
						        </select>
						</div>
					</div>
                     <div class="form-group" >
						<label for="inputTitle" class="col-sm-4 control-label"> 零件数量
						</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="ljsl"
								name="ljsl">
						</div>
				 </div>
                   <div class="form-group" >
						<label for="inputTitle" class="col-sm-4 control-label"> 需求时间
						</label>
						
						<div class="input-group date form_date col-sm-8" data-date=""
							data-date-format="dd MM yyyy" data-link-field="dtp_input2"
							data-link-format="yyyy-mm-dd">
							<input class="form-control" size="16" type="text" value="${startDate}" name="xqsj"
								readonly id="xqsj" > <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-remove"></span> </span>
							<!-- <span class="input-group-addon">
										<span class="glyphicon glyphicon-calendar"></span>
									</span> -->
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
		if(flag=='1'){
			 $(document).on("click","#tab tr:gt(0)",function(){
				  var rows = $(this).parent().find("tr");
					for(i=0;i<rows.length;i++){
						var currentRow = $(rows[i]);
						currentRow.removeClass("warning");
					}
					$(this).addClass("warning");
					
					$("#khid").val($(this).find("td:eq(7)").text());
					$("#ljid").val($(this).find("td:eq(8)").text());
					$("#ljsl").val($(this).find("td:eq(3)").text());
					$("#xqsj").val($(this).find("td:eq(4)").text());
					$("#khscid").val($(this).find("td:eq(6)").text());
					
			  });
		}else{
			$("#khid").val('');
			$("#ljid").val('');
			$("#ljsl").val('');
			$("#xqsj").val('');
			$("#khscid").val('');
		}
		
		
		$('#gridSystemModal').modal({
			backdrop : 'static'
		});
	}
	
   
</script>
<%@ include file="/include.foot.jsp"%>
