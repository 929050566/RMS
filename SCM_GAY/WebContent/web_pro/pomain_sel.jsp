<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
		<title>采购单查询</title>
		
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
	</head>

	<body>
		<div id="m">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
			  <tr>
				<td nowrap class="title1">采购单管理 -- 采购单查询</td>
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
			<form action="Purchase" method="post">
			<div class="query_div">
				采购单编号：<input type="text" name="purchaseidToQuery" value="${purchaseidToQuery }" />
				供应商：
				<select name="suppliername">
					<option value="请选择">请选择 </option>
					<c:forEach items="${supplierList }" var="supplier">
						<c:if test="${supplier.suppliername eq suppliername }">
							<option value="${supplier.suppliername }" selected="selected">${supplier.suppliername } </option>
						</c:if>
						<c:if test="${supplier.suppliername ne suppliername }">
							<option value="${supplier.suppliername }" >${supplier.suppliername } </option>
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
					<input type="text" name="startDate"  value="${startDate }" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true})"/>
					-
					<input type="text" name="endDate" value="${endDate }" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true})"/>
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
				<input type="reset" "/>	
				<input type="button" value="查询" onclick="checkPur();"/>
				<input type="hidden" name="option" value="queryPur"/>
			</div>
			</form>	
			
		
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
						<td class="title1">处理状态</td>
						<td class="title1">操作</td>
					</tr>
			
				<c:forEach items="${purchaseList }" var="purchase">
					<tr>
						<td align="center"><a href="Purchase?option=pur_detail&purchaseid=${purchase.purchaseid }&page=${page }&purchaseidToQuery=${purchaseidToQuery }&suppliername=${suppliername}&paystate=${paystate}&startDate=${startDate}&endDate=${endDate}&disposestate=${disposestate}&edit=yes">${purchase.purchaseid }</a></td>
						<td align="center">${purchase.createtime }</td>
						<td align="center">${purchase.suppliername }</td>
						<td align="center">${purchase.createname }</td>
						<td align="center">${purchase.extramoney }</td>
						<td align="center">${purchase.totalproprices }</td>
						<td align="center">${purchase.totalprices }</td>
						<c:choose>
   							<c:when test="${purchase.paystate eq '1'}"> 
   								  <td align="center">货到付款</td>
   							</c:when>
   							<c:when test="${purchase.paystate eq '2'}"> 
   								  <td align="center">款到发货</td>
   							</c:when>
   							<c:otherwise>  
   								<td align="center">预付款到发货</td>
   							</c:otherwise>
						</c:choose>						
						<td align="center">${purchase.advanceprice }</td>
						<c:choose>
   							<c:when test="${purchase.disposestate  eq '1'}"> 
   								  <td align="center">新增</td>
   							</c:when>
   							<c:when test="${purchase.disposestate eq '2'}"> 
   								  <td align="center">已收货</td>
   							</c:when>
   							<c:when test="${purchase.disposestate eq '3'}"> 
   								  <td align="center">已付款</td>
   							</c:when>
							<c:when test="${purchase.disposestate eq '4'}"> 
   								  <td align="center">已了结</td>
   							</c:when>
   							<c:otherwise>  
   								<td align="center">已预付</td>
   							</c:otherwise>
						</c:choose>	
						<td align="center">
							<!-- <a href="javascript:void(0)" >修改</a> -->
							<a href="Purchase?option=deletePur&purchaseid=${purchase.purchaseid }&page=${page }&purchaseidToQuery=${purchaseidToQuery }&suppliername=${suppliername}&paystate=${paystate}&startDate=${startDate}&endDate=${endDate}&disposestate=${disposestate}" onclick="return confirmSubmit();">删除</a>
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
				<tr style="display:none"><td colspan="10" name="detail"></td></tr>
				<tr style="display:none"><td colspan="10" name="detail"></td></tr>
				</table>
				<c:if test="${ !empty purchaseList}">
				<div class="pageDiv">
					当前第<span id="currentPage">${page }</span>页
						<a id="start" style="font-size: large;" href="Purchase?option=queryPur&page=1&purchaseid=${purchaseid }&suppliername=${suppliername}&paystate=${paystate}&startDate=${startDate}&endDate=${endDate}&disposestate=${disposestate}" >首页</a>
						<a id="last"  style="font-size: large;" href="Purchase?option=queryPur&page=${page - 1 }&purchaseid=${purchaseid }&suppliername=${suppliername}&paystate=${paystate}&startDate=${startDate}&endDate=${endDate}&disposestate=${disposestate}">上一页</a>
						<a id="next"  style="font-size: large;" href="Purchase?option=queryPur&page=${page + 1 }&purchaseid=${purchaseid }&suppliername=${suppliername}&paystate=${paystate}&startDate=${startDate}&endDate=${endDate}&disposestate=${disposestate}">下一页</a>
						<a id="end"   style="font-size: large;" href="Purchase?option=queryPur&page=${totalPage }&purchaseid=${purchaseid }&suppliername=${suppliername}&paystate=${paystate}&startDate=${startDate}&endDate=${endDate}&disposestate=${disposestate}">末页</a>
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
				</c:if>
			</div>
			
		</div>


	</body>
</html>
