<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<div class="container-fluid">
	<div class="row"><jsp:include page="../top.jsp" /></div>
	<div class="row" style="padding-left: 0">
		<div class="col-md-2" style="padding-left: 10"><jsp:include
				page="../left.jsp" /></div>
		<div class="col-md-10" style="overflow:auto;">
		<ul id="myTab" class="nav nav-tabs">
   <li >
      <a href="Scflgdxx/Scflgdxx.view" >
         待发料
      </a>
   </li>
   <li class="active"><a href="Scflgdxx/Scflgdxx.mxview" data-toggle="tab">待出库</a></li>
   <li><a href="Scflgdxx/Scflgdxx.mxviewls" >历史记录</a></li>
</ul>
<div>&nbsp;</div>
 <form action="Scflgdxx/Scflgdxx.view" class="form-horizontal" method="post">
				<div class="row">

					<div class="col-lg-2">
						<input type="hidden" class="form-control" id="flag"
								name="flag"/>
					
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
<div id="myTabContent" class="tab-content">
   <div class="tab-pane fade in active" id="dfl">
			<div class="table-responsive" style="overflow:scroll;height: 380px;">
				<table class="table table-bordered" id="tab">
					<thead>
						<tr class="success">
							<td class="text-center">序号</td>
								<td class="text-center">零件名称</td>
								<td class="text-center">条形码</td>
								<td class="text-center">库存量</td>
								<td class="text-center">入库时间</td>
								<td class="text-center">库位名称</td>
								<td class="text-center">操作</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${scflitemBeans}" var="scitem" varStatus="staturs">
							<tr>
								<td>${staturs.index+1}</td>
							    <td>${ljxxMap.get(ljbMap.get(scitem.ljbid).ljid.toString()).ljname} </td>
							    <td>${ljbMap.get(scitem.ljbid).tmbh}</td>
							    <td>${ljbMap.get(scitem.ljbid).kcl}</td>
							    <td><fmt:formatDate value="${ljbMap.get(scitem.ljbid).rksj}" pattern="yyyy-MM-dd" /></td>
							    <td>${ljbMap.get(scitem.ljbid).kwid}</td>
								<td><a onClick="openModal(${scitem.flmxid})">出库</a> </td>
								
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



   <div class="tab-pane fade" id="dck">
      <p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和 Apple 
      TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
   </div>
    <div class="tab-pane fade" id="lsjl">
      <p>sadasdasdasda。</p>
   </div>
</div>
		
		</div>

			

			


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
					<input type="hidden" name="gdmxid" id="gdmxid">
					<h4 class="modal-title" id="gridSystemModalLabel">出库信息</h4>
				</div>
				<div class="modal-body" id="ckxx">
              <div style='border:1px solid black'>
               	
				</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="opensave" onclick="sub()">确定</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->



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

	function openModal(flmxid) {
		$(document).on("click","#tab tr:gt(0)",function(){
			
			  var rows = $(this).parent().find("tr");
				for(i=0;i<rows.length;i++){
					var currentRow = $(rows[i]);
					currentRow.removeClass("warning");
				}
		        $("#gdmxid").val(flmxid);
                 var ht=" <p><label>零件名称："+$(this).find("td:eq(1)").text()+"</label> <label>条形码："+$(this).find("td:eq(2)").text()+"</label></p><p><label>入库时间:"+$(this).find("td:eq(4)").text()+"</label>"+
                   	 " <label>库存量："+$(this).find("td:eq(3)").text()+"</label></p><p><label>原库位名："+$(this).find("td:eq(5)").text()+"</label></p><p><label>现库位名：</label>"+
                   	  " <select onchange='changekuwei' id='kwlx' name='kwlx'><option>11</option></select> <select  id='kwname' name='kwname'><option value='11'>11</option></select></p>";
                   
                   var prevDiv = document.getElementById('ckxx');  
           		   prevDiv.innerHTML =ht;  
            });
            

		$('#gridSystemModal').modal({
			backdrop : 'static'
		});
	}

	function sub(){
		var gdmxid=$("#gdmxid").val();
		var kwname=$("#kwname").val();

		//那么现在来检测s的值就知道选中的复选框的值了 
		if(kwname==''||kwname==null){
			alert('你还没有选择库位！');
	    }else{
	    	parent.location="Scflgdxx/Scflgdxx.chukusave?gdmxid="+gdmxid+"&kwname="+kwname;
	    }
		
	}
	

</script>
<%@ include file="/include.foot.jsp"%>
