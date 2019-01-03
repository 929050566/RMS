<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>库存报表</title>
		
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
				<td nowrap class="title1">业务报表 -- 产品库存报表</td>
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
			<form action="InventoryServlet" method="post">
			<div class="query_div">
				<input class="Wdate" type="text" id="startDate"  name="startDate" onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
				<input type="hidden" name="option" value="select">
				<input class="Wdate" type="text" id="endDate" name="endDate"  onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
				<input type="submit" value="查询" onclick="goPage(1)"/>
			</div>
			</form>
			<div class="sale_total">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			 <c:if test="${!empty rep}" >
			 <tr>
				<td class="title1">产品总数</td>
				<td class="title1">产品总库存数</td>
			 </tr>
			 
			 <tr>
				<td align="center">${TotalLines}</td>
				<td align="center">${totalprices}</td>
			 </tr>
			 </c:if>
			 <tr style="display:none"><td colspan="10" name="detail"></td></tr>
			</table>
			</div>	
			<p>&nbsp;</p>
			<div id="dataList">
				<table width="100%" border="0" align="center" cellspacing="1" class="c">
					 <c:if test="${!empty rep}" >
					<tr>
						<td class="title1">产品编号</td>
						<td class="title1">产品名称</td>
						<td class="title1">库存数</td>
					
					</tr>
					</c:if>
				<c:forEach items="${rep}" var="report">
					<tr>
						
						<td align="center">${report.proID}</td>
						<td align="center">${report.proName}</td>
						<td align="center">${report.presentNum}</td>
					
						
					</tr>
					</c:forEach> 
					<c:if test="${empty rep }" >
					<tr>
						<td class="title1">产品编号</td>
						<td class="title1">产品名称</td>
						<td class="title1">时间</td>
						<td class="title1">库存数</td>
					
					</tr>
					
					</c:if>
					<c:forEach items="${inlist}" var="inlist">
					<tr>
						
						<td align="center">${inlist.proID}</td>
						<td align="center">${inlist.proName}</td>
						<td align="center">入库时间：${inlist.createname}</td>
						<td align="center">入库数量：${inlist.num}</td>
					
						
					</tr>
					</c:forEach>
					<c:forEach items="${outlist}" var="outlist">
					<tr>
						
						<td align="center">${outlist.proID}</td>
						<td align="center">${outlist.proName}</td>
						<td align="center">出库时间：${outlist.createname}</td>
						<td align="center">出库数量：${outlist.num}</td>
					
						
					</tr>
					</c:forEach>
					<tr style="display:none"><td colspan="10" name="detail"></td></tr>
			
				</table>

		<c:if test="${!empty rep}" >
				<div id="pageDiv" class="pageDiv">
				当前第<span id="currentPage">${page}</span>页
					<a id="start" href="InventoryServlet?option=showpurrepor&pages=1" class="font2">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				 	<a id="last" href="InventoryServlet?option=showpurrepor&pages=${page-1}" class="font2">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
            		<a id="next" href="InventoryServlet?option=showpurrepor&pages=${page+1}" class="font2">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
            		<a id="end" href="InventoryServlet?option=showpurrepor&pages=${totalpage}" class="font2">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
           			 共<span id="totalPage"> ${totalpage}</span>页&nbsp;&nbsp;&nbsp;<span >${TotalLines}</span>条记录
        		
				</div>
		</c:if>
			</div>
		</div>


	</body>
</html>