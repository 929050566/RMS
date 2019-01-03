<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
	<head>
		<title>新添采购单</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../pomain/common.js" ></script>
		<script type="text/javascript" src="../pomain/productDiv.js" ></script>
		<script type="text/javascript" src="../pomain/My97DatePicker/WdatePicker.js" >
		function update(){
					document.getElementById("dataList").style.display="none";
					document.getElementById("add").style.display="block";
			}
		
		</script>
		
			
			
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

	<body>
		<div id="m">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
			  <tr>
				<td nowrap class="title1">采购单管理 -- 新添采购单</td>
			  </tr>
			</table>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			  <tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onclick="location.href='pomainform.jsp'"><img src="../images/new.gif">新增</td>
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
				采购单编号：<input type="text" name="purchaseid" />
				供应商：
				<select name="suppliername" >
					<option value="">请选择 </option>
				</select>
				付款方式：
					<select id="payType" name="paystatu">
						<option value="">请选择</option>
						<option value="1">货到付款</option>
						<option value="2">款到发货</option>
						<option value="3">预付款到发货</option>
					</select>
				创建日期：
				<input class="Wdate" type="text" id="startDate"  onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
				-
				<input class="Wdate" type="text" id="endDate"  onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
				<input type="button" value="查询" onclick="goPage(1)"/>
			</div>
				
			<div id="dataList">
				<table width="100%" border="0" align="center" cellspacing="1" class="c">
					<tr>
						<td class="title1">采购单编号</td>
						<td class="title1">创建时间</td>
						<td class="title1">供应商名称</td>
						<td class="title1">创建用户</td>
						<td class="title1">附加费用</td>
						<td class="title1">采购产品总价</td>
						<td class="title1">采购单总价格</td>
						<td class="title1">付款方式</td>
						<td class="title1">最低预付款金额</td>
						<td class="title1">操作</td>
					</tr>
			
					<tr>
						<td align="center"><a href="pomain_detail.html">20170621142653</a></td>
						<td align="center">2017-06-21 14:26:53</td>
						<td align="center">京东商城</td>
						<td align="center">lisi</td>
						<td align="center">0.0</td>
						<td align="center">6.0</td>
						<td align="center">6.0</td>
						<td align="center">货到付款</td>
						<td align="center">0.0</td>
						
						<td align="center">
							<a href="#" onclick="update()">修改</a>
							<a href="javascript:void(0)">删除</a>
						</td>
					</tr>
					<tr style="display:none"><td colspan="10" name="detail"></td></tr>
			
					<tr>
						<td align="center"><a href="pomain_detail.jsp">20170622142425</a></td>
						<td align="center">2017-06-22 14:24:25</td>
						<td align="center">京东商城</td>
						<td align="center">lisi</td>
						<td align="center">12.0</td>
						<td align="center">72.0</td>
						<td align="center">60.0</td>
						<td align="center">货到付款</td>
						<td align="center">0.0</td>
						
						<td align="center">
							<a href="javascript:void(0)" >修改</a>
							<a href="javascript:void(0)">删除</a>
						</td>
					</tr>
				<tr style="display:none"><td colspan="10" name="detail"></td></tr>
			
				</table>
				</div>
				<div id="add" class="hidd">
				<table width="100%"  border="0" align="center" cellspacing="1" class="c">
				<tr>
				<td class="title1">&nbsp;</td>
				<td class="title1">&nbsp;</td>
				</tr>
				<tr>
				<td align="center">供应商编号</td>
				<td align="center"><input type="text"/></td>
				</tr>
				<tr>
				<td align="center">供应商名称</td>
				<td align="center"><input type="text"/></td>
				</tr>
				<tr>
				<td align="center">密码</td>
				<td align="center"><input type="password"/></td>
				</tr>
				<tr>
				<td align="center">联系人</td>
				<td align="center"><input type="text"/></td>
				</tr>
				<tr>
		<td align="center">地址</td>
		<td align="center"><input type="text"/></td>
	</tr>
	<tr>
		<td align="center">邮政编码</td>
		<td align="center"><input type="text"/></td>
	</tr>
	<tr>
		<td align="center">注册日期</td>
		<td align="center"><input type="text"/></td>
	</tr>
	<tr>
		<td align="center">电话</td>
		<td align="center"><input type="text"/></td>
	</tr>
	<tr>
		<td align="center">传真</td>
		<td align="center"><input type="text"/></td>
	</tr>
	  <tr>
		<td height="18" colspan="2" align="center"><input type="reset"/> <input type="button" value="保存" onClick="re()"/></td>
		</tr>
	</table>


	</div>

				<div class="pageDiv">
					当前第<span id="currentPage">1</span>页
					
						<input type="button" value="首页" disabled="disabled"/>
						<input type="button" value="上一页" disabled="disabled"/>
					
					
					
					
						<input type="button" value="下一页" onclick="goPage(2)"/>
						<input type="button" value="末页" onclick="goPage(2)"/>
					
					共2页 3条记录
				</div>
			
			
			</div>
		</div>


	</body>
</html>
