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
		<td width="100%" nowrap class="toolbar">&nbsp;</td>
	  </tr>
	</table>

	<div id="m">
	<form action="Admins" method="post">
	<!-- 这两个input是用来消除浏览器自动充填了 -->
	<input type="text" name="account" value="1" autocomplete ="off" style="display: none"/>
	<input type="password" name="password" autocomplete ="off"  style="display: none"/>
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
	  <tr>
		<td class="title1">信息</td>
		<td class="title1">数据</td>
		<td class="title1" width="300px">提示</td>
		</tr>
	  <tr>
		<td align="center">用户名</td>
		<td align="center"><input type="text" id="account" name="account" autocomplete ="off" onchange="checkAccount()"/></td>
		<td align="center"><p style="color: black" id="error">&nbsp;</p></td>
	</tr>
	 <tr>
		<td align="center">真是姓名</td>
		<td align="center"><input type="text" name="realname" autocomplete ="off"/></td>
		<td align="center"><p style="color: black">&nbsp;</p></td>
	</tr>
	<tr>
		<td align="center">密码</td>
		<td align="center"><input type="password" id="password" name="password" placeholder="默认=用户名" autocomplete ="off"/></td>
		<td align="center"><input type="checkbox" onclick="show();"/> </td>
	</tr>
		<input type="hidden"  name="option" value="addAdmins"/>
	 	<script type="text/javascript">
			function add(){
				var account = $("input[name='account']").eq(1).val();
				var realname = $("input[name='realname']").eq(1).val();
				var len = $("input:checkbox:checked").length;
				if(account == "" || realname == ""){
					alert("用户名和真实姓名不能为空");
				}else if(len == 0){
					alert("至少选中一个权限!");
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
			function checkAccount(){
				$.post("Admins",{option:"checkAccount",account:$("#account").val()},function (data){
					$("#error").text(data);
				})
			}
		</script>
		
	  <tr>
		<td align="center">锁定状态</td>
		<td align="center">
			<input type="radio" name="lock" value="1"/>是 
			<input type="radio" name="lock" value="0" checked/>否
		</td>
		<td align="center"><p style="color: red">&nbsp;</p></td>
	</tr>
	  <tr>
		<td align="center">用户权限</td>
		<td align="center">
			<input type="checkbox" name="permit" value="user"/>管理员
			<input type="checkbox" name="permit" value="po"/>采购
			<input type="checkbox" name="permit" value="depot"/>仓管
			<input type="checkbox" name="permit" value="sale"/>销售
			<input type="checkbox" name="permit" value="report"/>报表
			<input type="checkbox" name="permit" value="finance"/>财务
			<input type="checkbox" name="permit" value="networksale"/>网上销售
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
