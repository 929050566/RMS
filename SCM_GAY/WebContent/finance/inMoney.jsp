<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
		<title>付款登记</title>
		
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
				<td nowrap class="title1">财务收支 -- 收款登记</td>
			  </tr>
			</table>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			 <tr>
				<td nowrap="" class="toolbar">&nbsp;</td>
				<td width="60px" nowrap="" class="toolbar" onmouseover="OMO(event)" onmouseout="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap="" class="toolbar">|</td>
				<td width="60px" nowrap="" class="P" onmouseover="OMO(event)" onmouseout="OMOU(event)" onclick="fun1();">货到付款</td>
				<td width="20px" nowrap="" class="toolbar">|</td>
				<td width="60px" nowrap="" class="P" onmouseover="OMO(event)" onmouseout="OMOU(event)" onclick="fun2();">款到发货</td>
				<td width="20px" nowrap="" class="toolbar">|</td>
				<td width="80px" nowrap="" class="toolbar" onmouseover="OMO(event)" onmouseout="OMOU(event)" onclick="fun3();">预付款到发货</td>
				<td width="20px" nowrap="" class="toolbar">|</td>
			  </tr>
			</table>
			<script type="text/javascript">
				function fun1(){
					location.href="Finance?option=queryInMoney&paystate=1";
				}
				function fun2(){
					location.href="Finance?option=queryInMoney&paystate=2";
				}
				function fun3(){
					location.href="Finance?option=queryInMoney&paystate=3";
				}
			</script>
			<div id="dataList">
				<table width="100%" border="0" align="center" cellspacing="1" class="c">
					<tr>
						<td class="title1">销售单编号</td>
						<td class="title1">创建时间</td>
						<td class="title1">客户名称</td>
						<td class="title1">创建用户</td>
						<td class="title1">附加费用</td>
						<td class="title1">销售产品总价</td>
						<td class="title1">销售单总价格</td>
						<td class="title1">付款方式</td>
						<td class="title1">最低预付款金额</td>
						<td class="title1">处理状态</td>
						<td class="title1">操作</td>
					</tr>
					<c:forEach items="${saleList }" var="sale">
					<tr>
						<td align="center"><a href="../web_pro/Purchase?option=pur_detail&purchaseid=${purchase.purchaseid }&edit=no&url=../finance/Finance?option=query">${sale.saleid}</a></td>
						<td align="center">${sale.createtime }</td>
						<td align="center">${sale.customername }</td>
						<td align="center">${sale.createname }</td>
						<td align="center">${sale.extramoney }</td>
						<td align="center">${sale.totalproprices }</td>
						<td align="center">${sale.totalprices }</td>
						<c:choose>
   							<c:when test="${sale.paystate eq '1'}"> 
   								  <td align="center">货到付款</td>
   							</c:when>
   							<c:when test="${sale.paystate eq '2'}"> 
   								  <td align="center">款到发货</td>
   							</c:when>
   							<c:otherwise>  
   								<td align="center">预付款到发货</td>
   							</c:otherwise>
						</c:choose>						
						<td align="center">${sale.advanceprice }</td>
						<c:choose>
   							<c:when test="${sale.disposestate  eq '1'}"> 
   								  <td align="center">新增</td>
   							</c:when>
   							<c:when test="${sale.disposestate eq '2'}"> 
   								  <td align="center">已收货</td>
   							</c:when>
   							<c:when test="${sale.disposestate eq '3'}"> 
   								  <td align="center">已付款</td>
   							</c:when>
							<c:when test="${sale.disposestate eq '4'}"> 
   								  <td align="center">已了结</td>
   							</c:when>
   							<c:otherwise>  
   								<td align="center">已预付</td>
   							</c:otherwise>
						</c:choose>	
						<td align="center">
							<a href="Finance?option=purIntMoney&saleid=${sale.saleid }&paystate=${sale.paystate}&disposestate=${sale.disposestate}" onclick="return confirmSubmit();">收款</a>
						</td>
						<script type="text/javascript">
							function confirmSubmit(){
								if(confirm("是否收款?")){
									return true;
								}else{
									return false;
								}
							}
						</script>
					</tr>
					</c:forEach>
				<tr style="display:none"><td colspan="10" name="detail"></td></tr>
			
				</table>
				<div class="pageDiv">
					当前第<span id="currentPage">${page }</span>页
						<a id="start" style="font-size: large;" href="Finance?option=queryInMoney&page=1" >首页</a>
						<a id="last"  style="font-size: large;" href="Finance?option=queryInMoney&page=${page - 1 }">上一页</a>
						<a id="next"  style="font-size: large;" href="Finance?option=queryInMoney&page=${page + 1 }">下一页</a>
						<a id="end"   style="font-size: large;" href="Finance?option=queryInMoney&page=${totalPage }">末页</a>
					共<span id="totalPage">${totalPage }</span>页 ${linesNum }条记录
				</div>
				<script type="text/javascript">
					var currentPage = $("#currentPage").text();
					var totalPage = $("#totalPage").text();
					if(currentPage == totalPage || totalPage == 0){
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
