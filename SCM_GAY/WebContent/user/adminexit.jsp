<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
		<title>用户管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>
	<script type="text/javascript">
		question = confirm("请问您是否要退出？");
		if (question != "0"){
			location.href="Admins?option=exit";
		}
	</script>
	<body>
	</body>
</html>
