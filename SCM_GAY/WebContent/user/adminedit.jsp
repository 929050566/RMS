<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
		<title>用户管理</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../script/common.js" ></script>
		<script type="text/javascript" src="../script/productDiv.js" ></script>
		<script type="text/javascript" src="../script/My97DatePicker/WdatePicker.js" ></script>
		<script type="text/javascript" src="../script/jquery-1.8.1.min.js" ></script>
	</head>

	<body>
	<div id="m">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
	  <tr>
		<td nowrap class="title1">您的位置：系统管理－－用户管理</td>
	  </tr>
	</table>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
		<td width="30px" nowrap class="toolbar">&nbsp;</td>
		<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"></td>
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

	<div id="m">
	<form action="Admins" method="post">

	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
	  <tr>
		<td class="title1">信息</td>
		<td class="title1">数据</td>
		<td class="title1">提示</td>
		</tr>
	  <tr>
		<td align="center">用户名</td>
		<td align="center"><input type="text" name="account" value="${admins.account}" readonly="readonly" /></td>
		<td align="center"><p style="color: red">不可跟改</p></td>
	</tr>
	 <tr>
		<td align="center">真是姓名</td>
		<td align="center"><input type="text" name="realname" value="${admins.realname}" autocomplete ="off"/></td>
		<td align="center"><p style="color: red">&nbsp;</p></td>
	</tr>
	<tr>
		<td align="center">密码</td>
		<input type="password"  name="password"   style="display: none"/>
		<td align="center">
			<input type="password"  name="password" value="${admins.password}" id="password" autocomplete ="off"/>
		</td>
		<td align="center"><input type="checkbox" onclick="show();"/> </td>
	</tr>
		<input type="hidden"  name="option" value="editAdmins"/>
		
	 	<script type="text/javascript">
			function add(){
				var account = $("input[name='account']").val();
				var realname = $("input[name='realname']").val();
				var password = $("input[name='password']").eq(1).val();
				var len = $("input:checkbox:checked").length;
				if(account == "" || realname == "" || password == ""){
					alert("用户名、真实姓名、密码不能为空");
				}else{
					$("form").submit();
				}
			}	
			var flag = true;
			function show(){
				if(flag){
					var password = document.getElementById("password");
					password.setAttribute("type","text");
					flag = false;
				}else{
					var password = document.getElementById("password");
					password.setAttribute("type","password");
					flag = true;
				}
			}
		</script>
		
	  <tr>
		<td align="center">锁定状态</td>
		<td align="center">
			<c:if test="${admins.lock_statu == 0}">
				<input type="radio" name="lock" value="1"/>是 
				<input type="radio" name="lock" value="0" checked/>否</td>
			</c:if>
			<c:if test="${admins.lock_statu == 1}">
				<input type="radio" name="lock" value="1" checked/>是 
				<input type="radio" name="lock" value="0" />否</td>
			</c:if>
		</td>
		<td align="center"><p style="color: red">&nbsp;</p></td>
		</tr>
	  <tr>
		<td align="center">用户权限</td>
		<td align="center">
			<c:if test="${admins.user_permit == 0}">
				<input type="checkbox" name="permit" value="user"/>管理员
			</c:if>
			<c:if test="${admins.user_permit == 1}">
				<input type="checkbox" name="permit" value="user" checked="checked"/>管理员
			</c:if>
			<c:if test="${admins.po_permit == 0}">
				<input type="checkbox" name="permit" value="po"/>采购
			</c:if>
			<c:if test="${admins.po_permit == 1}">
				<input type="checkbox" name="permit" value="po" checked="checked"/>采购
			</c:if>
			<c:if test="${admins.depot_permit == 0}">
				<input type="checkbox" name="permit" value="depot"/>仓管
			</c:if>
			<c:if test="${admins.depot_permit == 1}">
				<input type="checkbox" name="permit" value="depot" checked="checked"/>仓管
			</c:if>			
			<c:if test="${admins.sale_permit == 0}">
				<input type="checkbox" name="permit" value="sale"/>销售
			</c:if>
			<c:if test="${admins.sale_permit == 1}">
				<input type="checkbox" name="permit" value="sale" checked="checked"/>销售
			</c:if>		
			<c:if test="${admins.report_permit == 0}">
				<input type="checkbox" name="permit" value="report"/>报表
			</c:if>
			<c:if test="${admins.report_permit == 1}">
				<input type="checkbox" name="permit" value="report" checked="checked"/>报表
			</c:if>		
			<c:if test="${admins.finance_permit == 0}">
				<input type="checkbox" name="permit" value="finance"/>财务
			</c:if>
			<c:if test="${admins.finance_permit == 1}">
				<input type="checkbox" name="permit" value="finance" checked="checked"/>财务
			</c:if>		
			<c:if test="${admins.networksale_permit == 0}">
				<input type="checkbox" name="permit" value="networksale"/>网上销售
			</c:if>
			<c:if test="${admins.networksale_permit == 1}">
				<input type="checkbox" name="permit" value="networksale"/>网上销售
			</c:if>		
		</td>
		<td align="center"><p style="color: red">&nbsp;</p></td>
		</tr>
	  <tr>
		<td height="18" colspan="2" align="center"><input type="reset"/> <input type="button" value="保存" onClick="add()"/></td>
		<td align="center"><p style="color: red">&nbsp;</p></td>
		</tr>
	</table>
	</form>

	</div>

	</body>
</html>
