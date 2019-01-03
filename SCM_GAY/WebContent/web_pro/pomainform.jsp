<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>采购单</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../pomain/common.js" ></script>
		<script type="text/javascript" src="../pomain/productDiv.js" ></script>
		<script type="text/javascript" src="../pomain/My97DatePicker/WdatePicker.js" ></script>
		
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
				<td nowrap class="title1">采购单管理 -- 新添采购单 </td>
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
			<form action="Purchase" method="post" >
				<table id="headTable" width="100%"  border="0" align="center" class="a1">
				  <tr align="justify">
					<td>采购单编号</td>
					
					<td><input type="text" id="purchaseid" name="purchaseid" size="15" readonly/>
					  <span class="requred_symbol">*</span>
					</td>
					<td>创建时间</td>
					<td><input type="text" size="15" id="createTime" name="createTime" readonly="readonly"/>
					  <span class="requred_symbol">*</span>
					 </td>
					<td>供应商的名称</td>
					<td>
						<input type='text'  id='supplier' size='10' name='suppliername' readonly> <span class='LL'>
						<img src='../images/selectDate.gif'/ onClick='choice2Spxx(this.rowIndex)'></span>
						<span class="requred_symbol">*</span>
					  </td>
					<td>创建用户</td>
					<td><input name="createname" type="text" size="15" value="${createname }" readonly="readonly">
						<span class="requred_symbol">*</span></td>
				  </tr>
				  <tr align="justify">
					<td>附加费用</td>
					<td><input type="text" size="15" id="tipFee" value="0" name="extramoney" onchange="changeTotalPrice()"/>
						<span class="requred_symbol">*</span></td>
					<td>采购产品总价</td>
					<td><input type="text" size="15" id="productTotal" value="0" readonly="readonly" name="totalproprices"/></td>
					<td>付款方式</td>
					<td>
						<select id="payType" name="paystate" onchange="chgPayType(this)">
							<option value="1" >货到付款</option>
							<option value="2" >款到发货</option>
							<option value="3" >预付款到发货</option>
						</select>
					</td>
					<td>最低预付款金额</td>
					<td><input name="advanceprice"  id="prePayFee" value="0" type="text" size="15" /></td>
				   </tr>
				  <tr align="justify">
					<td>采购单总价</td>
					<td><input type="text" id="remark"  name="totalprices" readonly="readonly"/></td>
					<td>备注</td>
					<td colspan="5"><input type="text" id="remark" size="100" name="comment"/></td>
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
					<td class="toolbar">&nbsp;</td>
				  </tr>
				  
				  
				  
				</table>
				<table width="100%"  border="0" align="center" cellspacing="1">
				  <tr>
					<td class="title2"></td>
				  </tr>
				</table>
				<br/>
				<div align="center" class="wrong" id="wrong" style="padding:10px;"></div>
				<div align="center">
					<input type="button" id="mx" value="增加明细" onclick="addItem()"/>
					<input type="hidden" name="option" value="purchaseadd">
					<input type="submit" id="bc" value="保存" onclick="return savePomain()"/>
					<input type="button" id="gb" value="返回" onclick="backPomainNew()"/>
				</div>
				<script type="text/javascript">
					function savePomain(){
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
				</script>
			</div>
		</form>
		<div id="productDiv" style="visibility: hidden;" class="product">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			  <tr>
				<td width="30px" nowrap="nowrap"="nowrap="nowrap"" class="toolbar">&nbsp;</td>
				<td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="choiceAnonymous('productDiv')"><img src="../images/confirm.gif">确定</td>
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
			   <c:forEach items="${storage}" var="storage">
			  <tr onClick="selectItem(this)" onMouseOver="OMO1(event)" onDblClick="choice(1)" align="center">
				<td>&nbsp;</td>
				<td>${storage.proID}</td>
				<td>${storage.proName}</td>
				<td>${storage.proUnit}</td>
			  </tr>
			</c:forEach>
			   <tr>
				<td class="title2"></td>
			  </tr>
			</table>
		</div><div id="suppDiv" style="visibility: hidden;" class="product">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			  <tr>
				<td width="30px" nowrap="nowrap"="nowrap="nowrap"" class="toolbar">&nbsp;</td>
				<td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="choice2Anonymous('suppDiv')"><img src="../images/confirm.gif">确定</td>
				<td width="20px" nowrap="nowrap" class="toolbar">|</td>
				<td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="hidden2Div()"><img src="../images/cancel.gif">取消</td>
				<td align="center" valign="middle" nowrap="nowrap" class="toolbar">&nbsp;</td>
			  </tr>
			</table>
			<table width="100%"  border="0" align="center" cellspacing="1" class="a1" id="supTable">
			  <tr>
				<td class="title1">选择</td>
				<td class="title1">供应商编码</td>
				<td class="title1">供应商名称</td>
			  </tr>
			  <c:forEach items="${suppliers}" var="supplier">
			  <tr onClick="selectItem2(this)" onMouseOver="OMO1(event)" onDblClick="choice(1)" align="center">
				<td>&nbsp;</td>
				<td>${supplier.supplieid}</td>
				<td>${supplier.suppliername}</td>
			  </tr>
			  </c:forEach>
			   <tr>
				<td class="title2"></td>
			  </tr>
			</table>
		</div>
	</body>
</html>	