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
	<script type="text/javascript">
		function add(){
			location.href="Admins?option=addAdminsLink";
		}
	</script>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
		<td width="30px" nowrap class="toolbar">&nbsp;</td>
		<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="add()"><img src="../images/new.gif">新增</td>
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
	
	<div class="query_div">
		<form action="Admins" method="post">
		用户账号：<input type="text" name="account" value="${account }"/>
		用户姓名：<input type="text" name="realname" value="${realname }"/>
		添加日期：
			<input type="text" name="startDate"  value="${startDate }" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true})"/>
			-
			<input type="text" name="endDate" value="${endDate }" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true})"/>
			
		锁定状态：
			<c:if test="${empty lock }">
		  		<input type="radio" name="lock" value="all" checked="true"/>全部
				<input type="radio" name="lock" value="1"  />锁定
				<input type="radio" name="lock" value="0"  />正常
		  	</c:if>
		  	<c:if test="${lock eq 'all' }">
		  		<input type="radio" name="lock" value="all" checked="true"/>全部
				<input type="radio" name="lock" value="1"  />锁定
				<input type="radio" name="lock" value="0"  />正常
		  	</c:if>
		  	<c:if test="${lock eq '1' }">
		  		<input type="radio" name="lock" value="all" />全部
				<input type="radio" name="lock" value="1"  checked="true"/>锁定
				<input type="radio" name="lock" value="0"  />正常
		  	</c:if>
		  	<c:if test="${lock eq '0' }">
		  		<input type="radio" name="lock" value="all" />全部
				<input type="radio" name="lock" value="1"  />锁定
				<input type="radio" name="lock" value="0"  checked="true"/>正常
		  	</c:if>
			<input type="button" onclick="checkDate();" value="查询"/>
			<input type="hidden" name="option" value="query"/>
		</form>
		<script type="text/javascript">
			function checkDate(){
				var startDate = $("input[name='startDate']").val();
				var endDate = $("input[name='endDate']").val();
				if(startDate == "" && endDate != ""){
					alert("请选择正确的时间段");
				}else if(startDate != "" && endDate == ""){
					alert("请选择正确的时间段");
				}else if(startDate > endDate ){
					alert("请选择正确的时间段");
				}else{
					$("form").submit();
				}
			}
		</script>
	</div>
	
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
	  <tr>
		<td class="title1">用户账号</td>
		<td class="title1">用户姓名</td>
		<td class="title1">添加日期</td>
		<td class="title1">锁定状态</td>
		<td class="title1">用户权限列表</td>
		<td class="title1">操作</td>
	  </tr>
	  <c:if test="${!empty adminList }">
	  <c:forEach items="${adminList }" var="admins">
	  <tr>
		<td align="center">${admins.account }</td>
		<td align="center">${admins.realname }</td>
		<td align="center">${admins.createdate }</td>
		<td align="center">
			<c:if test="${admins.lock_statu == 0}">
				正常
			</c:if>
			<c:if test="${admins.lock_statu == 1}">
				锁定
			</c:if>
		</td>
		<td align="center">
			<c:if test="${admins.user_permit == 1 }">管理员 </c:if>
			<c:if test="${admins.sale_permit == 1 }">销售管理 </c:if>
			<c:if test="${admins.po_permit == 1 }">采购管理 </c:if>
			<c:if test="${admins.depot_permit ==1 }">仓库管理 </c:if>
			<c:if test="${admins.finance_permit  == 1 }">财务管理 </c:if>
			<c:if test="${admins.report_permit  == 1 }">业务报表 </c:if>
			<c:if test="${admins.networksale_permit == 1 }">网上销售 </c:if>
		</td>
		<td align="center">
			<a href="Admins?option=editAdminslink&accountUpdate=${admins.account }&account=${account}&realname=${realname}&startDate=${startDate}&endDate=${endDate}&lock=${lock}" >修改</a>
			<a href="Admins?option=deleteAdmins&accountDelete=${admins.account }&account=${account}&realname=${realname}&startDate=${startDate}&endDate=${endDate}&lock=${lock}" onclick="return checkDelete()">删除</a>
		</td>
	  </tr>
	  </c:forEach>
  		<script type="text/javascript">
  			function checkDelete(){
  				if(confirm("是否删除?")){
  					return true;
  				}else{
  					return false;
  				}
  			}
		</script>
		</c:if>
	</table>
	</div>
	
	
	</body>
</html>
