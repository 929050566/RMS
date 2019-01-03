
var rowlength; //每行多少个单元
var spxxTable;
var rowIndex;
function init() {
	rowlength = document.getElementById("spxxTable").rows[0].cells.length;
	spxxTable = document.getElementById("spxxTable");
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
function editAdvanPrice(){
	var paystate = document.getElementsByName("paystate")[0].value ;
	var advanceprice = document.getElementsByName("advanceprice")[0];
	if(paystate == '3'){
		advanceprice.removeAttribute("readonly");
	}else{
		advanceprice.setAttribute("readonly","readonly");
	}
}
function setSerial(){
	var detailTable = document.getElementById("detailTable");
	var detailTableLen = detailTable.rows.length;
	for (i = 1; i <= detailTableLen - 1; i++){
		detailTable.rows[i].cells[0].innerHTML = i;
	}
}
//逻辑控制
function choiceAnonymous() {
	var len = spxxTable.rows.length;
	var returnValue;
	var i;
	for (i = 1; i < len - 1; i++) {
		if (spxxTable.rows[i].cells[0].innerHTML == "\u221a") {
			returnValue = choice(i);
			setValue();
			hiddenDiv();
			return;
		}
	}
	alert("\u8bf7\u5148\u9009\u62e9\u5546\u54c1");
	function setValue() {
		var detailTable = document.getElementById("detailTable");
		var length = detailTable.rows.length;
		var spbm = document.getElementsByName("proid");
		var spmc = document.getElementsByName("proname");
		var sptj = document.getElementsByName("prounit");
		var spzl = document.getElementsByName("spzl");
		spbm[rowIndex].value = returnValue[0];
		spmc[rowIndex].value = returnValue[1];
		sptj[rowIndex].value = returnValue[2];
		spzl[rowIndex].value = returnValue[3];
	}
}
//逻辑控制
function choiceAnonymousToDetail() {
	var len = spxxTable.rows.length;
	var returnValue;
	var i;
	//得到所有的 已在明细表中的标号
	var detailTable = document.getElementById("detailTable");
	var detailTableLen = detailTable.rows.length;
	var proIds = new Array(detailTableLen);
	for (i = 1; i < detailTableLen - 1; i++){
		proIds[i-1] = detailTable.rows[i].cells[1].firstChild.value;
	}
	//============================================
	for (i = 1; i < len - 1; i++) {
		if (spxxTable.rows[i].cells[0].innerHTML == "\u221a") {
			returnValue = choice(i);
			var flag = true;
			for (i = 1; i < detailTableLen - 1; i++){
				if(proIds[i-1] == returnValue[0]) {
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
		var proid = document.getElementsByName("proid");
		var proname = document.getElementsByName("proname");
		var prounit = document.getElementsByName("prounit");
		proid[rowIndex].value = returnValue[0];
		proname[rowIndex].value = returnValue[1];
		prounit[rowIndex].value = returnValue[2];
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
function choice(index) {
	var row = document.getElementById("spxxTable").rows[index];
	var result = new Array(rowlength);
	var i;
	for (i = 1; i < rowlength; i++) {
		result[i - 1] = row.cells[i].innerHTML;
	}
	return result;
}
function choiceSpxx(rowIndex_) {
	showDiv();
	rowIndex = rowIndex_;
}
function choiceSpxxToDetail(td){
	var tr = td.parentNode.parentNode.parentNode;
	showDiv();
	//需要减1 因为还有一个表头
	rowIndex = tr.rowIndex-1;
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
	oCell.innerHTML = "<input type='text' name='proname' size='15' readonly='readonly'>";
	oCell = oRow.insertCell(3);
	oCell.innerHTML = "<input type='text' name='prounit' size='10' value='0' readonly='readonly'>";
	oCell = oRow.insertCell(4);
	oCell.innerHTML = "<input type='text'  size='10' name='pronum' value='0' onchange='changePrice(this)'>";
	oCell = oRow.insertCell(5);
	oCell.innerHTML = "<input type='text'  size='10' name='unitprice' value='0.0' onchange='changePrice(this)'>";
	oCell = oRow.insertCell(6);
	oCell.innerHTML = "<input type='text'  size='10' name='totalprice' value='0.0' readonly='readonly'>";

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
 

function clearTable() {
	var trs = spxxTable.rows;
	for (var i = 1; i < trs.length - 1; i += 1) {
		trs[i].cells[0].innerHTML = "";
		var tds = trs[i].cells;
		for (var j = 0; j < tds.length; j += 1) {
			tds[j].style.backgroundColor = "#fff7e5";
		}
	}
	
}

