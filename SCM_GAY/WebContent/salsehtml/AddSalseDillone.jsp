<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html>
	<head>
		<title>销售单</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../script/common.js" ></script>
		<script type="text/javascript" src="../salse_script/productDiv.js" ></script>
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

	<body onload="init()">
		<div id="m">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
			  <tr>
				<td nowrap class="title1">销售管理 -- 新添销售单 -- 新增</td>
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
			<form action="SaleManageServlet" method="post"> 
				<input type="hidden" name="option" value="addsale"/>
				<table id="headTable" width="100%"  border="0" align="center" class="a1">
				  <tr align="justify">
					<td>销售单编号</td>
					
					<td><input type="text" id="poId" name="poId" value="${time_id}" size="15" readonly/>
					  <span class="requred_symbol">*</span>
					</td>
					<td>创建时间</td>
					<td><input type="text" size="15" id="createTime" value="${nowtime}" readonly="readonly" readonly/>
					  <span class="requred_symbol">*</span>
					 </td>
					<td>客户名称</td>
					<td>
						<input type="text" size="15" value="" id="vName" name="vName" />
						<span class="requred_symbol">*</span>
					  </td>
					<td>创建用户</td>
					<td><input name="textfield" type="text" size="15" value="${createname }" id="createper" readonly="readonly">
						<span class="requred_symbol">*</span></td>
				  </tr>
				  <tr align="justify">
					<td>附加费用</td>
					<td><input type="text" size="15" id="tipFee" name="extramoney" onchange="changeTotalPrice()" value="0"/>
						<span class="requred_symbol">*</span></td>
					<td>产品总价</td>
					<td><input type="text" size="15" id="productTotal" name="totalproprices" value="0" readonly/></td>
					<td>付款方式</td>
					<td>
						<select id="payType" name="payType" onchange="chgPayType(this)">
							<option value="1"  >货到付款</option>
							<option value="2" >款到发货</option>
							<option value="3" >预付款到发货</option>
						</select>
					</td>
					<td>最低预付款金额</td>
					<td><input name="text"  id="prePayFee" name="prePayFee" value="0" type="text" size="15" /></td>
				   </tr>
				  <tr align="justify">
				  	<td>销售总价</td>
				  	<td><input type="text" name="totalprices" value="0" readonly /></td>
					<td>备注</td>
					<td colspan="7"><input type="text" id="remark" name="remark" size="60" value=""/></td>
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
					<td class="toolbar">销售单价</td>
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
					<input type="submit" id="bc" value="保存"  onclick="return checkSubmit()"/>
					<input type="button" id="gb" value="返回" onclick="backPomainNew()"/>
				</div>
			</div>
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
			</script>
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
				<td class="title1">商品单位</td>
			  </tr>
			  <c:forEach items="${allpro}" var="e">
				  <tr onClick="selectItem(this)" onMouseOver="OMO1(event)" onDblClick="choice(1)" align="center">
					<td>&nbsp;</td>
					<td>${e.product_id}</td>
					<td>${e.product_name}</td>
					<td>${e.product_unit}</td>
				  </tr>
			  </c:forEach>
			</table>
		</div>
		



	</body>
</html>
