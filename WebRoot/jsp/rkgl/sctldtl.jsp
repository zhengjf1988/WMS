<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.top.jsp"%>
<div class="container-fluid">
	<div class="row"><jsp:include page="../top.jsp" /></div>
	<div class="row" style="padding-left: 0">
		<div class="col-md-2" style="padding-left: 10"><jsp:include
				page="../left.jsp" /></div>
		<div class="col-md-10" style="overflow:auto;">
		<ul id="myTab" class="nav nav-tabs">
   <li class="active">
      <a href="Sctldetail/Sctldetail.view" >
         待退料
      </a>
   </li>
   <li ><a href="Sctldetail/Sctldetail.viewls">历史记录</a></li>
</ul>
<div>&nbsp;</div>
 <form action="Sctldetail/Sctldetail.view" class="form-horizontal" method="post">
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
								<td class="text-center">条码编号</td>
								<td class="text-center">入库时间</td>
								<td class="text-center">退料数量</td>
								<td class="text-center">退料时间</td>
								<td class="text-center">操作</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sctldetailBeans}" var="sctl" varStatus="staturs">
							<tr>
								<td>${staturs.index+1}</td>
								
								<td><c:out value="${ljxxMap.get(sctl.ljid.toString()).ljname}" /></td>
								<td><c:out value="${sctl.tmbh}" /></td>
								<td><fmt:formatDate value="${sctl.rksj}" pattern="yyyy-MM-dd" /></td>
								<td><c:out value="${sctl.tlsl}" /></td>
								<td><fmt:formatDate value="${sctl.tlsj}" pattern="yyyy-MM-dd" /></td>
								<td><a onClick="openModal(${sctl.tlmxid})">详情</a>||<a href="Sctldetail/Sctldetail.update?tlmxid=${sctl.tlmxid}">入库</a> </td>
								<td hidden="true">${sctl.tlmxid}</td>
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
					<input type="hidden" name="gdid" id="gdid">
					<h4 class="modal-title" id="gridSystemModalLabel">退料信息</h4>
				</div>
				<div class="modal-body" id="ljbxx">
              
				
                 
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

	function openModal(tlmxid) {
		var ljname="";
		$(document).on("click","#tab tr:gt(0)",function(){
			
			  var rows = $(this).parent().find("tr");
				for(i=0;i<rows.length;i++){
					var currentRow = $(rows[i]);
					currentRow.removeClass("warning");
				}
				$(this).addClass("warning");
				ljname=$(this).find("td:eq(1)").text();
		$.ajax({
            type : "post",
            data : {
                    "tlmxid" : tlmxid
            },
            url : 'Sctldetail/Sctldetail.getscflxx' ,
            success : function(data) {
            
                    var boardJSON = eval(data);//循环date
                   var ht="";
                   $.each(boardJSON, function(i, d) {
                         var da=new Date(d.sxsj.time);
                         ht="<div><label>工单信息</label><p><label>工单编号："+d.gdbh+"</label><label>零件名称："+d.ljmcid+"</label></p><p> <label>生产班组："+d.scbzid+"</label>"+
                   	    "<label>计划时间："+da.getFullYear()+"-"+(da.getMonth()+1)+"-"+da.getDate()+"</label></p><label>客户名称："+d.fk_khid+"</label></div>";
            });
                   
           		$.ajax({
                    type : "post",
                    data : {
                            "tlmxid" : tlmxid
                    },
                    url : 'Sctldetail/Sctldetail.getljb' ,
                    success : function(data) {
                    
                            var boardJSON = eval(data);//循环date
                
                           $.each(boardJSON, function(i, d) {
                        	
                                 var da=new Date(d.rksj.time);
                                 ht=ht+"<div><label>物料信息</label><p><label>零件名称："+ljname+"</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>库存数量："+d.kcl+"</label></p>"+
                           	    "<p><label>条码编号："+d.tmbh+"</label>&nbsp;&nbsp;&nbsp;&nbsp;<label>入库时间："+da.getFullYear()+"-"+(da.getMonth()+1)+"-"+da.getDate()+"</label></p><label>现在库位："+d.kwid+"</label></div>";
                 
                           
                           }); 
                           var prevDiv = document.getElementById('ljbxx');  
                   		   prevDiv.innerHTML =ht; 
                   
                    },
                    error : function(e) {
                           alert(e);
                    }
              });
                   
                   
                   
                   
                   
                 
            },
            error : function(e) {
                   alert(e);
            }
      });
		  });
		$('#gridSystemModal').modal({
			backdrop : 'static'
		});
	}


	

</script>
<%@ include file="/include.foot.jsp"%>
