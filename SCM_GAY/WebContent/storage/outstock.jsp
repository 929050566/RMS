<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>出库登记</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../script/common.js" ></script>
		<script type="text/javascript" src="../script/productDiv.js" ></script>
		<script type="text/javascript" src="../script/My97DatePicker/WdatePicker.js" ></script>
		<script type="text/javascript">
				function fa1(){
					location.href="out?option=outstock&state=1"
				}
				function fa2(){
					location.href="out?option=outstock&state=2"
				}
				function fa3(){
					location.href="out?option=outstock&state=3"
				}
				function time(){
		
					var msg = "确定出库？\n\n 请确定！";
					if(confirm(msg)==true){
						return true;
					}else{
						return false;
					}
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
				<td nowrap class="title1">库存管理 -- 出库登记</td>
			  </tr> 
			</table>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			 <tr>
				<td nowrap="" class="toolbar">&nbsp;</td>
				<td width="60px" nowrap="" class="toolbar" onmouseover="OMO(event)" onmouseout="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap="" class="toolbar">|</td>
				<td width="60px" nowrap="" class="P" onmouseover="OMO(event)" onmouseout="OMOU(event)" onclick="fa2()">款到发货</td>
				<td width="20px" nowrap="" class="toolbar">|</td>
				<td width="80px" nowrap="" class="P" onmouseover="OMO(event)" onmouseout="OMOU(event)" onclick="fa3()">预付款到发货</td>
				<td width="20px" nowrap="" class="toolbar">|</td>
				<td width="60px" nowrap="" class="toolbar" onmouseover="OMO(event)" onmouseout="OMOU(event)" onclick="fa1()">货到付款</td>
				<td width="20px" nowrap="" class="toolbar">|</td>
			  </tr>
			</table>
			
				
			<div id="dataList">
				<table width="100%" border="0" align="center" cellspacing="1" class="c">
					<tr>
						<td class="title1">销售单编号</td>
						<td class="title1">创建时间</td>
						<td class="title1">客户名称</td>
						<td class="title1">创建客户</td>
						<td class="title1">附加费用</td>
						<td class="title1">产品总价</td>
						<td class="title1">销售单总价格</td>
						<td class="title1">付款方式</td>
						<td class="title1">最低预付款金额</td>
						<td class="title1">处理状态</td>
						<td class="title1">出库操作</td>
					</tr>
			
					
					<tr style="display:none"><td colspan="10" name="detail"></td></tr>
			
					<c:forEach items="${List}" var="c">
                  
                  <tr >
                  	<td align="center" ><a href="out?option=proidlink">${c.salebillid}</a></td>
						<td align="center" name="time" value=" ">${c.createtime}</td>
						<td align="center">${c.customername}</td>
						<td align="center">${c.createname}</td>
						<td align="center">${c.extramoney}</td>
						<td align="center">${c.totalproprices}</td>
						<td align="center">${c.totalprices}</td>
						<td align="center" >				
							<c:choose>
	   							<c:when test="${c.paystate eq '1'}"> 
   								  	货到付款
	   							</c:when>
	   							<c:when test="${c.paystate eq '2'}"> 
	   								 款到发货
	   							</c:when>
	   							<c:otherwise>  
	   								预付款到发货
	   							</c:otherwise>
							</c:choose>					
						</td>
						<td align="center">${c.advanceprice}</td>
						<c:choose>
   							<c:when test="${c.disposestate  eq '1'}"> 
   								  <td align="center"> 新增</td>
   							</c:when>
   							<c:when test="${c.disposestate eq '2'}"> 
   								  <td align="center">已发货</td>
   							</c:when>
   							<c:when test="${c.disposestate eq '3'}"> 
   								  <td align="center">已付款</td>
   							</c:when>
							<c:when test="${c.disposestate eq '4'}"> 
   								  <td align="center">已了结</td>
   							</c:when>
   							<c:otherwise>  
   								<td align="center">已预付</td>
   							</c:otherwise>
						</c:choose>	
                    	<td align="center">
							<a href="out?option=outw&paystate=${c.paystate}&id=${c.salebillid}&di=${c.disposestate}" onclick="return time()">出库</a>
						</td>
					 </tr>
                 
                </c:forEach>
				<tr style="display:none"><td colspan="10" name="detail"></td></tr>
			
				</table>


				<div class="pageDiv">
					当前第<span id="currentPage">${page}</span>页
					<a id="start" href="out?option=outstock&page=1" class="font2">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				 	<a id="last" href="out?option=outstock&page=${page-1}" class="font2">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
            		<a id="next" href="out?option=outstock&page=${page+1}" class="font2">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
            		<a id="end" href="out?option=outstock&page=${totalPage}" class="font2">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
           			 共<span id="totalPage"> ${totalPage}</span>页&nbsp;&nbsp;&nbsp;<span >${linesNum}</span>条记录
							
				</div>
			
			
			</div>
		</div>


	</body>
</html>