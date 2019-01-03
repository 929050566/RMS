function checkDel(msg){
	if (window.confirm(msg)){
		return true;
	}else{
		return false;
	}
}

function delltype(obj){
	var tr = obj.parentNode.parentNode;
	var id = tr.cells[0].innerHTML;
	
	var res= window.confirm("delete?");
	if(res==true){

		window.location='ProductServlet?option=deletetype&typeid='+id;
	}
}
function intoupdatetype(obj){
	var tr = obj.parentNode.parentNode;
	var id = tr.cells[0].innerHTML;
	
	window.location='ProductServlet?option=updatetype&uptypeid='+id;
}

function updateType(){
	var name =document.getElementById("typename").value;
	var typecom =document.getElementById("typecom").value;
	var id =document.getElementById("typeid").value;
	
	window.location='ProductServlet?option=updatetypedel&id='+id+'&name='+name+'&typecom='+typecom;
}

function deleteproduct(obj){
	var tr = obj.parentNode.parentNode;
	var id = tr.cells[0].innerHTML;
	
	var res= window.confirm("delete?");
	if(res==true){

		window.location='ProductServlet?option=deletepro&proid='+id;
	}
}
/*function savetosql(){
	var saleid = document.getElementById("poId").value;
	var vName = document.getElementById("vName").value;
	var createper = document.getElementById("createper").value;
	var tipFee = document.getElementById("tipFee").value;
	var productTotal = document.getElementById("productTotal").value;
	var payType = document.getElementById("payType").value;
	var prePayFee = document.getElementById("prePayFee").value;
	var remark = document.getElementById("remark").value;
	
	var table = document.getElementById("detailTable");
	var tr = table.rows;
	for(var i=0;i<tr.length;i++){
		var tds = tr[i].cells;
		window.alert(tds[0].innerHTML+"-"+tds[1].innerHTML);
	}
	//window.location='SaleManageServlet?option=addsale&proid='+saleid+'&vName='+vName+'&createper='+createper+'&tipFee='+tipFee+'&productTotal='+productTotal+'&payType='+payType+'&prePayFee='+prePayFee+'&remark='+remark;

}*/