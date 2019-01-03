<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>供应商修改</title>
		
		<meta charset=utf-8">
		
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="../pomain/upd.js" ></script>
		<script type="text/javascript" src="../pomain/My97DatePicker/WdatePicker.js" ></script>
		<script type="text/javascript">

	
			function re(){
				document.getElementById("m").style.display="block";
				document.getElementById("add").style.display="none";
			}
			
	
		</script>
	</head>

	<body>
	<div id="add">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
	  <tr>
		<td nowrap class="title1">采购单管理 -- 采购单了结</td>
	  </tr>
  	  <tr>
		<td width="100%" nowrap class="toolbar">&nbsp;</td>
	  </tr>
	</table>
	<form action="supplier" method="post">
		<table width="100%"  border="0" align="center" cellspacing="1" class="c">
	  <tr>
		<td class="title1">&nbsp;</td>
		<td class="title1">&nbsp;</td>
		</tr>
		<tr>
		<td align="center">供应商编号</td>
		<td align="center"><input type="text"  name="supplieid" value="${supplier.supplieid}" readonly></td>
	</tr>
	  <tr>
		<td align="center">供应商名称</td>
		<td align="center"><input type="text" id="suppliername" name="suppliername" onblur="checksuppliername()" value="${supplier.suppliername}"/><label id="suppliernameresult"></label></</td>
	</tr>
	<tr>
		<td align="center">密码</td>
		<td align="center"><input type="password" name="supplierpassword" value="${supplier.supplierpassword}"/></td>
	</tr>
	<tr>
		<td align="center">联系人</td>
		<td align="center"><input type="text" id="velaname" name="velaname" onblur="checkvelaname()" value="${supplier.velaname}"/><label id="velanameresult"></label></td>
	</tr>
	<tr>
		<td align="center">地址</td>
		<td align="center"><input type="text" name="address" value="${supplier.address}"/></td>
	</tr>
	<tr>
		<td align="center">邮政编码</td>
		<td align="center"><input type="text" name="mailnumber" value="${supplier.mailnumber}"/></td>
	</tr>
	<tr>
		<td align="center">注册日期</td>
		<td align="center"><input type="text" name="createdate" value="${supplier.createdate}" readonly /></td>
	</tr>
	<tr>
		<td align="center">电话</td>
		<td align="center"><input type="text" id="phone" name="phone" onblur="checkphone()" value="${supplier.phone}"/> <label id="phoneresult"></label></td>
	</tr>
	<tr>
		<td align="center">传真</td>
		<td align="center"><input type="text" name="faxes" value="${supplier.faxes}"></td>
	</tr>
	  <tr>
	  	<input type="hidden" name="option" value="updbutton">
		<td height="18" colspan="2" align="center"><input type="reset" value="重置" /> <input type="submit" value="确定" onClick="re()"/></td>
		</tr>
	</table>
	</form>

	</div>

	</body>
</html>
