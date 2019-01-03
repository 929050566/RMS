<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>月季产品库存报表</title>
		
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
				<td nowrap class="title1">业务报表 -- 月季产品库存报表</td>
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
			<form action="bus?">
					
						<input type="hidden" name="option" value="sto">
						月季：
						<input class="Wdate" type="text" name="sd" id="startDate"  onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
						-
						<input class="Wdate" type="text" name="ed" id="endDate"  onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
						
						<input  type="submit" value="查询"/>
					
					
			</form>	
				<table id="headTable" width="100%"  border="0" align="center" class="a1">
				  
					<tr style="display:none"><td colspan="10" name="detail"></td></tr>
					<tr>
						
						<td class="title1" colspan="5">产品总数量</td>
						<td class="title1" colspan="5">产品总库存数</td>
					</tr>
			
					<tr>
						<td align="center" colspan="4">20170621142653</td>
						<td align="center" colspan="3">被子</td>
						<td align="center" colspan="3">6</td>
						
					</tr>
				</table>
			
				<table width="100%"  border="0" align="center" cellspacing="1" id="detailTable">
				 
				  
				  
				  
				</table>
				<table width="100%"  border="0" align="center" cellspacing="1">
				  <tr>
					<td class="title2"></td>
				  </tr>
				</table>
				<br/>
				<div align="center" class="wrong" id="wrong" style="padding:10px;"></div>
				<table width="100%"  border="0" align="center" cellspacing="1" id="detailTable">
				  <tr><td colspan="3" class="title1" >产品库存报表明细</td></tr>
						<tr>
							<td align="center" class="title1">产品编号</td>
							<td align="center" class="title1">产品名称</td>
							<td align="center" class="title1">库存</td>
							
						</tr>
				  
				  
				  
				</table>
			</div>
		
		</div>
		



	</body>
</html>
