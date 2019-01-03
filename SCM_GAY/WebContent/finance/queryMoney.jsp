<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
		<title>新添采购单</title>
		
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
				<td nowrap class="title1">财务收支 -- 收支查询</td>
			  </tr>
			</table>
			
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			  <tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp; </td>
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
			<form action="Finance" method="post">
			<div class="query_div">
				相关单据号：<input type="text" id="id" name="id" value="${id }"/>
				收支类型：
				<select id="venderCode" name="inOrOut">
					<option value="in">收入 </option>
					<option value="out">支出 </option>
				</select>
				付款方式：
					<select id="paystate" name="paystate">
						<option value="">请选择</option>
						<option value="1">货到付款</option>
						<option value="2">款到发货</option>
						<option value="3">预付款到发货</option>
					</select>
				日期段：
				<input class="Wdate" type="text" id="startDate" name="startDate" onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
				-
				<input class="Wdate" type="text" id="endDate" name="endDate" onFocus="WdatePicker({isShowClear:true,readOnly:true})"/>
				<input type="button" value="查询" onclick="check()"/>
				<input type="hidden" name="option" value="queryAll">
				<script type="text/javascript">
					function check(){
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
			</form>
			<div id="dataList">
				<table width="100%" border="0" align="center" cellspacing="1" class="c">
					<tr>
						<td class="title1">收款（付款）日期</td>
						<td class="title1">相关单据号</td>
						<td class="title1">收款（付款）金额</td>
						<td class="title1">经手人</td>
						<td class="title1">单据付款方式</td>
					</tr>
					<c:forEach items="${finInfoList }" var="finInfo">
					<tr>
						<td align="center">${finInfo.date }</td>
						<td align="center">${finInfo.purchaseid }${finInfo.salebillid }</td>
						<td align="center">${finInfo.totalprices}</td>
						<td align="center">${finInfo.handle }</td>
						<c:choose>
   							<c:when test="${finInfo.paystate eq '1'}"> 
   								  <td align="center">货到付款</td>
   							</c:when>
   							<c:when test="${finInfo.paystate eq '2'}"> 
   								  <td align="center">款到发货</td>
   							</c:when>
   							<c:otherwise>  
   								<td align="center">预付款到发货</td>
   							</c:otherwise>
						</c:choose>	
					</tr>			
					</c:forEach>
					<tr style="display:none"><td colspan="10" name="detail"></td></tr>
				<tr style="display:none"><td colspan="10" name="detail"></td></tr>
				</table>
				<c:if test="${!empty finInfoList }">
				<div class="pageDiv">
					当前第<span id="currentPage">${page }</span>页
						<a id="start" style="font-size: large;" href="Finance?option=queryAll&page=1&id=${id }&paystate=${paystate}&startDate=${startDate}&endDate=${endDate}&inOrOut=${inOrOut}" >首页</a>
						<a id="last"  style="font-size: large;" href="Finance?option=queryAll&page=${page - 1 }&id=${id }&paystate=${paystate}&startDate=${startDate}&endDate=${endDate}&inOrOut=${inOrOut}">上一页</a>
						<a id="next"  style="font-size: large;" href="Finance?option=queryAll&page=${page + 1 }&id=${id }&paystate=${paystate}&startDate=${startDate}&endDate=${endDate}&inOrOut=${inOrOut}">下一页</a>
						<a id="end"   style="font-size: large;" href="Finance?option=queryAll&page=${totalPage }&id=${id }&paystate=${paystate}&startDate=${startDate}&endDate=${endDate}&inOrOut=${inOrOut}">末页</a>
					共<span id="totalPage">${totalPage }</span>页 ${linesNum }条记录
				</div>
				</c:if>
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