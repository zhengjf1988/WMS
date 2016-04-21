<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 入库页面 -->
<div class="row">
	<form action="" class="form-horizontal" method="post">
		<div class="row" style="padding-top: 10px">
			<div class="col-lg-2"></div>
			<div class="col-lg-4">
				<div class="input-group">
					<input type="text" maxlength="30" style="width: 400px;" class="form-control" placeholder="请输入关键字..." name="seachUserName" value="${item.username}">
				</div>
				<!-- /input-group -->
			</div>
			<div class="col-lg-2">
				<div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
					<input class="form-control" size="16" type="text" value="${item.owner }" readonly id="dateTo" name="dateTo" placeholder="开始时间...">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-remove"></span>
					</span>
				</div>
			</div>
			<div class="col-lg-2">
				<div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
					<input class="form-control" size="16" type="text" value="${item.owner }" readonly id="dateTo" name="dateTo" placeholder="结束时间...">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-remove"></span>
					</span>
				</div>
			</div>
			<div class="col-lg-2">
				<div class="input-group">
					<input type="submit" value="查询" class="btn">
				</div>
			</div>
		</div>
	</form>
	<div class="table-responsive" style="overflow:scroll;height: 300px;">
		<table class="table table-bordered table-hover">
			<thead>
				<tr class="success">
					<td class="text-center">序号</td>
					<td class="text-center">客户名称</td>
					<td class="text-center">零件名称</td>
					<td class="text-center">提货时间</td>
					<td class="text-center">零件数量</td>
					<td class="text-center">实际数量</td>
					<td class="text-center">操作</td>
				</tr>
			</thead>
			<%-- <tbody>
				<c:forEach items="${list}" var="item" varStatus="staturs">
					<tr>
						<td>${staturs.index+1}</td>
						<td>
							<c:out value="${item.title}" />
						</td>
						<td>
							<c:out value="${item.content}" />
						</td>
						<td>
							<c:out value="${item.creatTime}" />
						</td>
						<td>
							<c:out value="${item.owner}" />
						</td>
						<td>
							<c:out value="${item.owner}" />
						</td>
						<td>
							<a onClick="linkPage('${item.id}')">编辑</a>
							||
							<a onclick="openMassageModal('${item.id}')">删除</a>
							||
							<a onclick="openMassageModal('${item.id}')">提货</a>
						</td>
					</tr>
				</c:forEach>
			</tbody> --%>
		</table>
	</div>
	<ul class="pagination">
		<li>
			<a href="#">上一页</a>
		</li>
		<li>
			<a href="#">1</a>
		</li>
		<li>
			<a href="#">2</a>
		</li>
		<li>
			<a href="#">3</a>
		</li>
		<li>
			<a href="#">4</a>
		</li>
		<li>
			<a href="#">5</a>
		</li>
		<li>
			<a href="#">下一页</a>
		</li>
	</ul>
</div>
