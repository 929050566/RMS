<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
		<title>login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<link href="css/style.css" rel="stylesheet" type="text/css">
	 	<script type="text/javascript" src="script/jquery-1.8.1.min.js"></script>
		<script type="text/javascript">
			/* 刷新title */
			window.open('title.jsp', 'topFrame')
			function isNone(){
				var account = $(" input[ name='account' ] ").val()
				var password = $(" input[ name='password' ] ").val()
				if(account == "" || password == ""){
					alert("不能为空")
				}else{
					$("form").submit();
				}
			}
		</script>
	</head>
	<body bgcolor="#ffffff" >

		<form action="Login">
			<table width="100%"  border="0"  >
				<tr>
					<td class="title1">&nbsp;</td>
				</tr>
			  <tr>
				<td width="50%" align="right">用户名&nbsp;&nbsp;</td>
				<td width="50%"><input type="text" name="account"/>${error }</td>
			  </tr>
			  <tr>
				<td align="right">密码&nbsp;&nbsp;&nbsp;</td>
				<td><input type="password" name="password"/></td>
			  </tr>
			  <tr>
			  	<input type="hidden" name="option" value="login">
				<td class="title1"><div align="right"><input type="button" onclick="isNone();" value="登录"/></div></td>
				<td class="title1"><div align="left"><input type="reset" value="重置"/></div></td>
			  </tr>
			</table>
		</form>
	</body>
</html>
