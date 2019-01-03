<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
		<title>销售单详情</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../script/common.js" ></script>
		<script type="text/javascript" src="productDiv.js" ></script>
		<script type="text/javascript" src="../script/My97DatePicker/WdatePicker.js" ></script>
		<script type="text/javascript" src="../script/jquery-1.8.1.min.js" ></script>	
	</head>

	<body onload="init();editAdvanPrice();setSerial();">
		<div id="m">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
			  <tr>
				<td nowrap class="title1">销售管理 -- 销售单查询</td>
			  </tr>
			</table>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
		  <tr>
		    <td width="30px" nowrap class="toolbar">&nbsp;</td>
			<td nowrap class="toolbar">&nbsp;</td>
		  </tr>
		</table>
		<form action="SaleManageServlet" method="post" >
		<table id="headTable" width="100%"  border="0" align="center" class="a1">
		  <tr align="justify">
		    <td>采购单编号</td>
		    <td><input type="text" name="saleid" value="${saleAllInfo.saleid }" readonly="readonly"></td>
		    <td>创建时间</td>
		    <td><input type="text" name="createtime" value="${saleAllInfo.createtime }" readonly="readonly"></td>
		    <td>客户的名称</td>
		    <td><input type="text" name="customername" value="${saleAllInfo.customername }" readonly="readonly"></td>
		    <td>创建用户</td>
		    <td><input type="text" name="createname" value="${saleAllInfo.createname }" readonly="readonly"></td>
		  </tr>
		  <tr align="justify">
		    <td>附加费用</td>
		    <td><input type="text" name="extramoney" value="${saleAllInfo.extramoney }" onchange="changeTotalPrice();"><c:if test="${edit eq 'yes' }">(可修改)</c:if></td>
		    <td>采购产品总价</td>
		    <td><input type="text" name="totalproprices" value="${saleAllInfo.totalproprices }" onchange="changeTotalPrice();" readonly="readonly"></td>
		    <td>付款方式</td>
		    <td>
		    	<select name="paystate" onchange="editAdvanPrice()">
					<c:if test="${saleAllInfo.paystate eq '1' }">
						<option value="1" selected="selected">货到付款</option>
						<option value="2">款到发货</option>
						<option value="3">预付款到发货</option>
					</c:if>
					<c:if test="${saleAllInfo.paystate eq '2' }">
						<option value="1" >货到付款</option>
						<option value="2" selected="selected">款到发货</option>
						<option value="3">预付款到发货</option>
					</c:if>						
					<c:if test="${saleAllInfo.paystate eq '3' }">
						<option value="1" >货到付款</option>
						<option value="2" >款到发货</option>
						<option value="3" selected="selected">预付款到发货</option>
					</c:if>	
				</select>
					<c:if test="${edit eq 'yes' }">(可修改)</c:if>	
		
		    </td>
		    <td>最低预付款金额</td>
		    <td><input type="text" name="advanceprice" value="${saleAllInfo.advanceprice }" readonly="readonly"></td>
		  </tr>
		  <tr align="justify">
		  	<td>采购单总价</td>
		    <td><input type="text" name="totalprices" value="${saleAllInfo.totalprices }" readonly="readonly"></td>
		    <td colspan="6">&nbsp;</td>
		  </tr>
		  <tr align="justify">
		    <td>处理状态</td>
		    <td>
	    		<select name="disposestate">
					<c:if test="${ saleAllInfo.disposestate eq '1'}">
						<option value="1" selected="selected">新增</option>
						<option value="2">已收货</option>
						<option value="3">已付款</option>
						<option value="4">已了结</option>
						<option value="5">已预付</option>						
					</c:if>
					<c:if test="${ saleAllInfo.disposestate eq '2'}">
						<option value="1" >新增</option>
						<option value="2" selected="selected">已收货</option>
						<option value="3">已付款</option>
						<option value="4">已了结</option>
						<option value="5">已预付</option>						
					</c:if>
					<c:if test="${ saleAllInfo.disposestate eq '3'}">
						<option value="1" >新增</option>
						<option value="2">已收货</option>
						<option value="3" selected="selected">已付款</option>
						<option value="4">已了结</option>
						<option value="5">已预付</option>						
					</c:if>
					<c:if test="${ saleAllInfo.disposestate eq '4'}">
						<option value="1" >新增</option>
						<option value="2">已收货</option>
						<option value="3">已付款</option>
						<option value="4" selected="selected">已了结</option>
						<option value="5">已预付</option>						
					</c:if>
					<c:if test="${ saleAllInfo.disposestate eq '5'}">
						<option value="1" >新增</option>
						<option value="2">已收货</option>
						<option value="3">已付款</option>
						<option value="4">已了结</option>
						<option value="5" selected="selected">已预付</option>						
					</c:if>
				</select>
				<c:if test="${edit eq 'yes' }">(可修改)</c:if>
			</td>
		    <td>入库登记时间</td>
		    <td><input type="text" name="outStorageDate" value="${saleAllInfo.outStorageDate }" readonly="readonly"></td>
		    <td>入库登记用户</td>
		    <td><input type="text" name="outHandle" value="${saleAllInfo.outHandle }" readonly="readonly"></td>
		    <td>付款登记时间</td>
		    <td><input type="text" name="payDate" value="${saleAllInfo.payDate }" readonly="readonly"> </td>
		  </tr>
		  <tr align="justify">
		    <td>付款登记用户</td>
		    <td><input type="text" name="payHandle" value="${saleAllInfo.payHandle }" readonly="readonly"></td>
		    <td>预付登记时间</td>
		    <td><input type="text" name="advanceDate" value="${saleAllInfo.advanceDate }" readonly="readonly"></td>
		    <td>预付登记用户</td>
		    <td><input type="text" name="advanceHandle" value="${saleAllInfo.advanceHandle }" readonly="readonly"></td>
		    <td>了结时间</td>
		    <td><input type="text" name="closeDate" value="${saleAllInfo.closeDate }" readonly="readonly"></td>
		  </tr>
		  <tr align="justify">
		    <td>了结用户</td>
		    <td><input type="text" name="closeUser" value="${saleAllInfo.closeUser }" readonly="readonly"></td>
		    <td>备注</td>
		    <td colspan="5"><input type="text" name="comment"  size="100" value="${saleAllInfo.comment }"><c:if test="${edit eq 'yes' }">(可修改)</c:if></td>
		   </tr>
		  <tr>
		  	<td class="title2"></td>
		  </tr>
		</table>
	
		<table width="100%"  border="0" align="center" cellspacing="1" id="detailTable">
		  <tr>
		    <td class="toolbar">序号 </td>
		    <td class="toolbar">产品编号 </td>
		    <td class="toolbar">产品名称 </td>
		    <td class="toolbar">数量单位 </td>
		    <td class="toolbar">产品数量 </td>
		    <td class="toolbar">采购单价</td>
		    <td class="toolbar">明细总价</td>
		    <td class="toolbar">删除</td>
		  </tr>
		  
		  <c:forEach items="${ saleDetList}" var="saleDet">
	  	  <tr align="center">
	  	  	<td><span>&nbsp;</span></td>
	  		<td><input type="text" name="proid" size="10" value="${saleDet.product_id}" readonly="readonly"><span class="LL"><image src="../images/selectDate.gif" onClick="choiceSpxxToDetail(this)"/></span></td>
	  		<td><input type="text" name="proname" size="15" value="${saleDet.product_name}" readonly="readonly"></td>
			<td><input type="text" name="prounit" size="10" value="${saleDet.product_unit}" readonly="readonly"></td>
			<td><input type="text"  size="10" name="pronum" value="${saleDet.product_quantity}" onchange="changePrice(this)"></td> 
			<td><input type="text"  size="10" name="unitprice" value="${saleDet.product_unitprice}" onchange="changePrice(this)"></td> 
			<td><input type="text"  size="10" name="totalprice" value="${saleDet.product_dettotalprice}" readonly="readonly"></td>
			<td><image src="../images/delete.gif" class="LL" onclick="delItem(this);"></td>
				<input type="hidden" name="detid" value="${saleDet.detid }">
	  	  </tr>
		 </c:forEach>
		 <script type="text/javascript">
			function delItem(cell){
			  	var i=cell.parentNode.parentNode.rowIndex;
			    document.getElementById('detailTable').deleteRow(i);
			}
		</script>	
	 	<table width="100%"  border="0" align="center" cellspacing="1">
	  	<tr>
		    <td class="title2"></td>
		  </tr>
		</table>
		</table>
			<table width="100%"  border="0" align="center" cellspacing="1">
			  <tr>
				<td class="title2"></td>
			  </tr>
			</table>
			<br/>
			<div align="center" class="wrong" id="wrong" style="padding:10px;"></div>
			<c:if test="${edit eq 'yes' }">
				<div align="center">
					<input type="button" id="mx" value="增加明细" onclick="addItem()"/>
					<input type="submit" id="bc" value="保存" onclick="return checkSubmit()"/>
					<input type="button" id="gb" value="返回" onclick="backPomainNew()"/>
					<input type="hidden" name="option" value="updateDet">
				</div>			
			</c:if>
			<c:if test="${edit eq 'no' }">
				<div align="center">
					<a href="${url }">返回</a>
				</div>			
			</c:if>
			<script type="text/javascript">
				function checkSubmit(){
					if(confirm("是否提交？")){
						var len = document.getElementsByName("proid").length;
						if(len > 0){
							return true;
						}else{
							alert("请至少添加一个明细");
							return false;
						}
						
					}else{
						return false;
					}
				}
				function backPomainNew(){
					location.href="SaleManageServlet?option=querySale";
				}
			</script>
		</table>
		</form>
		</div>
	
		<div id="productDiv" style="visibility: hidden;" class="product">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			  <tr>
				<td width="30px" nowrap="nowrap"="nowrap="nowrap"" class="toolbar">&nbsp;</td>
				<td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="choiceAnonymousToDetail('productDiv')"><img src="../images/confirm.gif">确定</td>
				<td width="20px" nowrap="nowrap" class="toolbar">|</td>
				<td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="hiddenDiv()"><img src="../images/cancel.gif">取消</td>
				<td align="center" valign="middle" nowrap="nowrap" class="toolbar">&nbsp;</td>
			  </tr>
			</table>
			<table width="100%"  border="0" align="center" cellspacing="1" class="a1" id="spxxTable">
			  <tr>
				<td class="title1">选择</td>
				<td class="title1">商品编码</td>
				<td class="title1">商品名称</td>
				<td class="title1">数量单位</td>
			  </tr>
			  <c:forEach items="${storageList }" var="storage">
			  	 <tr onClick="selectItem(this)" onMouseOver="OMO1(event)" onDblClick="choice(1)" align="center">
				<td>&nbsp;</td>
				<td>${storage.proID}</td>
				<td>${ storage.proName}</td>
				<td>${ storage.proUnit}</td>
			  </tr>
			  </c:forEach>
			   <tr>
				<td class="title2"></td>
			  </tr>
			</table>
		</div>


	</body>
</html>
