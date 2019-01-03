<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>月季入库报表</title>
		
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
				<td nowrap class="title1">业务报表 -- 月季入库报表</td>
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
			
				<form action="bus?">
					
						<input type="hidden" name="option" value="into">
						月季：
						<input class="Wdate" type="text" name="sd" id="startDate"  onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
						-
						<input class="Wdate" type="text" name="ed" id="endDate"  onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
						
						<input  type="submit" value="查询"/>
					
					
			</form>	
			<div id="dataList">
				<table width="100%" border="0" align="center" cellspacing="1" class="c">
					<tr style="display:none"><td colspan="10" name="detail"></td></tr>
					
					<tr style="display:none"><td colspan="10" name="detail"></td></tr>
					<tr>
						<td class="title1" colspan="4">入库单据数</td>
						<td class="title1" colspan="3">产品总数量</td>
						<td class="title1" colspan="3">入库产品总金额</td>
					</tr>
			
					<tr>
						<td align="center" colspan="4">${rdnum}</td>
						<td align="center" colspan="3">${nn}</td>
						<td align="center" colspan="3">${q}</td>
						
					</tr>
					<tr style="display:none"><td colspan="10" name="detail"></td></tr>
			
					
				
			
				</table>
				<div id="dataList" style="margin-top:50">
					<table width="100%" border="0" align="center" cellspacing="1" class="c">
						<tr><td colspan="6" class="title1" >入库报表明细</td></tr>
						<tr>
							<td align="center">采购单号</td>
							<td align="center">入库日期</td>
							<td align="center">产品编号</td>
							<td align="center">产品名称</td>
							<td align="center">产品数</td>
							<td align="center">产品总金额</td>
						</tr>
					<c:forEach items="${rlist}" var="c">
                  
                  	<tr >
						<td align="center">${c.purchaseid}</td>
						<td align="center">${c.inStorageDate}</td>
						<td align="center">${c.proid}</td>
						<td align="center">${c.proname}</td>
						<td align="center">${c.pronum}</td>
						<td align="center">${c.totalprice}</td>
						
					 </tr>
                 
                </c:forEach>
					</table>
				</div>

				
			
			
			</div>
		</div>


	</body>
</html>