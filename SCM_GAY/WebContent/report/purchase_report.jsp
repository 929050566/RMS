<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>新添采购单</title>
		
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
		<script type="text/javascript">
			function goPage(){
				document.getElementById("pageDiv").style.display="none";
				document.getElementById("purchase_total").style.display="none";
			}
		</script>
		
	</head>

	<body>
		<div id="m">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
			  <tr>
				<td nowrap class="title1">业务报表 -- 月度采购报表</td>
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
			<form action="reportServlet" method="post">
			<div class="query_div">
				<input class="Wdate" type="text" name="startDate" id="startDate"  onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
				<input type="hidden" name="option" value="select">
				<input class="Wdate" type="text" name="endDate" id="endDate"  onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
				<input type="submit" value="查询" onclick="goPage"/>
			</div>
			</form>
			<div id="purchase_total"  class="purchase_total">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			 <c:if test="${!empty report}" >
			 <tr>
				<td class="title1">采购单总数</td>
				<td class="title1">已了结数</td>
				<td class="title1">采购单总金额</td>
				<td class="title1">已付款金额</td>
			 </tr>
			
			 <tr>
				<td align="center">${TotalLines}</td>
				<td align="center">${TotalLinesBydisposestate}</td>
				<td align="center">${totalprices}</td>
				<td align="center">${total}</td>
			 </tr>
			</c:if>
			 <tr style="display:none"><td colspan="10" name="detail"></td></tr>
			</table>
			</div>	
			<p>&nbsp;</p>
			<div id="dataList">
				<table width="100%" border="0" align="center" cellspacing="1" class="c">
					<tr>
						<td class="title1">采购单编号</td>
						<td class="title1">供应商名称</td>
						<td class="title1">创建日期</td>
						<td class="title1">创建用户</td>
						<td class="title1">采购单总金额</td>
						<td class="title1">未付款金额</td>
						<td class="title1">付款方式</td>
						<td class="title1">最低预付款金额</td>
						<td class="title1">采购单状态</td>
					</tr>
					<c:forEach items="${report}" var="report">
					<tr>
						<td align="center"><a href="pomain_detail.html">${report.purchaseid}</a></td>
						<td align="center">${report.suppliername}</td>
						<td align="center">${report.createtime}</td>
						<td align="center">${report.createname}</td>
						<td align="center">${report.totalprices}</td>
						<td align="center">${report.nopuy}</td>
						
						
						<c:if test="${report.paystate eq '1' }">
								<td value="1" align="center" >货到付款</td>
							</c:if>
							<c:if test="${repor.paystate eq '2' }">
								<td value="2" align="center">款到发货</td>

							</c:if>	
							<c:if test="${repor.paystate eq '3' }">
								<td value="3" align="center">预付款到发货</td>
							</c:if>

						
						
						<td align="center">${report.advanceprice}</td>
						
						<c:if test="${report.disposestate eq '1' }">
								<td value="1" align="center" >新增</td>
							</c:if>
						
						<c:if test="${report.disposestate eq '2' }">
								<td value="1" align="center" >已收货</td>
							</c:if>
						<c:if test="${report.disposestate eq '3' }">
								<td value="1" align="center" >已付款</td>
							</c:if>
						<c:if test="${report.disposestate eq '4' }">
								<td value="1" align="center" >已了结</td>
							</c:if>
						<c:if test="${report.disposestate eq '5' }">
								<td value="1" align="center" >已预付</td>
							</c:if>	
					</tr>
					</c:forEach>
					
					<c:forEach items="${reports}" var="report">
					<tr>
						<td align="center"><a href="pomain_detail.html">${report.purchaseid}</a></td>
						<td align="center">${report.suppliername}</td>
						<td align="center">${report.createtime}</td>
						<td align="center">${report.createname}</td>
						<td align="center">${report.totalprices}</td>
						<td align="center">${report.nopuy}</td>
						
						<c:if test="${report.paystate eq '1' }">
								<td value="1" align="center" >货到付款</td>
							</c:if>
							<c:if test="${report.paystate eq '2' }">
								<td value="2" align="center">款到发货</td>

							</c:if>	
							<c:if test="${report.paystate eq '3' }">
								<td value="3" align="center">预付款到发货</td>
							</c:if>

						
						
						<td align="center">${report.advanceprice}</td>
						<c:if test="${report.disposestate eq '1' }">
								<td value="1" align="center" >新增</td>
							</c:if>
						
						<c:if test="${report.disposestate eq '2' }">
								<td value="1" align="center" >已收货</td>
							</c:if>
						<c:if test="${report.disposestate eq '3' }">
								<td value="1" align="center" >已付款</td>
							</c:if>
						<c:if test="${report.disposestate eq '4' }">
								<td value="1" align="center" >已了结</td>
							</c:if>
						<c:if test="${report.disposestate eq '5' }">
								<td value="1" align="center" >已预付</td>
							</c:if>	
						
					</tr>
					</c:forEach>
					<tr style="display:none"><td colspan="10" name="detail"></td></tr>
			
				</table>

			 <c:if test="${!empty report}" >
				<div id="pageDiv" class="pageDiv">
				当前第<span id="currentPage">${pages}</span>页
					<a id="start" href="reportServlet?option=showpurrepor&pages=1" class="font2">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				 	<a id="last" href="reportServlet?option=showpurrepor&pages=${pages-1}" class="font2">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
            		<a id="next" href="reportServlet?option=showpurrepor&pages=${pages+1}" class="font2">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
            		<a id="end" href="reportServlet?option=showpurrepor&pages=${totalpages}" class="font2">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
           			 共<span id="totalPage"> ${totalpages}</span>页&nbsp;&nbsp;&nbsp;<span >${TotalLines}</span>条记录
        		</table>
				</div>
			</c:if>
			
			</div>
		</div>


	</body>
</html>