<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>库存查询</title>
		
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
				<td nowrap class="title1">库存管理 -- 库存查询</td>
			  </tr>
			</table>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			 <tr>
				<td nowrap="" class="toolbar">&nbsp;</td>
				<td width="60px" nowrap="" class="toolbar" onmouseover="OMO(event)" onmouseout="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap="" class="toolbar"></td>
				<td width="60px" nowrap="" class="P" onmouseover="OMO(event)" onmouseout="OMOU(event)"></td>
				<td width="20px" nowrap="" class="toolbar"></td>
				<td width="80px" nowrap="" class="P" onmouseover="OMO(event)" onmouseout="OMOU(event)"></td>
				<td width="20px" nowrap="" class="toolbar"></td>
				<td width="60px" nowrap="" class="toolbar" onmouseover="OMO(event)" onmouseout="OMOU(event)"></td>
				<td width="20px" nowrap="" class="toolbar"></td>
			  </tr>
			</table>
			
				
			
				<form action="type" method="post"> 
				
					<div>
						产品编号:<input type="text" name="proid"/>
						产品名称:<input type="text" name="proname"/>
						库存数量范围:<input type="number" min='0' name="minnum"/> ～
									<input type="number" name="maxnum"/>
									<input type="hidden" name="option" value="findlink">
						&nbsp <input  type="submit" />
					</div>
				
				</form>
				<div id="dataList">
				<table width="100%" border="0" align="center" cellspacing="1" class="c">
					
					
				
					<tr style="display:none"><td colspan="10" name="detail"></td></tr>
					<tr>
						<td class="title1" colspan="2">产品编号</td>
						<td class="title1" colspan="2">产品名称</td>
						<td class="title1" colspan="2">当前库存</td>
						<td class="title1" colspan="2">采购在途数</td>
						<td class="title1" colspan="2">预销售数</td>
						
					</tr>
			
					<tr>
						<td align="center" colspan="2">20170621142653</td>
						<td align="center" colspan="2"><a href="type?option=kd">被子</a></td>
						<td align="center" colspan="2">6</td>
						<td align="center" colspan="2">2</td>
						<td align="center" colspan="2">4</td>
						
					</tr>
					
			
				<c:forEach items="${counts}" var="c">
                  <tr >
                    <td align="center" colspan="2">${c.proID}</td>
                    <td align="center" colspan="2"><a href="type?option=kd&proid=${c.proID}&proname=${c.proName}">${c.proName}(可修改)</a></td>
                    <td align="center" colspan="2">${c.presentNum}</td>
                    <td align="center" colspan="2">${c.onPurchaseNum}</td>
                    <td align="center" colspan="2">${c.onPresaleNum}</td>
                  </tr>
                </c:forEach>
				
			
				</table>
				<c:if test="${ ! empty counts }">
				<div class="pageDiv">
					当前第<span id="currentPage">${pages }</span>页
						<a id="start" style="font-size: large;" href="type?option=find&pages=1"  >首页</a>
						<a id="last"  style="font-size: large;"  href="type?option=find&pages=${pages-1}">上一页</a>
						<a id="next"  style="font-size: large;" href="type?option=find&pages=${pages+1}">下一页</a>
						<a id="end"   style="font-size: large;"  href="type?option=find&pages=${totalpages}" >末页</a>
					共<span id="totalPage">${totalpages }</span>页 ${n }条记录
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