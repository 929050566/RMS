<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>入库登记</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../script/common.js" ></script>
		<script type="text/javascript" src="../script/productDiv.js" ></script>
		<script type="text/javascript" src="../script/My97DatePicker/WdatePicker.js" ></script>
		<script type="text/javascript">
				function fa1(){
					location.href="into?option=instock&state=1"
				}
				function fa2(){
					location.href="into?option=instock&state=2"
				}
				function fa3(){
					location.href="into?option=instock&state=3"
				}
				function time(){
					
					var msg = "确定入库？\n\n 请确定！";
					if(confirm(msg)==true){
						return true;
					}else{
						return false;
					}
				}
		</script>
			
		<script type="text/javascript">
					var currentPage = $("#currentPage").text();
					var totalPage = $("#totalPage").text();
					if(currentPage == totalPage){
						$("#next").removAttr('href')
						$("#end").removAttr('href')
						$("#end").css("color","red");
						$("#next").css("color","red");
					}else if(currentPage == '1'){
						$("#start").removAttr('href')
						$("#last").removAttr('href')
						$("#start").css("color","red");
						$("#last").css("color","red");
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
				<td nowrap class="title1">库存管理 -- 入库登记</td>
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
						<td class="title1">入库操作</td>
					</tr>
			
					
					<tr style="display:none"><td colspan="10" name="detail"></td></tr>
			
				<c:forEach items="${counts}" var="c">
                  
                  <tr >
                  	<td align="center" name="id" value="${c.purchaseid}"><a href="into?option=proidlink">${c.purchaseid}</a></td>
						<td align="center" name="time" value=" ">${c.createtime}</td>
						<td align="center">${c.suppliername}</td>
						<td align="center">${c.createname}</td>
						<td align="center">${c.extramoney}</td>
						<td align="center">${c.totalproprices}</td>
						<td align="center">${c.totalprices}</td>
						<td align="center" name="paystate" value="${c.paystate}">						
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
						</c:choose></td>
						<td align="center">${c.advanceprice}</td>
						<td align="center" name="di" value="${c.disposestate}">					
						<c:choose>
   							<c:when test="${c.disposestate  eq '1'}"> 
   								  新增
   							</c:when>
   							<c:when test="${c.disposestate eq '2'}"> 
   								  已发货
   							</c:when>
   							<c:when test="${c.disposestate eq '3'}"> 
   								 已付款
   							</c:when>
							<c:when test="${c.disposestate eq '4'}"> 
   								已了结
   							</c:when>
   							<c:otherwise>  
   								已预付
   							</c:otherwise>
						</c:choose>	</td>
                    	<td align="center">
							<a href="into?option=prow&paystate=${c.paystate}&id=${c.purchaseid}&di=${c.disposestate}" onclick="return time()">入库</a>
						</td>
					 </tr>
                 
                </c:forEach>
				<tr style="display:none"><td colspan="10" name="detail"></td></tr>
			
				</table>


				<div class="pageDiv">
					当前第<span id="currentPage">${pages}</span>页
					<a id="start" href="type?option=find&pages=1" class="font2">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				 	<a id="last" href="type?option=find&pages=${pages-1}" class="font2">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
            		<a id="next" href="type?option=find&pages=${pages+1}" class="font2">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
            		<a id="end" href="type?option=find&pages=${totalpages}" class="font2">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
           			 共<span id="totalPage"> ${totalpages}</span>页&nbsp;&nbsp;&nbsp;<span >${n}</span>条记录
							
				</div>
			
			
			</div>
		</div>


	</body>
</html>