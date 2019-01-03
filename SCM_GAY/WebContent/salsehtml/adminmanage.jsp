<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<title>用户管理</title>
		
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
				<td nowrap class="title1">销售管理 -- 用户管理</td>
			  </tr>
			</table>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			  <tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onclick="location.href='adminadd_mo.html'"><img src="../images/new.gif">新增</td>
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
			<div class="query_div">
				客户编号：<input type="text" id="adminId" />
				客户名称：<input type="text" id="adminName" />
				<input type="button" value="查询" onclick="goPage(1)"/>
			</div>
			
			<div id="dataList">
				<table width="100%" border="0" align="center" cellspacing="1" class="c">
					<tr>
						<td class="title1">客户编号</td>
						<td class="title1">客户名称</td>
						<td class="title1">联系人</td>
						<td class="title1">地址</td>
						<td class="title1">邮政编码</td>
						<td class="title1">注册日期</td>
						<td class="title1">电话</td>
						<td class="title1">传真</td>
						<td class="title1">操作</td>
					</tr>
			
					<tr>
						<td align="center">20170621142653</a></td>
						<td align="center">京东商城</td>
						<td align="center">lisi</td>
						<td align="center">0.0</td>
						<td align="center">6.0</td>
						<td align="center">6.0</td>
						<td align="center">货到付款</td>
						<td align="center">0.0</td>
						
						<td align="center">
							<a href="javascript:void(0)" >修改</a>
							<a href="javascript:void(0)" onclick="return checkDel('确定要删除该类别吗？')" >删除</a>
						</td>
					</tr>
					<tr style="display:none"><td colspan="10" name="detail"></td></tr>
			
					<tr>
						<td align="center">20170622142425</a></td>
						<td align="center">京东商城</td>
						<td align="center">lisi</td>
						<td align="center">12.0</td>
						<td align="center">72.0</td>
						<td align="center">60.0</td>
						<td align="center">货到付款</td>
						<td align="center">0.0</td>
						
						<td align="center">
							<a href="javascript:void(0)" >修改</a>
							<a href="javascript:void(0)" onclick="return checkDel('确定要删除该类别吗？')" >删除</a>
						</td>
					</tr>
				<tr style="display:none"><td colspan="10" name="detail"></td></tr>
			
				</table>


				<div class="pageDiv">
					当前第<span id="currentPage">1</span>页
					
						<input type="button" value="首页" disabled="disabled"/>
						<input type="button" value="上一页" disabled="disabled"/>
					
					
					
					
						<input type="button" value="下一页" disabled="disabled"/>
						<input type="button" value="末页" disabled="disabled"/>
					
					共2页 3条记录
				</div>
			
			
			</div>
		</div>


	</body>
</html>