<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>业务报表</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../script/common.js" ></script>
		<script type="text/javascript" src="../script/productDiv.js" ></script>
		<script type="text/javascript" src="../script/My97DatePicker/WdatePicker.js" ></script>
		
		<style type="text/css">
			div.product{
				position: absolute;
				top:2px;
				left: 2px;
				width:100%;
				height: 98%;
				background-color: #fffffe;
			}
		</style>

		
	</head>

	<body>
		<div id="m">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
			  <tr>
				<td nowrap class="title1">业务报表 -- 月度销售报表</td>
			  </tr>
			</table>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			  <tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
				<td nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
			  </tr>
			</table>
			<form action="ReportSale" method="post">
				<div class="query_div">
					<input class="Wdate" type="text" id="startDate" name="startDate" onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
					-
					<input class="Wdate" type="text" id="endDate" name="endDate" onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
					<input type="hidden" name="option" value="select"/>					
					<input type="submit" value="查询" onclick="changemo()"/>
				</div>
			</form>
			<c:if test="${!empty allsale}" >
				<div class="sale_total">
					<table width="100%"  border="0" cellpadding="0" cellspacing="0">
					 <tr>
						<td class="title1">销售单总数</td>
						<td class="title1">已了结单数</td>
						<td class="title1">销售总金额</td>
						<td class="title1">已付款金额</td>
					 </tr>
					 <tr>
						<td align="center">${num}</td>
						<td align="center">${saleend}</td>
						<td align="center">${total}</td>
						<td align="center">${total-endpay}</td>
					 </tr>
					 <tr style="display:none"><td colspan="10" name="detail"></td></tr>
					</table>
				</div>	
			</c:if>
			<p>&nbsp;</p>
			<div id="dataList">
				<table width="100%" border="0" align="center" cellspacing="1" class="c">
					<tr>
						<td class="title1">销售单编号</td>
						<td class="title1">客户名称</td>
						<td class="title1">销售日期</td>
						<td class="title1">经手人</td>
						<td class="title1">销售单总金额</td>
						<td class="title1">未付款金额</td>
						<td class="title1">处理状态</td>
					</tr>
					<c:forEach items="${allsale}" var="e">
						<tr>
							<td align="center"><a href="pomain_detail.html">${e.saleid}</a></td>
							<td align="center">${e.customername}</td>
							<td align="center">${e.saletime}</td>
							<td align="center">${e.createsaleper}</td>
							<td align="center">${e.totalsaleprice}</td>
							<td align="center">${e.notpayprice}</td>
							<c:if test="${e.disposestate eq '1' }">
								<td value="1" align="center" >新增</td>
							</c:if>
							<c:if test="${e.disposestate eq '2' }">
								<td value="2" align="center">已收货</td>

							</c:if>	
							<c:if test="${e.disposestate eq '3' }">
								<td value="3" align="center">已付款</td>
							</c:if>
							<c:if test="${e.disposestate eq '4' }">
								<td value="4" align="center">已了结</td>
							</c:if>	
							<c:if test="${e.disposestate eq '5' }">
								<td value="5" align="center">已预付</td>
							</c:if>				
							
						</tr>
					</c:forEach>
					<c:forEach items="${timesale}" var="e">
						<tr>
							<td align="center"><a href="pomain_detail.html">${e.saleid}</a></td>
							<td align="center">${e.customername}</td>
							<td align="center">${e.saletime}</td>
							<td align="center">${e.createsaleper}</td>
							<td align="center">${e.totalsaleprice}</td>
							<td align="center">${e.notpayprice}</td>
							<c:if test="${e.disposestate eq '1' }">
								<td value="1" align="center" >新增</td>
							</c:if>
							<c:if test="${e.disposestate eq '2' }">
								<td value="2" align="center">已收货</td>

							</c:if>	
							<c:if test="${e.disposestate eq '3' }">
								<td value="3" align="center">已付款</td>
							</c:if>
							<c:if test="${e.disposestate eq '4' }">
								<td value="4" align="center">已了结</td>
							</c:if>	
							<c:if test="${e.disposestate eq '5' }">
								<td value="5" align="center">已预付</td>
							</c:if>	
							
						</tr>
					</c:forEach>
					
					<tr style="display:none"><td colspan="10" name="detail"></td></tr>
			
				</table>

				<c:if test="${!empty allsale}" >
					<div class="pageDiv">
						<a id="start" href="ReportSale?option=salereport&pages=1" class="font2">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a id="before" href="ReportSale?option=salereport&pages=${pages-1}" class="font2">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	            		<a id="next" href="ReportSale?option=salereport&pages=${pages+1}" class="font2">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<a id="end" href="ReportSale?option=salereport&pages=${totalpages}" class="font2">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
						
						当前第<td id="nowtime" class="styleC font2">${pages} / ${totalpages}</td>
	
						
					</div>
				</c:if>
			
			
			</div>
		</div>


	</body>
</html>