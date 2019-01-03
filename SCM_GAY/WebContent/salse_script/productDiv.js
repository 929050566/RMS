
var rowlength; //每行多少个单元
var spxxTable;
var rowIndex;
var supTable;
var rowlen;
var s=0;
function init() {
	rowlength = document.getElementById("spxxTable").rows[0].cells.length;
	spxxTable = document.getElementById("spxxTable");
	supTable = document.getElementById("supTable");
	rowlen=document.getElementById("supTable").rows[0].cells.length; 
	var createTime=document.getElementById("createTime");
	var purchaseid=document.getElementById("purchaseid");
	var myDate = new Date();
	 var mytime=myDate.toLocaleTimeString();
	var y = myDate.getFullYear();
	var mon = myDate.getMonth();
	var d = myDate.getDate();

	var h=myDate.getHours();
	var m=myDate.getMinutes();
	var s=myDate.getSeconds();
	createTime.value=y+"-"+mon+"-"+d+h+":"+m+":"+s;
	purchaseid.value=y.toString()+mon.toString()+d.toString()+h.toString()+m.toString()+s.toString();
}
function product(){
	var stsl =document.getElementById("stsl").value;
	s=s+stsl;
	var productTotal=document.getElementById("productTotal").value;
	productTotal.value=s;
}
//改变数量或者单价时
function changePrice(input){
	//拿到明细表
	var detailTable = document.getElementById("detailTable");
	//拿到触发onchange时间的 input标签所在的tr的索引
	var index = input.parentNode.parentNode.rowIndex;
	//拿到数量
	var num = parseInt(detailTable.rows[index].cells[4].firstChild.value);
	//拿到单价
	var nuitPrice = parseFloat(detailTable.rows[index].cells[5].firstChild.value);
	//将明细价格设置为数量乘以 单价
	detailTable.rows[index].cells[6].firstChild.value = num*nuitPrice;
	//将每一个明细价相加 用来设置产品总价 
	var detailTableLen = detailTable.rows.length;
	var totalProPrice = 0;
	for (i = 1; i <= detailTableLen - 1; i++){
		totalProPrice = totalProPrice + parseFloat(detailTable.rows[i].cells[6].firstChild.value);
	}
	//设置产品总价
	document.getElementsByName("totalproprices")[0].value = totalProPrice;
	changeTotalPrice();
}
//改变额外费用 和 产品总价时 
function changeTotalPrice(){
	//得到产品总价
	var totalProPrice = document.getElementsByName("totalproprices")[0].value ;
	//得到额外费用
	var  extramoney = document.getElementsByName("extramoney")[0].value ;
	//将采购单总价设置成 产品总价加额外费用
	document.getElementsByName("totalprices")[0].value = parseFloat(totalProPrice) + parseFloat(extramoney);
}
//逻辑控制
function choiceAnonymous() {
	var len = spxxTable.rows.length;
	var returnValue;
	var i;
	var detailTable = document.getElementById("detailTable");
	var detailTableLen = detailTable.rows.length;
	var proIds = new Array(detailTableLen);
	for (i = 1; i < detailTableLen - 1; i++){
		proIds[i-1] = detailTable.rows[i].cells[1].firstChild.value;
	}
	//============================================
	for (i = 1; i < len ; i++) {
		if (spxxTable.rows[i].cells[0].innerHTML == "\u221a") {
			returnValue = choice(i);
			var flag = true;
			for (j = 1; j < detailTableLen ; j++){
				if(proIds[j-1] == returnValue[0]) {
					alert("不可添加，该产品已经在明细中");
					flag = false;
					break;
				}
			}
			
			if(flag){
				
				setValue();
				hiddenDiv();
				return;
			}
		}
	}
	if(flag != false){
		alert("\u8bf7\u5148\u9009\u62e9\u5546\u54c1");
	}

	function setValue() {
		var detailTable = document.getElementById("detailTable");
		var length = detailTable.rows.length;
		var spbm = document.getElementsByName("proid");
		var spmc = document.getElementsByName("proname");
		var ytsl = document.getElementsByName("prounit");
		
		
		
		spbm[rowIndex].value = returnValue[0];
		spmc[rowIndex].value = returnValue[1];
		ytsl[rowIndex].value = returnValue[2];
		
	}
}
function choice2Anonymous() {
	var len = supTable.rows.length;
	var returnValue;
	var i;
	for (i = 1; i < len - 1; i++) {
		if (supTable.rows[i].cells[0].innerHTML == "\u221a") {
			returnValue = choice2(i);
			setValue();
			hidden2Div();
			return;
		}
	}
	function setValue() {
	 var headTable=document.getElementById("headTable");
	 var sup =document.getElementById("supplier");
	 sup.value=returnValue[1];
	}
}	
function selectItem(tr) {
	clearTable();
	tr.cells[0].innerHTML = "\u221a";
	var tds = tr.cells;
	for (var j = 0; j < tds.length; j += 1) {
		tds[j].style.backgroundColor = "#C1CDD8";
	}
}
function selectItem2(tr) {
	clear2Table();
	tr.cells[0].innerHTML = "\u221a";
	var tds = tr.cells;
	for (var j = 0; j < tds.length; j += 1) {
		tds[j].style.backgroundColor = "#C1CDD8";
	}
}
function choice(index) {
	var row = document.getElementById("spxxTable").rows[index];
	var result = new Array(rowlength);
	var i;
	for (i = 1; i < rowlength; i++) {
		result[i - 1] = row.cells[i].innerHTML;
	}
	return result;
}
function choice2(index) {
	var row = document.getElementById("supTable").rows[index];
	var result = new Array(rowlen);
	var i;
	for (i = 1; i < rowlen; i++) {
		result[i - 1] = row.cells[i].innerHTML;
		
	}
	return result;
}
function choiceSpxx(rowIndex_) {
	showDiv();
	rowIndex = rowIndex_;
	}
function choice2Spxx(rowIndex_) {

	show2Div();
	rowIndex = rowIndex_;
	}	

  //添加一行
function addItem() {
	var detailTable = document.getElementById("detailTable");
	var oRow = detailTable.insertRow(-1);//在表格最后添加一行
	oRow.align = "center";
	oRow.className = "toolbar";
	oCell = oRow.insertCell(0);//添加单元格
	oCell.innerHTML = oRow.rowIndex;
	oCell = oRow.insertCell(1);
	oCell.innerHTML = "<input type='text'  name='proid' size='10' readonly> <span class='LL'><image src='../images/selectDate.gif' onClick='choiceSpxx(\"" + (oRow.rowIndex - 1) + "\")'></span>";
    
    // oCell.class= ;
	oCell = oRow.insertCell(2);
	oCell.innerHTML = "<input type='text' name='proname' size='15' readonly>";
	oCell = oRow.insertCell(3);
	oCell.innerHTML = "<input type='text' name='prounit' size='10'  readonly>";
	oCell = oRow.insertCell(4);
	oCell.innerHTML = "<input type='text' id='sptj' size='10' value='0' name='pronum' onchange='changePrice(this)' >";
	oCell = oRow.insertCell(5);
	oCell.innerHTML = "<input type='text' id='spzl' size='10' value='0' name='unitprice' onchange='changePrice(this)'>";
	oCell = oRow.insertCell(6);
	oCell.innerHTML = "<input type='text' id='stsl' size='10' value='0' name='totalprice' onchange='product()' readonly>";

	oCell = oRow.insertCell(7);
	oCell.innerHTML = "<image src=\"../images/delete.gif\" class=\"LL\" onclick=\"delItem(" + oRow.rowIndex + ")\"/>";
}
	//删除行,注意这里的行号全部要重新计算 刷新的
function delItem(index) {
	var detailTable = document.getElementById("detailTable");
	detailTable.deleteRow(index);
	var rowNum = detailTable.rows.length;
	var rowlength = detailTable.rows[0].cells.length;
	for (i = index; i < rowNum; i++) {
		detailTable.rows[i].cells[0].innerHTML = i;
		detailTable.rows[i].cells[rowlength - 1].innerHTML = "<image src=\"../images/delete.gif\" class=\"LL\" onclick=\"delItem(" + i + ")\"/>";
	}
}
function hiddenDiv() {
	document.getElementById("productDiv").style.visibility = "hidden";
	clearTable();
}
function showDiv(){
	document.getElementById("productDiv").style.visibility = "visible";
	
}
function hidden2Div() {
	document.getElementById("suppDiv").style.visibility = "hidden";
	clear2Table();
}
function show2Div(){
	document.getElementById("suppDiv").style.visibility = "visible";
	
}
function clearTable() {
	var trs = spxxTable.rows;
	for (var i = 1; i < trs.length ; i += 1) {
		trs[i].cells[0].innerHTML = "";
		var tds = trs[i].cells;
		for (var j = 0; j < tds.length; j += 1) {
			tds[j].style.backgroundColor = "#fff7e5";
		}
	}
	
}
function clear2Table() {
	var trs = supTable.rows;
	for (var i = 1; i < trs.length - 1; i += 1) {
		trs[i].cells[0].innerHTML = "";
		var tds = trs[i].cells;
		for (var j = 0; j < tds.length; j += 1) {
			tds[j].style.backgroundColor = "#fff7e5";
		}
	}
	
}
var xhr = false;
//创建ajax核心对象XMLHttpRequest
function createXMLHttpRequest(){
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest();
	}else if(window.ActiveXObject){
		try{
			xhr = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e1){
			try{
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e2){
				xhr = false;
			}
		}
	}
}

//记录响应过程
function processResponse(){
	var supplieidresult = document.getElementById("supplieidresult");
	//window.alert(xhr.readyState);
	if(xhr.readyState == 4){
		//window.alert(xhr.status);
		if(xhr.status == 200){
			supplieidresult.innerHTML = xhr.responseText;
		}else{
			window.alert("出错了");
		}
	}
}

//发送请求
function sendRequest(url,data){
	createXMLHttpRequest();
	xhr.open("post",url,true);
	xhr.onreadystatechange = processResponse;
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send(data);	
}

function checksupplieid(){
	var reg=/[0-9a-zA-Z]{4,20}/
	var supplieid = document.getElementById("supplieid").value;
	if(supplieid == ""){
		document.getElementById("supplieidresult").innerHTML = "供应商编号不能为空";
		document.getElementById("supplieid").focus();
	}if(reg.test(supplieid)==false){
		document.getElementById("supplieidresult").innerHTML = "请输入4-20个字符（字母或数字）";
		document.getElementById("supplieid").focus();
	}else{
		document.getElementById("supplieidresult").innerHTML = "正在验证供应商编号。。。。";
		sendRequest("supplier","option=checksupplieid&supplieid="+supplieid);
	}
}
function checksuppliername(){
	var suppliername = document.getElementById("suppliername").value;
	if(suppliername == ""){
		document.getElementById("suppliernameresult").innerHTML = "供应商名称不能为空";
		document.getElementById("suppliername").focus();
	}else{
		document.getElementById("suppliernameresult").innerHTML = "";
	}
}
function checkvelaname(){
	var velaname = document.getElementById("velaname").value;
	if(velaname == ""){
		document.getElementById("velanameresult").innerHTML = "联系人不能为空";
		document.getElementById("velaname").focus();
	}else{
		document.getElementById("velanameresult").innerHTML = "";
	}
}
function checkphone(){
	var phone = document.getElementById("phone").value;
	if(phone == ""){
		document.getElementById("phoneresult").innerHTML = "电话不能为空";
		document.getElementById("phone").focus();
	}else{
		document.getElementById("phoneresult").innerHTML = "";
	}
}