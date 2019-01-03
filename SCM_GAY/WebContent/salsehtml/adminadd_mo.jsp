<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<title>用户添加单</title>
		
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

	<body onload="init()">
		<div id="m">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
			  <tr>
				<td nowrap class="title1">销售管理 -- 客户管理 -- 新增</td>
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
		<table width="100%" border="0" align="center" cellspacing="1" class="c">
			<tr>
				<td align="right">用户编号</td>
				<td><input type="text" ></td>
			</tr>
			<tr>
				<td align="right">用户名称</td>
				<td><input type="text" ></td>
			</tr>
			<tr>
				<td align="right">登陆密码</td>
				<td><input type="text" ></td>
			</tr>
			<tr>
				<td align="right">联系人</td>
				<td><input type="text" ></td>
			</tr>
			<tr>
				<td align="right">地址</td>
				<td><input type="text" ></td>
			</tr>
			<tr>
				<td align="right">邮政编码</td>
				<td><input type="text" ></td>
			</tr>
			<tr>
				<td align="right">注册日期</td>
				<td><input type="text" ></td>
			</tr>
			<tr>
				<td align="right">电话</td>
				<td><input type="text" ></td>
			</tr>
			<tr>
				<td align="right">传真</td>
				<td><input type="text" ></td>
			</tr>
			<tr>
				<td align="right"><input type="button" value="添加用户"></td>
				<td><input type="button" value="重置"></td>
			</tr>
		</table>
	</body>
</html>