<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>查询销售单</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../script/common.js" ></script>
		<script type="text/javascript" src="../script/productDiv.js" ></script>
		<script type="text/javascript" src="../script/My97DatePicker/WdatePicker.js" ></script>
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
				<td nowrap class="title1">销售管理 -- 查询销售单</td>
			  </tr>
			</table>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			  <tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
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
			<form action="SaleManageServlet" method="post">
			<div class="query_div">
				销售单编号：<input type="text" id="poId" name="salebillid" value="${salebilidToQuery }"/>
				客户：
				<select id="venderCode" name="customername">
					<option value="请选择" selected="selected"></option>
					<c:forEach items="${custmerList }" var="cust">
						<c:if test="${ cust eq customername}">
							<option value="${cust}" selected="selected">${cust} </option>
						</c:if>
						<c:if test="${ cust ne customername}">
							<option value="${cust}" >${cust} </option>
						</c:if>
					</c:forEach>
				</select>
				付款方式：
					<select name="paystate">
						<option value="请选择">请选择</option>
						<c:if test="${paystate eq '1' }">
							<option value="1" selected="selected">货到付款</option>
							<option value="2">款到发货</option>
							<option value="3">预付款到发货</option>
						</c:if>
						<c:if test="${paystate eq '2' }">
							<option value="1" >货到付款</option>
							<option value="2" selected="selected">款到发货</option>
							<option value="3">预付款到发货</option>
						</c:if>						
						<c:if test="${paystate eq '3' }">
							<option value="1" >货到付款</option>
							<option value="2" >款到发货</option>
							<option value="3" selected="selected">预付款到发货</option>
						</c:if>	
						<c:if test="${(paystate eq  '请选择') || (empty paystate)}">
							<option value="1" >货到付款</option>
							<option value="2" >款到发货</option>
							<option value="3" >预付款到发货</option>
						</c:if>							
					</select>
				创建日期：
				<input class="Wdate" type="text" id="startDate"  name="startDate" value="${startDate }" onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
				-
				<input class="Wdate" type="text" id="endDate"  name="endDate" value="${endDate }" onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
				处理状态：
				<select name="disposestate">
					<option value="请选择">请选择</option>
					<c:if test="${ disposestate eq '1'}">
						<option value="1" selected="selected">新增</option>
						<option value="2">已收货</option>
						<option value="3">已付款</option>
						<option value="4">已了结</option>
						<option value="5">已预付</option>						
					</c:if>
					<c:if test="${ disposestate eq '2'}">
						<option value="1" >新增</option>
						<option value="2" selected="selected">已收货</option>
						<option value="3">已付款</option>
						<option value="4">已了结</option>
						<option value="5">已预付</option>						
					</c:if>
					<c:if test="${ disposestate eq '3'}">
						<option value="1" >新增</option>
						<option value="2">已收货</option>
						<option value="3" selected="selected">已付款</option>
						<option value="4">已了结</option>
						<option value="5">已预付</option>						
					</c:if>
					<c:if test="${ disposestate eq '4'}">
						<option value="1" >新增</option>
						<option value="2">已收货</option>
						<option value="3">已付款</option>
						<option value="4" selected="selected">已了结</option>
						<option value="5">已预付</option>						
					</c:if>
					<c:if test="${ disposestate eq '5'}">
						<option value="1" >新增</option>
						<option value="2">已收货</option>
						<option value="3">已付款</option>
						<option value="4">已了结</option>
						<option value="5" selected="selected">已预付</option>						
					</c:if>
					<c:if test="${ empty disposestate || disposestate eq '请选择'}">
						<option value="1" >新增</option>
						<option value="2">已收货</option>
						<option value="3">已付款</option>
						<option value="4">已了结</option>
						<option value="5">已预付</option>						
					</c:if>
				</select>
				<input type="button" value="查询" onclick="checkPur()"/>
				<input type="reset" />
				<input type="hidden" name="option" value="querySale">
			</div>
			</form>
			<script type="text/javascript">
				function checkPur(){
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
			
			<div id="dataList">
				<input type="hidden" name="option" value=" "/>
				<table width="100%" border="0" align="center" cellspacing="1" class="c">
					<tr>
						<td class="title1">销售单编号</td>
						<td class="title1">创建时间</td>
						<td class="title1">客户名称</td>
						<td class="title1">创建用户</td>
						<td class="title1">附加费用</td>
						<td class="title1">产品总价</td>
						<td class="title1">销售单总价格</td>
						<td class="title1">付款方式</td>
						<td class="title1">处理状态</td>
						<td class="title1">最低预付款金额</td>
					</tr>
					<c:forEach items="${saleList}" var="e">
						<tr>
							<td align="center"><a href="SaleManageServlet?option=sale_detail&saleid=${e.saleid }&edit=yes">${e.saleid }</a>
							</td>
							<td align="center">${e.createtime }</td>
							<td align="center">${e.customername }</td>
							<td align="center">${e.createname }</td>
							<td align="center">${e.extramoney }</td>
							<td align="center">${e.totalproprices }</td>
							<td align="center">${e.totalprices }</td>
							<c:if test="${e.paystate eq '1' }">
								<td value="1" align="center" >货到付款</td>
							</c:if>
							<c:if test="${e.paystate eq '2' }">
								<td value="2" align="center">款到发货</td>

							</c:if>	
							<c:if test="${e.paystate eq '3' }">
								<td value="3" align="center">预付款到发货</td>
							</c:if>			
							<c:if test="${e.disposestate eq '1' }">
							<td align="center">新增</td>
							</c:if>
							<c:if test="${e.disposestate eq '2' }">
							<td align="center">已收货</td>
							</c:if>
							<c:if test="${e.disposestate eq '3' }">
							<td align="center">已付款</td>
							</c:if>
							<c:if test="${e.disposestate eq '4' }">
							<td align="center">已了结</td>
							</c:if>
							<c:if test="${e.disposestate eq '5' }">
							<td align="center">已预付</td>
							</c:if>
							<td align="center">${e.advanceprice }</td>
						<td align="center">
							<!-- <a href="javascript:void(0)" >修改</a> -->
							<a href="SaleManageServlet?option=deletePur&page=${page}&salebillid=${e.saleid }&salebilidToQuery=${salebilidToQuery }&customername=${customername}&paystate=${paystate}&startDate=${startDate}&endDate=${endDate}&disposestate=${disposestate}" onclick="return confirmSubmit();">删除</a>
						</td>
						</tr>
						<script type="text/javascript">
							function confirmSubmit(){
								if(confirm("是否删除？")){
									return true;
								}else{
									return false;
								}
							}
						</script>
					</c:forEach>
				</table>
				<c:if test="${ !empty saleList}">
				<div class="pageDiv">
					当前第<span id="currentPage">${page }</span>页
						<a id="start" style="font-size: large;" href="SaleManageServlet?option=querySale&page=1&salebillid=${salebillid }&customername=${customername}&paystate=${paystate}&startDate=${startDate}&endDate=${endDate}&disposestate=${disposestate}" >首页</a>
						<a id="last"  style="font-size: large;" href="SaleManageServlet?option=querySale&page=${page-1 }&salebillid=${salebillid }&customername=${customername}&paystate=${paystate}&startDate=${startDate}&endDate=${endDate}&disposestate=${disposestate}">上一页</a>
						<a id="next"  style="font-size: large;" href="SaleManageServlet?option=querySale&page=${page+1 }&salebillid=${salebillid }&customername=${customername}&paystate=${paystate}&startDate=${startDate}&endDate=${endDate}&disposestate=${disposestate}">下一页</a>
						<a id="end"   style="font-size: large;" href="SaleManageServlet?option=querySale&page=${totalPage }&salebillid=${salebillid }&customername=${customername}&paystate=${paystate}&startDate=${startDate}&endDate=${endDate}&disposestate=${disposestate}">末页</a>
					共<span id="totalPage">${totalPage }</span>页 ${linesNum }条记录
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
				</c:if>
			
			
			</div>
		</div>


	</body>
</html>