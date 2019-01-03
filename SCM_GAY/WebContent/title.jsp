<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
		<title></title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="script/common.js"></script>

		<script type="text/javascript">
			function closeAlert() {
				question = confirm("请问您是否要退出？");
				if (question != "0"){
					location.href="user/Admins?option=exit";
					//window.open('login.jsp', 'mainFrame')
				}
			}
		</script>
	</head>

	<body topmargin=0 leftmargin=0>
		<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0" height="100%">
		  <tr>
		  	<td width="40px" nowrap class="toolbar">
		  		<c:if test="${!empty admins }">
		  			欢迎${admins.realname }
		  		</c:if>
		  	</td>
		  	<td width="400px" nowrap class="toolbar"></td>
			<td class="toolbar" width="45px" onClick="window.open('login.jsp', 'mainFrame')">
				<c:if test="${empty admins }">
		  			<img src="images/jrxt.jpg" border="0">登录
		  		</c:if>
				<c:if test="${!empty admins }">
		  			<img src="images/jrxt.jpg" border="0">切换用户
		  		</c:if>			  
			 </td>
			<td width="20px" nowrap class="toolbar">|</td>
			<td class="toolbar" width="45px" onClick="closeAlert()">
			  <img src="images/lkxt.jpg" border="0">退出</td>
		  </tr>
		</table>
	</body>
</html>
