<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
		<title>产品添加单</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<script type="text/javascript" src="../salse_script/jquery-3.3.1.js"></script>
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../script/common.js" ></script>
		<script type="text/javascript" src="../script/productDiv.js" ></script>
		<script type="text/javascript" src="../script/My97DatePicker/WdatePicker.js" ></script>
		<script type="text/javascript" src="../salse_script/AddProType.js" ></script>
		
		
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
<body onload="init()">
		<div id="m">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0" >
			  <tr>
				<td nowrap class="title1">销售管理 -- 产品管理 -- 新增</td>
			  </tr>
			</table>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			  <tr>
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
		</div>
		<table width="100%"  border="0" align="center" cellspacing="1">
			<tr>
				<td align="right">产品名称</td>
				<td><input type="text" id="proname"></td>
			</tr>
			<tr>
				<td align="right">产品分类</td>
				<td>
					<select id="productType">
							<option value="">请选择</option>
							<c:forEach items="${alltypesforaddpro }" var="e">
							<option value="${e.product_typename}">${e.product_typename}</option>
							</c:forEach>
					</select>
				</td>
				
			</tr>
			<tr>
				<td align="right">销售价</td>
				<td><input type="text" id="sale"></td>
			</tr>
			<tr>
				<td align="right">数量单位</td>
				<td><input type="text" id="prounit" ></td>
			</tr>
			<tr>
				<td align="right">描述</td>
				<td><input type="text" id="procom"></td>
			</tr>
			<tr>
			<td align="right"><input type="button" value="添加" id="addproduct"></td>
			<td><input type="button" value="重置"></td>
			</tr>
		</table>
	</body>
</html>
