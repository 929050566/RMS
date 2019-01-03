<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>库存更新</title>
		
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
				<td nowrap class="title1">库存管理 -- 库存变更记录表</td>
			  </tr>
			</table>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			 <tr>
				<td nowrap="" class="toolbar">&nbsp;</td>
				<td width="60px" nowrap="" class="toolbar" onmouseover="OMO(event)" onmouseout="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap="" class="toolbar"></td>
				<td width="60px" nowrap="" class="P" onmouseover="OMO(event)" onmouseout="OMOU(event)"></td>
				<td width="20px" nowrap="" class="toolbar"></td>
				<td width="80px" nowrap="" class="P" onmouseover="OMO(event)" onmouseout="OMOU(event)"></td>
				<td width="20px" nowrap="" class="toolbar"></td>
				<td width="60px" nowrap="" class="toolbar" onmouseover="OMO(event)" onmouseout="OMOU(event)"></td>
				<td width="20px" nowrap="" class="toolbar"></td>
			  </tr>
			</table>
			
				
			<div id="dataList">
				<table width="100%" border="0" align="center" cellspacing="1" class="c">
					<th colspan="10" style="align:center">入库登记表 </th>
					<tr>
						<td class="title1" colspan="2">入库时间</td>
						<td class="title1" colspan="2">相关采购单号</td>
						<td class="title1" colspan="2">入库经手人</td>
						<td class="title1" colspan="2">入库数量</td>
						<td class="title1" colspan="2">入库类型</td>
						
					</tr>
			
				<c:forEach items="${list}" var="in">
                  <tr >
                    <td align="center" colspan="2">${in.inStorageDate}</td>
                    <td align="center" colspan="2">${in.purchaseid}</td>
                    <td align="center" colspan="2">${in.inoHandle}</td>
                    <td align="center" colspan="2">${in.inNum}</td>
                    <td align="center" colspan="2">${in.inState}</td>
                  </tr>
                 </c:forEach>
					<tr style="display:none"><td colspan="10" name="detail"></td></tr>
				
				</table	>
				
				
				<table width="100%" border="0" align="center" cellspacing="1" class="c">
					<th colspan="10" style="align:center">出库登记表 </th>
					<tr>
						<td class="title1" colspan="2">出库时间</td>
						<td class="title1" colspan="2">相关销售单号</td>
						<td class="title1" colspan="2">出库经手人</td>
						<td class="title1" colspan="2">出库数量</td>
						<td class="title1" colspan="2">出库类型</td>
					</tr>
				<c:forEach items="${olist}" var="o">
                  <tr >
                    <td align="center" colspan="2">${o.outStorageDate}</td>
                    <td align="center" colspan="2">${o.salebillid}</td>
                    <td align="center" colspan="2">${o.outHandle}</td>
                    <td align="center" colspan="2">${o.outNum}</td>
                    <td align="center" colspan="2">${o.outState}</td>
                  </tr>
                </c:forEach>
				<tr style="display:none"><td colspan="10" name="detail"></td></tr>
			
				</table>


				
			
			
			</div>
		</div>


	</body>
</html>