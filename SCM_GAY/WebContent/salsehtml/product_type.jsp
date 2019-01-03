<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html>
	<head>
		<title>产品种类管理</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../script/common.js" ></script>
		<script type="text/javascript" src="../script/productDiv.js" ></script>
		<script type="text/javascript" src="../script/My97DatePicker/WdatePicker.js" ></script>
		<script type="text/javascript" src="../salse_script/salse_script.js" ></script>
		
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
				<td nowrap class="title1">销售管理 -- 产品种类管理</td>
			  </tr>
			</table>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			  <tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onclick="location.href='product_addtype.jsp'"><img src="../images/new.gif">新增</td>
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
			
			<div id="dataList">
				<table width="100%" border="0" align="center" cellspacing="1" class="c">
					<tr>
						<td class="title1">类别id</td>
						<td class="title1">类别名称</td>
						<td class="title1">类别描述</td>
						<td class="title1">操作</td>
					</tr>
					<c:forEach items="${alltypes}" var="e" >
					<tr>
						<td align="center">${e.product_id }</td>
						<td align="center">${e.product_typename}</td>
						<td align="center">${e.product_typecomment }</td>
						
						<td align="center">
							<input type="button" onclick="intoupdatetype(this)" value="修改" />
							<input type="button" onclick="delltype(this)" value="删除" />
						</td>
					</tr>
					</c:forEach>
					
					<tr style="display:none"><td colspan="10" name="detail"></td></tr>
				</table>
			</div>