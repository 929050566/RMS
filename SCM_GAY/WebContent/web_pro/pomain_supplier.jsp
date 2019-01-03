<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>供应商管理</title>
		
		<meta charset=utf-8">
		
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="../pomain/jquery-3.3.1.js" ></script>
		<script type="text/javascript" src="../pomain/productDiv.js" ></script>
		<script type="text/javascript" src="../pomain/My97DatePicker/WdatePicker.js" ></script>
		<script type="text/javascript">

	
		
			function add(){
				document.getElementById("m").style.display="none";
				document.getElementById("add").style.display="block";
			}
			function re(){
				document.getElementById("m").style.display="block";
				document.getElementById("add").style.display="none";
			}
			
			function del(obj){
				var tr = obj.parentNode.parentNode;
				var id=tr.cells[0].innerHTML;
				
				var result =window.confirm("确定要删除吗");
				if(result==true){
					window.location='supplier?option=deletesupplier&supplieid='+id;
				}
			}
			function update(obj){
				var tr = obj.parentNode.parentNode;
				var id=tr.cells[0].innerHTML;
				
				window.location='supplier?option=updatesupplier&supplieid='+id;
				
			}
		</script>
	</head>

	<body>
	
	<div id="m">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
	  <tr>
		<td nowrap class="title1">您的位置：采购管理－－供应商管理</td>
	  </tr>
	</table>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
		<td width="30px" nowrap class="toolbar">&nbsp;</td>
		<td width="40px" nowrap class="toolbar"  onClick="add()"><img src="../images/new.gif">新增</td>
		<td nowrap class="toolbar">&nbsp;</td>
		
	  </tr>
	</table>
	<div class="query_div">
	<form action="supplier" method="post">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		供应商编号：<input type="text" name="id"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		供应商名称：<input type="text" name="name"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="hidden" name="option" value="selectsupplier">
		<input type="submit" value="查询"/><input type="reset" value="重置" /> 
	</form>	
	</div>
	<table width="100%"  border="0" align="center" cellspacing="1" class="c" id="table">
	  <tr>
		<td class="title1">供应商编号</td>
		<td class="title1">供应商名称</td>
		<td class="title1">联系人</td>
		<td class="title1">地址</td>
		<td class="title1">邮政编码</td>
		<td class="title1">注册日期</td>
		<td class="title1">电话</td>
		<td class="title1">传真</td>
		<td class="title1">操作</td>
	  </tr>
	  <c:forEach items="${suppliers}" var="supplier">
	  <tr>
		<td align="center" >${supplier.supplieid}</td>
		
		<td align="center">${supplier.suppliername}</td>
		<td align="center">${supplier.velaname}</td>
		<td align="center">${supplier.address}</td>
		<td align="center">${supplier.mailnumber}</td>
		<td align="center">${supplier.createdate}</td>
		<td align="center">${supplier.phone}</td>
		<td align="center">${supplier.faxes}</td>
		<td align="center"><a  onClick="update(this)">修改</a> <a  onClick="del(this)" >删除</a></td>
	  </tr>
	  </c:forEach>
	</table>
	</div>
	<div id="add" class="hidd">
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
		<td align="center"><input type="text" name="supplieid" id="supplieid" onblur="checksupplieid()"/><label id="supplieidresult"></label></td>
	</tr>
	  <tr>
		<td align="center">供应商名称</td>
		<td align="center"><input type="text" id="suppliername" name="suppliername" onblur="checksuppliername()" /><label id="suppliernameresult"></label></td>
	</tr>
	<tr>
		<td align="center">密码</td>
		<td align="center"><input type="password" id="supplierpassword"  name="supplierpassword"/></td>
	</tr>
	<tr>
		<td align="center">联系人</td>
		<td align="center"><input type="text" id="velaname" name="velaname" onblur="checkvelaname()" /><label id="velanameresult"></label></td>
	</tr>
	<tr>
		<td align="center">地址</td>
		<td align="center"><input type="text" id="address" name="address"/></td>
	</tr>
	<tr>
		<td align="center">邮政编码</td>
		<td align="center"><input type="text" id="mailnumber" name="mailnumber"/></td>
	</tr>
	<tr>
		<td align="center">注册日期</td>
		<td align="center"><input type="text"  name="createdate" readonly /></td>
	</tr>
	<tr>
		<td align="center">电话</td>
		<td align="center"><input type="text" id="phone" name="phone" onblur="checkphone()" /><label id="phoneresult"></label></td>
	</tr>
	<tr>
		<td align="center">传真</td>
		<td align="center"><input type="text" id="faxes" name="faxes"/></td>
	</tr>
	  <tr>
	  <input type="hidden" name="option" value="supplieradd">
		<td height="18" colspan="2" align="center"><input type="reset" value="重置" /> <input type="submit" value="确定" onClick="re()" id="addsupplieidbutton"/></td>
		</tr>
		
	</table>
	</form>

	</div>

	</body>
</html>
