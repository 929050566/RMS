
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>产品管理</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../script/common.js" ></script>
		<script type="text/javascript" src="../script/productDiv.js" ></script>
		<script type="text/javascript" src="../script/My97DatePicker/WdatePicker.js" ></script>
		<script type="text/javascript" src="../salse_script/salse_script.js" ></script>
		<script type="text/javascript" src="../script/jquery-1.8.1.min.js" ></script>	
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
				<td nowrap class="title1">销售管理 -- 产品管理</td>
			  </tr>
			</table>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			  <tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onclick="location.href='ProductServlet?option=gettypeforadd'"><img src="../images/new.gif">新增</td>
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
<!-- 			<div class="query_div">
				产品编号：<input type="text" id="adminId" />
				产品名称：<input type="text" id="adminName" />
				<input type="button" value="查询" onclick="goPage(1)"/>
			</div> -->
			
			<div id="dataList">
				<table width="100%" border="0" align="center" cellspacing="1" class="c">
					<tr>
						<td class="title1">产品编号</td>
						<td class="title1">产品名称</td>
						<td class="title1">数量单位</td>
						<td class="title1">分类名称</td>
						<td class="title1">操作</td>
					</tr>
					<c:forEach items="${allproduct}" var="e">
						<tr>
							<td align="center">${e.product_id}</td>
							<td align="center">${e.product_name}</td>
							<td align="center">${e.product_unit}</td>
							<td align="center">${e.product_type}</td>
							
							<td align="center">
								
								<a href="javascript:void(0)" onclick="deleteproduct(this)" >删除</a>
							</td>
						</tr>
					</c:forEach>
					
				<tr style="display:none"><td colspan="10" name="detail"></td></tr>
			
				</table>


				<div class="pageDiv">
					当前第<span id="currentPage">${pages}</span>页
						<a id="start" style="font-size: large;" href="ProductServlet?option=showproduct&pages=1" >首页</a>
						<a id="last"  style="font-size: large;" href="ProductServlet?option=showproduct&pages=${pages - 1 }">上一页</a>
						<a id="next"  style="font-size: large;" href="ProductServlet?option=showproduct&pages=${pages + 1 }">下一页</a>
						<a id="end"   style="font-size: large;" href="ProductServlet?option=showproduct&pages=${totalpages }">末页</a>
					共<span id="totalPage">${totalpages }</span>页${lines }条记录
				</div>
				<script type="text/javascript">
					var currentPage = $("#currentPage").text();
					var totalPage = $("#totalPage").text();
					if(currentPage == totalPage){
						$("#next").removeAttr('href')
						$("#end").removeAttr('href')
						$("#next").css("color","red");
						$("#end").css("color","red");
					}			
					if(currentPage == '1'){
						$("#start").removeAttr('href')
						$("#last").removeAttr('href')			
						$("#start").css("color","red");
						$("#last").css("color","red");
					}	
				</script>			
			
			</div>
		</div>


	</body>
</html>