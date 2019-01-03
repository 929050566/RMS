<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@page pageEncoding="utf-8"%>
<html>
	<head>
		<title>库存管理</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../script/common.js" ></script>
		<script type="text/javascript" src="../script/productDiv.js" ></script>
		<script type="text/javascript" src="../script/My97DatePicker/WdatePicker.js" ></script>
		<script type="text/javascript">
			function change(){
				var per =  document.getElementById("number").value;
				var pan = document.getElementById("pan").value;
				document.getElementById("inNum").value=pan-per;
				if(pan-per<0){
					document.getElementById("state").value="损耗"
				}else if(pan-per>0){
					document.getElementById("state").value="盘余"
				}
			}
		
		
			function update(){
				document.getElementById("m").style.display="none";
				document.getElementById("add").style.display="block";
			}
			function re(){
				document.getElementById("m").style.display="block";
				document.getElementById("add").style.display="none";
			}
			
			
		</script>
	</head>

	<body>
	<div id="m">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
	  <tr>
		<td nowrap class="title1">您的位置：库存管理－－库存盘点</td>
	  </tr>
	</table>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
		<td width="30px" nowrap class="toolbar">&nbsp;</td>
		<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" ></td>
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
	</div>
	<div class="query_div">
	<form action="type?">
		<input type="hidden" name="option" value="aftercount"/>
		产品编号：<input type="text" value="${proid}" name="proid"  readonly/></br>
		</br>
		当前库存：<input type="text" value="${number}" name="number" id="number" readonly/></br>
		</br>
		盘后库存：<input type="text" name="pan" id="pan" onchange="change()"/></br>
		</br>
		变化数量：<input type="text" name="inNum" id="inNum" readonly/></br>
		</br>
		变化类型：<input type="text" name="state" id="state" readonly/></br>
		</br>
		损益原因：</br>
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <textarea rows="10" cols="20" name="reason" ></textarea>
		<input type="submit"/>
	</form>		
	</div>
	</body>
</html>